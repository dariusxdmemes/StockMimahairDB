import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


const val URL = "jdbc:sqlite:src/main/resources/StockMimahair.sqlite"

fun main() {

    var isRunning = true

    while (isRunning) {
        println("MENÚ PRINCIPAL\n")
        println("1. Mostrar registros")
        println("2. Crear factura")
    }

}

object ProductosDAO {
    fun listarProductos(): List<ProductoBD> {
        val lista = mutableListOf<ProductoBD>()

        conectarBd(URL)?.use { conn ->
            conn.createStatement().use { stmt ->
                val rs = stmt.executeQuery("SELECT * FROM productos")
                while (rs.next()) {
                    lista.add(
                        ProductoBD(
                            id = rs.getInt("id"),
                            nombre_prod = rs.getString("nombre_prod"),
                            marca_prod = rs.getString("marca_prod"),
                            categoria_prod = rs.getString("categoria_prod"),
                            precio_prod = rs.getDouble("precio_prod"),
                            stock_prod = rs.getInt("stock_prod")
                        )
                    )
                }
            }
        } ?: println("No se pudo establecer la conexion")
        return lista
    }

    fun consultarProductoPorId(id: Int): ProductoBD? {
        var producto: ProductoBD? = null
        conectarBd(URL)?.use { conn ->
            conn.prepareStatement("SELECT * FROM productos WHERE id = ?").use { pstmt ->
                pstmt.setInt(1, id)
                val rs = pstmt.executeQuery()
                if (rs.next()) {
                    producto = ProductoBD(
                        id = rs.getInt("id"),
                        nombre_prod = rs.getString("nombre_prod"),
                        marca_prod = rs.getString("marca_prod"),
                        categoria_prod = rs.getString("categoria_prod"),
                        precio_prod = rs.getDouble("precio_prod"),
                        stock_prod = rs.getInt("stock_prod")
                    )
                }
            }
        } ?: println("No se pudo establecer la conexion")
        return producto
    }

    fun insertarProducto(nomProd: String, marcaProd: String, categProd: String, precioProd: Double, stockProd: Int) {
        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "INSERT INTO productos(nombre_prod, marca_prod, categoria_prod, precio_prod, stock_prod) VALUES (?, ?, ?, ?, ?)"
            ).use { pstmt ->
                pstmt.setString(1, nomProd)
                pstmt.setString(2, marcaProd)
                pstmt.setString(3, categProd)
                pstmt.setDouble(4, precioProd)
                pstmt.setInt(5, stockProd)
                pstmt.executeUpdate()
                println("Producto '$nomProd' insertado con éxito.")
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun actualizarProducto(nomProd: String, marcaProd: String, categProd: String, precioProd: Double, stockProd: Int, idProd: Int) {
        if (idProd == null) {
            println("No se puede actualizar un producto sin id.")
            return
        }
        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE productos SET nombre_prod = ?, marca_prod = ?, categoria_prod = ?, precio_prod = ?, stock_prod = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nomProd)
                pstmt.setString(2, marcaProd)
                pstmt.setString(3, categProd)
                pstmt.setDouble(4, precioProd)
                pstmt.setInt(5, stockProd)
                pstmt.setInt(6, idProd)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Producto con id: $idProd actualizado con éxito.")
                } else {
                    println("No se encontró ningun producto con id: $idProd.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun actualizarStock(cantStock: Int, idProd: Int) {
        if (idProd == null) {
            println("No se puede actualizar un producto sin id.")
            return
        }
        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE productos SET stock_prod = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setInt(1, cantStock)
                pstmt.setInt(2, idProd)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Producto con id: $idProd actualizado con éxito.")
                } else {
                    println("No se encontró ningun producto con id: $idProd.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }


    fun eliminarProducto(id: Int) {
        conectarBd(URL)?.use { conn ->
            conn.prepareStatement("DELETE FROM productos WHERE id = ?").use { pstmt ->
                pstmt.setInt(1, id)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Producto con id=$id eliminado correctamente.")
                } else {
                    println("No se encontró ningun producto con id=$id.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

}

object FacturaDAO {
    fun comprarProducto() {
        /* UPDATE restar STOCK de tabla PRODUCTOS
           INSERT nueva linea en LINEA_FACTURA */

        conectarBd(URL)?.use { conn ->
            try {
                conn.autoCommit = false
                // Esto resta la cantidad de producto del total de stock y lo actualiza
                conn.prepareStatement("UPDATE productos SET stock_prod = stock_prod - $cantidad WHERE id_prod = ?").use { stock ->
                    stock.setInt(1, idProd)
                    stock.executeUpdate()
                }

                // Añadir factura nueva:
                conn.prepareStatement("INSERT INTO factura VALUES(?, ?, ?)").use { factura ->
                    factura.setInt(1, idFactura)
                    factura.setInt(2, idCliente)
                    factura.setString(3, fechaFactura)
                }
            }
        }
    }
}


fun conectarBd(url: String): Connection? {
    return try {
        DriverManager.getConnection(url)
    } catch (e: SQLException) {
        e.printStackTrace()
        null
    }
}
