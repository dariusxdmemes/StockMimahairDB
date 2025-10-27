import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


const val URL = "jdbc:sqlite:src/main/resources/StockMimahair.sqlite"

fun main() {

    var isRunning = true

    while (isRunning) {
        println("MENÚ PRINCIPAL\n")
        println("1. Productos")
        println("2. Facturas")
        println("3. Clientes")
        println("4. Proveedores")
        println("5. Salir\n")
        print("Selecciona una opcion: ")
        val opcion = readln().toIntOrNull()
        when (opcion) {
            null -> println("\nLa opcion tiene que ser un número!\n")
            !in 1..5 -> println("\nSelecciona una opción entre las disponibles!\n")
            1 -> MenusDAO.menuProductos()
            2 -> MenusDAO.menuFacturas()
            3 -> MenusDAO.menuClientes()
            4 -> MenusDAO.menuProveedores()
            5 -> {
                println("\nHasta luego!\n")
                isRunning = false
            }
        }
    }
}

object MenusDAO {
    fun menuProductos() {
        var isRunning = true

        while (isRunning) {
            println("\nPRODUCTOS\n")
            println("1. Mostrar todos los productos")
            println("2. Mostrar un producto en específico")
            println("3. Modificar un producto existente")
            println("4. Añadir un producto")
            println("5. Eliminar un producto")
            println("6. Salir\n")
            print("Selecciona una opcion: ")
            val opcion = readln().toIntOrNull()
            when (opcion) {
                null -> println("\nLa opcion tiene que ser un número!\n")
                !in 1..6 -> println("Selecciona una opción entre las disponibles!\n")
                1 -> println()
                2 -> println()
                3 -> println()
                4 -> println()
                5 -> println()
                6 -> {
                println("\nVolviendo atrás...\n")
                isRunning = false
                }
            }
        }
    }

    fun menuFacturas() {
        var isRunning = true

        while (isRunning) {
            println("\nFACTURAS\n")
            println("1. Mostrar todas las facturas")
            println("2. Mostrar una factura en específico")
            println("3. Modificar una factura existente")
            println("4. Crear factura")
            println("5. Eliminar factura")
            println("6. Salir\n")
            print("Selecciona una opcion: ")
            val opcion = readln().toIntOrNull()
            when (opcion) {
                null -> println("\nLa opcion tiene que ser un número!\n")
                !in 1..6 -> println("Selecciona una opción entre las disponibles!\n")
                1 -> println()
                2 -> println()
                3 -> println()
                4 -> println()
                5 -> println()
                6 -> {
                    println("\nVolviendo atrás...\n")
                    isRunning = false
                }
            }
        }
    }

    fun menuClientes() {
        var isRunning = true

        while (isRunning) {
            println("\nCLIENTES\n")
            println("1. Mostrar todos los clientes")
            println("2. Mostrar un cliente en específico")
            println("3. Modificar un cliente existente")
            println("4. Añadir un cliente")
            println("5. Eliminar un cliente")
            println("6. Salir\n")
            print("Selecciona una opcion: ")
            val opcion = readln().toIntOrNull()
            when (opcion) {
                null -> println("\nLa opcion tiene que ser un número!\n")
                !in 1..6 -> println("Selecciona una opción entre las disponibles!\n")
                1 -> println()
                2 -> println()
                3 -> println()
                4 -> println()
                5 -> println()
                6 -> {
                    println("\nVolviendo atrás...\n")
                    isRunning = false
                }
            }
        }
    }

    fun menuProveedores() {
        var isRunning = true

        while (isRunning) {
            println("\nPROVEEDORES\n")
            println("1. Mostrar todos los proveedores")
            println("2. Mostrar un proveedor en específico")
            println("3. Modificar un proveedor existente")
            println("4. Añadir un proveedor")
            println("5. Eliminar un proveedor")
            println("6. Salir\n")
            print("Selecciona una opcion: ")
            val opcion = readln().toIntOrNull()
            when (opcion) {
                null -> println("\nLa opcion tiene que ser un número!\n")
                !in 1..6 -> println("Selecciona una opción entre las disponibles!\n")
                1 -> println()
                2 -> println()
                3 -> println()
                4 -> println()
                5 -> println()
                6 -> {
                    println("\nVolviendo atrás...\n")
                    isRunning = false
                }
            }
        }
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
                            stock = rs.getInt("stock")
                        )
                    )
                }
            }
        } ?: println("No se pudo establecer la conexion")
        return lista
    }

    fun mostrarDatos() {
        listarProductos().forEach { producto ->
            println("ID: ${producto.id}, Nombre: ${producto.nombre_prod}, Marca: ${producto.marca_prod}, Categoria: ${producto.categoria_prod}, Precio: ${producto.precio_prod}, Stock: ${producto.stock}")
        }
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
                        stock = rs.getInt("stock")
                    )
                }
            }
        } ?: println("No se pudo establecer la conexion")
        return producto
    }

    fun insertarProducto(nomProd: String, marcaProd: String, categProd: String, precioProd: Double, stockProd: Int) {
        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "INSERT INTO productos(nombre_prod, marca_prod, categoria_prod, precio_prod, stock) VALUES (?, ?, ?, ?, ?)"
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
                "UPDATE productos SET nombre_prod = ?, marca_prod = ?, categoria_prod = ?, precio_prod = ?, stock = ? WHERE id = ?"
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
                "UPDATE productos SET stock = ? WHERE id = ?"
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
    fun crearFactura() {

    }

    fun mostrarFactura() {

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
