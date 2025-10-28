import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.time.LocalDate
import java.time.format.DateTimeFormatter


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
            println("4. Comprar producto (TRANSACCIÓN)")
            println("5. Añadir un producto")
            println("6. Eliminar un producto")
            println("7. Salir\n")
            print("Selecciona una opcion: ")
            val opcion = readln().toIntOrNull()
            when (opcion) {
                null -> println("\nLa opcion tiene que ser un número!\n")
                !in 1..7 -> println("Selecciona una opción entre las disponibles!\n")
                1 -> ProductosDAO.mostrarProductos()
                2 -> ProductosDAO.mostrarProductoPorId()
                3 -> menuModificarProducto()
                4 -> ProductosDAO.comprarProductoTransaccion()
                5 -> ProductosDAO.anadirProducto()
                6 -> ProductosDAO.eliminarProducto()
                7 -> {
                println("\nVolviendo atrás...\n")
                isRunning = false
                }
            }
        }
    }
    fun menuModificarProducto() {
        var isRunning = true

        while (isRunning) {
            println("\nMODIFICAR PRODUCTO\n")
            println("1. Modificar nombre")
            println("2. Modificar marca")
            println("3. Modificar categoria")
            println("4. Modificar precio")
            println("5. Modificar stock")
            println("6. Volver\n")
            print("Selecciona una opcion: ")
            val opcion = readln().toIntOrNull()
            when (opcion) {
                null -> println("\nLa opcion tiene que ser un número!\n")
                !in 1..6 -> println("Selecciona una opción entre las disponibles!\n")
                1 -> ProductosDAO.modificarNombreProducto()
                2 -> ProductosDAO.modificarMarcaProducto()
                3 -> ProductosDAO.modificarCategoriaProducto()
                4 -> ProductosDAO.modificarPrecioProducto()
                5 -> ProductosDAO.modificarStockProducto()
                6 -> {
                    println("\nVolviendo atrás\n")
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
            println("3. Modificar fecha de una factura")
            println("4. Eliminar factura (TRANSACCIÓN)")
            println("5. Salir\n")
            print("Selecciona una opcion: ")
            val opcion = readln().toIntOrNull()
            when (opcion) {
                null -> println("\nLa opcion tiene que ser un número!\n")
                !in 1..5 -> println("Selecciona una opción entre las disponibles!\n")
                1 -> FacturaDAO.mostrarFacturasCompletas()
                2 -> FacturaDAO.consultarFacturaCompletaPorId()
                3 -> FacturaDAO.modificarFechaFactura()
                4 -> FacturaDAO.eliminarFacturaPorIdTransaccion()
                5 -> {
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
                1 -> ClienteDAO.mostrarTodosClientes()
                2 -> ClienteDAO.mostrarClientePorId()
                3 -> menuModificarClientes()
                4 -> ClienteDAO.anadirCliente()
                5 -> ClienteDAO.eliminarCliente()
                6 -> {
                    println("\nVolviendo atrás...\n")
                    isRunning = false
                }
            }
        }
    }
    fun menuModificarClientes() {
        var isRunning = true

        while (isRunning) {
            println("\nMODIFICAR CLIENTES\n")
            println("1. Modificar nombre")
            println("2. Modificar apellidos")
            println("3. Modificar telefono")
            println("4. Volver\n")
            print("Selecciona una opcion: ")
            val opcion = readln().toIntOrNull()
            when (opcion) {
                null -> println("\nLa opcion tiene que ser un número!\n")
                !in 1..4 -> println("Selecciona una opción entre las disponibles!\n")
                1 -> ClienteDAO.modificarNombreCliente()
                2 -> ClienteDAO.modificarApellidosCliente()
                3 -> ClienteDAO.modificarTlfCliente()
                4 -> {
                    println("\nVolviendo atrás\n")
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
                1 -> ProveedorDAO.mostrarTodosProveedores()
                2 -> ProveedorDAO.mostrarProveedorPorId()
                3 -> menuModificarProveedores()
                4 -> ProveedorDAO.anadirProveedor()
                5 -> ProveedorDAO.eliminarProveedor()
                6 -> {
                    println("\nVolviendo atrás...\n")
                    isRunning = false
                }
            }
        }
    }
    fun menuModificarProveedores() {
        var isRunning = true

        while (isRunning) {
            println("\nMODIFICAR PROVEEDORES\n")
            println("1. Modificar nombre")
            println("2. Modificar apellidos")
            println("3. Modificar localidad")
            println("4. Modificar telefono")
            println("5. Volver\n")
            print("Selecciona una opcion: ")
            val opcion = readln().toIntOrNull()
            when (opcion) {
                null -> println("\nLa opcion tiene que ser un número!\n")
                !in 1..5 -> println("Selecciona una opción entre las disponibles!\n")
                1 -> ProveedorDAO.modificarNombreProveedor()
                2 -> ProveedorDAO.modificarApellidosProveedor()
                3 -> ProveedorDAO.modificarLocalidadProeedor()
                4 -> ProveedorDAO.modificarTlfProveedor()
                5 -> {
                    println("\nVolviendo atrás\n")
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

    fun mostrarProductos() {
        listarProductos().forEach { producto ->
            println("ID: ${producto.id}, Nombre: ${producto.nombre_prod}, Marca: ${producto.marca_prod}, Categoria: ${producto.categoria_prod}, Precio: ${producto.precio_prod}€, Stock: ${producto.stock}")
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

    fun mostrarProductoPorId() {
        print("Introduce el id del producto a consultar: ")
        val id = readln().toIntOrNull()
        if (id == null) {
            println("Introduce un ID válido!")
        } else {
            val producto = consultarProductoPorId(id)
            if (producto != null) {
                println("ID: ${producto.id}, Nombre: ${producto.nombre_prod}, Marca: ${producto.marca_prod}, Categoria: ${producto.categoria_prod}, Precio: ${producto.precio_prod}€, Stock: ${producto.stock}")
            } else {
                println("No existe ningun producto con ese ID!")
            }
        }
    }

    fun anadirProducto() {
        var nomProd = ""
        var marcaProd = ""
        var categProd = ""
        var precioProd: Double? = null
        var stockProd: Int? = null

        while (nomProd.isBlank()) {
            print("Introduce el nombre del producto: ")
            val tempNombr = readln()
            if (tempNombr.isBlank()) {
                println("\nEl nombre no puede estar vacío!\n")
            } else {
                nomProd = tempNombr
            }
        }

        while (marcaProd.isBlank()) {
            print("Introduce la marca del producto: ")
            val tempMarca = readln()
            if (tempMarca.isBlank()) {
                println("\nLa marca no puede estar vacía!\n")
            } else {
                marcaProd = tempMarca
            }
        }

        while (categProd.isBlank()) {
            print("Introduce la categoria del producto: ")
            val tempCateg = readln()
            if (tempCateg.isBlank()) {
                println("\nLa categoría no puede estar vacía!\n")
            } else {
                categProd = tempCateg
            }
        }

        while (precioProd == null) {
            print("Introduce el precio: ")
            val tempPrecio = readln().toDoubleOrNull()
            if (tempPrecio == null) {
                println("\nEl formato del precio es incorrecto o lo estás dejando vacío! (Número decimal)\n")
            } else {
                precioProd = tempPrecio
            }
        }

        while (stockProd == null) {
            print("Introduce la cantidad de stock de este producto: ")
            val tempStock = readln().toIntOrNull()
            if (tempStock == null) {
                println("\nEl formato de stock es incrorrecto o lo estás dejando vacío! (Número entero)\n")
            } else {
                stockProd = tempStock
            }
        }

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
                println("\nProducto '$nomProd' insertado con éxito.\n")
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarNombreProducto() {
        println()
        mostrarProductos()
        println()

        var idProd: Int? = null
        var nuevoNombre = ""

        while (idProd == null) {
            print("\nIntroduce el ID del producto a modificar: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevoNombre.isBlank()) {
            print("\nIntroduce el nuevo nombre del producto: ")
            val tempNombre = readln()
            if (tempNombre.isBlank()) {
                println("\nEl nombre no puede estar vacío!\n")
            } else {
                nuevoNombre = tempNombre
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE productos SET nombre_prod = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevoNombre)
                pstmt.setInt(2, idProd)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Nombre del producto con id: $idProd actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun producto con el id: $idProd.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarMarcaProducto() {
        println()
        mostrarProductos()
        println()

        var idProd: Int? = null
        var nuevaMarca = ""

        while (idProd == null) {
            print("\nIntroduce el ID del producto a modificar: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevaMarca.isBlank()) {
            print("\nIntroduce la nueva narca del producto: ")
            val tempMarca = readln()
            if (tempMarca.isBlank()) {
                println("\nLa marca no puede estar vacía!\n")
            } else {
                nuevaMarca = tempMarca
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE productos SET marca_prod = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevaMarca)
                pstmt.setInt(2, idProd)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Marca del producto con id: $idProd actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun producto con el id: $idProd.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarCategoriaProducto() {
        println()
        mostrarProductos()
        println()

        var idProd: Int? = null
        var nuevaCategoria = ""

        while (idProd == null) {
            print("\nIntroduce el ID del producto a modificar: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevaCategoria.isBlank()) {
            print("\nIntroduce la nueva categoría del producto: ")
            val tempCategoria = readln()
            if (tempCategoria.isBlank()) {
                println("\nLa categoría no puede estar vacía!\n")
            } else {
                nuevaCategoria = tempCategoria
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE productos SET categoria_prod = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevaCategoria)
                pstmt.setInt(2, idProd)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Categoría del producto con id: $idProd actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun producto con el id: $idProd.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarPrecioProducto() {
        println()
        mostrarProductos()
        println()

        var idProd: Int? = null
        var nuevoPrecio: Double? = null

        while (idProd == null) {
            print("\nIntroduce el ID del producto a modificar: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevoPrecio == null) {
            print("\nIntroduce el nuevo precio del producto: ")
            val tempPrecio = readln().toDoubleOrNull()
            if (tempPrecio == null) {
                println("\nEl precio no puede estar vacío o formato incorrecto!\n")
            } else {
                nuevoPrecio = tempPrecio
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE productos SET precio_prod = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setDouble(1, nuevoPrecio)
                pstmt.setInt(2, idProd)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Precio del producto con id: $idProd actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun producto con el id: $idProd.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarStockProducto() {
        println()
        mostrarProductos()
        println()

        var idProd: Int? = null
        var nuevoStock: Int? = null

        while (idProd == null) {
            print("\nIntroduce el ID del producto a modificar: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevoStock == null) {
            print("\nIntroduce el nuevo stock del producto: ")
            val tempStock = readln().toIntOrNull()
            if (tempStock == null) {
                println("\nEl stock no puede estar vacío o error de formato!\n")
            } else {
                nuevoStock = tempStock
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE productos SET stock = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setInt(1, nuevoStock)
                pstmt.setInt(2, idProd)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Stock del producto con id: $idProd actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun producto con el id: $idProd.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun eliminarProducto() {
        println()
        mostrarProductos()
        println()

        var idProd: Int? = null

        while (idProd == null) {
            print("\nIntroduce el ID del producto a eliminar: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement("DELETE FROM productos WHERE id = ?").use { pstmt ->
                pstmt.setInt(1, idProd)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Producto con id=$idProd eliminado correctamente.")
                } else {
                    println("No se encontró ningun producto con id=$idProd.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun comprarProductoTransaccion() {
        /* 1 Mostrar stock
        *  2 Elegir producto
        *  3 Restar Stock producto
        *  4 Confirmar transacción */
        var idProducto: Int? = null
        var cantidad: Int? = null
        var idComprador: Int? = null

        val formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val fechaActual = LocalDate.now().format(formatoFecha)
        val fechaActualStr = fechaActual.toString()

        println("\nSTOCK:")
        mostrarProductos()
        println("\nCLIENTES:")
        ClienteDAO.mostrarNombresClientes()

        while (idComprador == null) {
            print("\nQuien está comprando? ID: ")
            val tempIdComprador = readln().toIntOrNull()
            if (tempIdComprador == null) {
                println("\nEl ID tiene que ser un número entero!\n")
            } else {
                idComprador = tempIdComprador
            }
        }

        while (idProducto == null) {
            print("\nIntroduce el ID del producto que quieras comprar: ")
            val tempIdProd = readln().toIntOrNull()
            if (tempIdProd == null) {
                println("\nEl ID ha de ser un número entero!\n")
            } else {
                idProducto = tempIdProd
            }
        }

        while (cantidad == null) {
            print("\nCuantas unidades deseas?: ")
            val tempCantidad = readln().toIntOrNull()
            if (tempCantidad == null) {
                println("\nLa cantidad tiene que ser un número entero!\n")
            } else {
                cantidad = tempCantidad
            }
        }

        conectarBd(URL)?.use { conn ->
            try {
                conn.autoCommit = false

                // Añadir factura
                var idFactura = 0
                conn.prepareStatement("INSERT INTO factura(id_cliente, fecha_factura) VALUES(?, ?)").use { pstmt ->
                    pstmt.setInt(1, idComprador)
                    pstmt.setString(2, fechaActualStr)
                    pstmt.executeUpdate()
                }

                // Almacenar id factura
                conn.createStatement().use { stmt ->
                    val rs = stmt.executeQuery("SELECT last_insert_rowid() AS id_factura")
                    if (rs.next()) idFactura = rs.getInt("id_factura")
                }

                // Restar stock
                conn.prepareStatement("UPDATE productos SET stock = stock - ? WHERE id = ?").use { pstmt ->
                    pstmt.setInt(1, cantidad)
                    pstmt.setInt(2, idProducto)
                    pstmt.executeUpdate()
                }

                // Añadir linea factura
                conn.prepareStatement("INSERT INTO linea_factura(id_factura, id_producto, cantidad) VALUES (?, ?, ?)").use { pstmt ->
                    pstmt.setInt(1, idFactura)
                    pstmt.setInt(2, idProducto)
                    pstmt.setInt(3, cantidad)
                    pstmt.executeUpdate()
                }

                // Confirmar cambios
                conn.commit()
                println("Transaccion realizada con éxito!")
            } catch (e: SQLException) {
                if (e.message?.contains("UNIQUE constraint failed") == true) {
                    println("Intento de insertar clave duplicada")
                    conn.rollback()
                    println("Transacción revertida!")
                } else {
                    throw e
                }
            } finally {
                println("Fin de la transacción")
            }
        }
    }

}

object FacturaDAO {
    fun consultarFacturaCompletaPorId() {
        var idFactura: Int? = null

        while (idFactura == null) {
            print("Introduce el ID de la factura que quieres ver: ")
            val tempIdFact = readln().toIntOrNull()
            if (tempIdFact == null) {
                println("ID inválido o formato incorrecto!")
            } else {
                idFactura = tempIdFact
                conectarBd(URL)?.use { conn ->
                    conn.prepareStatement("SELECT f.id_factura AS factura, f.fecha_factura AS fecha, c.nombre_cliente AS nombre, c.apellidos_cliente AS apellidos, l.id_linea AS linea, p.nombre_prod AS producto, l.cantidad, ROUND(p.precio_prod * l.cantidad, 2) AS total_linea FROM factura f JOIN clientes c ON f.id_cliente = c.id JOIN linea_factura l ON f.id_factura = l.id_factura JOIN productos p ON l.id_producto = p.id WHERE f.id_factura = ? ORDER BY f.id_factura, l.id_linea")
                        .use { pstmt ->
                            pstmt.setInt(1, idFactura)
                            val rs = pstmt.executeQuery()
                            while (rs.next()) {
                                println(
                                    "${rs.getInt("factura")} - ${rs.getString("fecha")} - ${rs.getString("nombre")} ${rs.getString("apellidos")} - Linea: ${
                                        rs.getInt(
                                            "linea"
                                        )
                                    } - ${rs.getString("producto")} - x${rs.getInt("cantidad")} ${rs.getDouble("total_linea")}€"
                                )
                            }
                        }
                } ?: println("No se pudo establecer la conexión")
            }
        }
    }

    fun mostrarFacturasCompletas() {
        conectarBd(URL)?.use { conn ->
            conn.createStatement().use { stmt ->
                val rs = stmt.executeQuery("SELECT f.id_factura AS factura, f.fecha_factura AS fecha, c.nombre_cliente AS nombre, c.apellidos_cliente AS apellidos, l.id_linea AS linea, p.nombre_prod AS producto, l.cantidad, ROUND(p.precio_prod * l.cantidad, 2) AS total_linea FROM factura f JOIN clientes c ON f.id_cliente = c.id JOIN linea_factura l ON f.id_factura = l.id_factura JOIN productos p ON l.id_producto = p.id ORDER BY f.id_factura, l.id_linea")
                println("\nFACTURAS COMPLETAS:\n")
                while (rs.next()) {
                    println("${rs.getInt("factura")} - ${rs.getString("fecha")} - ${rs.getString("nombre")} ${rs.getString("apellidos")} - Linea: ${rs.getInt("linea")} - ${rs.getString("producto")} - x${rs.getInt("cantidad")} ${rs.getDouble("total_linea")}€")
                }
            }
        } ?: println("No se pudo establecer la conexión")
    }

    fun modificarFechaFactura() {
        var idFactura: Int? = null
        var nuevaFechaFactura = ""

        while (idFactura == null) {
            print("\nIntroduce el ID de la factura la cual quieres modificar la fecha: ")
            val tempIdFact = readln().toIntOrNull()
            if (tempIdFact == null) {
                println("\nEl ID ha de ser un número entero!\n")
            } else {
                idFactura = tempIdFact
            }
        }

        while (nuevaFechaFactura.isBlank()) {
            print("\nIntroduce la nueva fecha [YYYY-MM-DD]: ")
            val tempFecha = readln()
            if (tempFecha.isBlank()) {
                println("\nLa fecha no puede estar vacía!\n")
            } else {
                nuevaFechaFactura = tempFecha
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement("UPDATE factura SET fecha_factura = ? WHERE id_factura = ?").use { pstmt ->
                pstmt.setString(1, nuevaFechaFactura)
                pstmt.setInt(2, idFactura)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Fecha de la factura con ID: $idFactura modificada a $nuevaFechaFactura")
                } else {
                    println("Error, no se encontró ninguna factura con el ID: $idFactura")
                }
            }
        } ?: println("No se pudo establecer la conexión")
    }

    fun eliminarFacturaPorIdTransaccion() {
        println()
        mostrarFacturasCompletas()
        println()

        var idFactura: Int? = null
        while (idFactura == null) {
            print("Introduce el ID de la factura a eliminar: ")
            val idFacturaTemp = readln().toIntOrNull()
            if (idFacturaTemp == null) {
                println("\nID inválido o formato incorrecto!")
            } else {
                idFactura = idFacturaTemp
            }
        }

        conectarBd(URL)?.use { conn ->
            try {
                conn.autoCommit = false

                // Eliminar linea factura
                conn.prepareStatement("DELETE FROM linea_factura WHERE id_factura = ?").use { pstmt ->
                    pstmt.setInt(1, idFactura)
                    pstmt.executeUpdate()
                }

                // Eliminar factura
                conn.prepareStatement("DELETE FROM factura WHERE id_factura = ?").use { pstmt ->
                    pstmt.setInt(1, idFactura)
                    pstmt.executeUpdate()
                }

                // Confirmar cambios
                conn.commit()
                println("Transacción realizada con éxito.")
            } catch (e: SQLException) {
                if (e.message?.contains("UNIQUE constraint failed") == true) {
                    println("Intento de insertar clave duplicada")
                    conn.rollback()
                    println("Transaccion revertida.")
                } else {
                    throw e
                }
            } finally {
                println("Fin del programa.")
            }
        }
    }
}

object ClienteDAO {
    fun mostrarNombresClientes() {
        conectarBd(URL)?.use { conn ->
            conn.createStatement().use { stmt ->
                val rs = stmt.executeQuery("SELECT id, nombre_cliente, apellidos_cliente FROM clientes")
                while (rs.next()) {
                    println("ID: ${rs.getInt("id")}, Nombre: ${rs.getString("nombre_cliente")}, Apellidos: ${rs.getString("apellidos_cliente")}")
                }
            }
        } ?: println("No se pudo establecer la conexión")
    }

    fun mostrarTodosClientes() {
        conectarBd(URL)?.use { conn ->
            conn.createStatement().use { stmt ->
                val rs = stmt.executeQuery("SELECT * FROM clientes")
                while (rs.next()) {
                    println("ID: ${rs.getInt("id")}, Nombre: ${rs.getString("nombre_cliente")}, Apellidos: ${rs.getString("apellidos_cliente")}, Teléfono: ${rs.getString("tlf_cliente")}")
                }
            }
        } ?: println("No se pudo establecer la conexión")
    }

    fun mostrarClientePorId() {
        var idCliente: Int? = null

        while (idCliente == null) {
            print("Introduce el ID del cliente que quieras ver: ")
            val tempIdCliente = readln().toIntOrNull()
            if (tempIdCliente == null) {
                println("ID inválido o formato incorrecto!")
            } else {
                idCliente = tempIdCliente
                conectarBd(URL)?.use { conn ->
                    conn.prepareStatement("SELECT * FROM clientes WHERE id = ?")
                        .use { pstmt ->
                            pstmt.setInt(1, idCliente)
                            val rs = pstmt.executeQuery()
                            while (rs.next()) {
                                println("ID: ${rs.getInt("id")}, Nombre completo: ${rs.getString("nombre_cliente")}, ${rs.getString("apellidos_cliente")}, Teléfono: ${rs.getString("tlf_cliente")}")
                            }
                        }
                } ?: println("No se pudo establecer la conexión")
            }
        }
    }

    fun anadirCliente() {
        var nomCliente = ""
        var apellCliente = ""
        var tlfCliente = ""

        while (nomCliente.isBlank()) {
            print("Introduce el nombre del nuevo cliente: ")
            val tempNombr = readln()
            if (tempNombr.isBlank()) {
                println("\nEl nombre no puede estar vacío!\n")
            } else {
                nomCliente = tempNombr
            }
        }

        while (apellCliente.isBlank()) {
            print("Introduce la marca del producto: ")
            val tempApell = readln()
            if (tempApell.isBlank()) {
                println("\nLa marca no puede estar vacía!\n")
            } else {
                apellCliente = tempApell
            }
        }

        while (tlfCliente.isBlank()) {
            print("Introduce la categoria del producto: ")
            val tempTlf = readln()
            if (tempTlf.isBlank()) {
                println("\nLa categoría no puede estar vacía!\n")
            } else {
                tlfCliente = tempTlf
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "INSERT INTO clientes(nombre_cliente, apellidos_cliente, tlf_cliente) VALUES (?, ?, ?)"
            ).use { pstmt ->
                pstmt.setString(1, nomCliente)
                pstmt.setString(2, apellCliente)
                pstmt.setString(3, tlfCliente)
                pstmt.executeUpdate()
                println("\nNuevo cliente: '$nomCliente' insertado con éxito.\n")
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun eliminarCliente() {
        println()
        mostrarTodosClientes()
        println()

        var idCliente: Int? = null

        while (idCliente == null) {
            print("\nIntroduce el ID del cliente a eliminar: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idCliente = tempId
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement("DELETE FROM clientes WHERE id = ?").use { pstmt ->
                pstmt.setInt(1, idCliente)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Cliente con id: $idCliente eliminado correctamente.")
                } else {
                    println("No se encontró ningun cliente con id: $idCliente.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarNombreCliente() {
        println()
        mostrarNombresClientes()
        println()

        var idCliente: Int? = null
        var nuevoNombre = ""

        while (idCliente == null) {
            print("\nIntroduce el ID del cliente para modificar su nombre: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idCliente = tempId
            }
        }

        while (nuevoNombre.isBlank()) {
            print("\nIntroduce el nuevo nombre del cliente: ")
            val tempNombre = readln()
            if (tempNombre.isBlank()) {
                println("\nEl nombre no puede estar vacío!\n")
            } else {
                nuevoNombre = tempNombre
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE clientes SET nombre_cliente = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevoNombre)
                pstmt.setInt(2, idCliente)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Nombre del cliente con id: $idCliente actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun cliente con el id: $idCliente.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarApellidosCliente() {
        println()
        mostrarNombresClientes()
        println()

        var idCliente: Int? = null
        var nuevoApellido = ""

        while (idCliente == null) {
            print("\nIntroduce el ID del cliente para modificar su apellido: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idCliente = tempId
            }
        }

        while (nuevoApellido.isBlank()) {
            print("\nIntroduce los nuevos apellidos del cliente: ")
            val tempNombre = readln()
            if (tempNombre.isBlank()) {
                println("\nLos apellidos no pueden estar vacíos!\n")
            } else {
                nuevoApellido = tempNombre
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE clientes SET apellidos_cliente = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevoApellido)
                pstmt.setInt(2, idCliente)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Apellidos del cliente con id: $idCliente actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun cliente con el id: $idCliente.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarTlfCliente() {
        println()
        mostrarNombresClientes()
        println()

        var idCliente: Int? = null
        var nuevoTlf = ""

        while (idCliente == null) {
            print("\nIntroduce el ID del cliente para modificar su teléfono: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idCliente = tempId
            }
        }

        while (nuevoTlf.isBlank()) {
            print("\nIntroduce el nuevo nombre del cliente: ")
            val tempTlf = readln()
            if (tempTlf.isBlank()) {
                println("\nEl nombre no puede estar vacío!\n")
            } else {
                nuevoTlf = tempTlf
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE clientes SET tlf_cliente = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevoTlf)
                pstmt.setInt(2, idCliente)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Teléfono del cliente con id: $idCliente actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun cliente con el id: $idCliente.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }
}

object ProveedorDAO {
    fun mostrarNombreProveedores() {
        conectarBd(URL)?.use { conn ->
            conn.createStatement().use { stmt ->
                val rs = stmt.executeQuery("SELECT id, nom_proveedor, apellidos_proveedor FROM proveedores")
                while (rs.next()) {
                    println("ID: ${rs.getInt("id")}, Nombre: ${rs.getString("nom_proveedor")}, Apellidos: ${rs.getString("apellidos_proveedor")}")
                }
            }
        } ?: println("No se pudo establecer la conexión")
    }

    fun mostrarTodosProveedores() {
        conectarBd(URL)?.use { conn ->
            conn.createStatement().use { stmt ->
                val rs = stmt.executeQuery("SELECT * FROM proveedores")
                while (rs.next()) {
                    println("ID: ${rs.getInt("id")}, Nombre: ${rs.getString("nom_proveedor")}, Apellidos: ${rs.getString("apellidos_proveedor")}, Localidad: ${rs.getString("localidad_proveedor")}, Teléfono: ${rs.getString("tlf_proveedor")}")
                }
            }
        } ?: println("No se pudo establecer la conexión")
    }

    fun mostrarProveedorPorId() {
        var idProveedor: Int? = null

        while (idProveedor == null) {
            print("Introduce el ID del proveedor que quieras ver: ")
            val tempIdProveedor = readln().toIntOrNull()
            if (tempIdProveedor == null) {
                println("ID inválido o formato incorrecto!")
            } else {
                idProveedor = tempIdProveedor
                conectarBd(URL)?.use { conn ->
                    conn.prepareStatement("SELECT * FROM proveedores WHERE id = ?")
                        .use { pstmt ->
                            pstmt.setInt(1, idProveedor)
                            val rs = pstmt.executeQuery()
                            while (rs.next()) {
                                println("ID: ${rs.getInt("id")}, Nombre completo: ${rs.getString("nom_proveedor")}, ${rs.getString("apellidos_proveedor")}, Localidad: ${rs.getString("localidad_proveedor")}, ${rs.getString("tlf_proveedor")}")
                            }
                        }
                } ?: println("No se pudo establecer la conexión")
            }
        }
    }

    fun anadirProveedor() {
        var nomProveedor = ""
        var apellProveedor = ""
        var localidProveedor = ""
        var tlfProveedor = ""

        while (nomProveedor.isBlank()) {
            print("Introduce el nombre del nuevo proveedor: ")
            val tempNombr = readln()
            if (tempNombr.isBlank()) {
                println("\nEl nombre no puede estar vacío!\n")
            } else {
                nomProveedor = tempNombr
            }
        }

        while (apellProveedor.isBlank()) {
            print("Introduce los apellidos del proveedor: ")
            val tempApell = readln()
            if (tempApell.isBlank()) {
                println("\nLos apellidos no pueden estar vacíos!\n")
            } else {
                apellProveedor = tempApell
            }
        }

        while (localidProveedor.isBlank()) {
            print("Introduce la localidad del proveedor: ")
            val tempLocalidad = readln()
            if (tempLocalidad.isBlank()) {
                println("\nLa localidad no puede estar vacía!")
            } else {
                localidProveedor = tempLocalidad
            }
        }

        while (tlfProveedor.isBlank()) {
            print("Introduce el telefono del proveedor: ")
            val tempTlf = readln()
            if (tempTlf.isBlank()) {
                println("\nEl teléfono no puede estar vacío!\n")
            } else {
                tlfProveedor = tempTlf
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "INSERT INTO proveedores(nom_proveedor, apellidos_proveedor, localidad_proveedor, tlf_cliente) VALUES (?, ?, ?, ?)"
            ).use { pstmt ->
                pstmt.setString(1, nomProveedor)
                pstmt.setString(2, apellProveedor)
                pstmt.setString(3, localidProveedor)
                pstmt.setString(4, tlfProveedor)
                pstmt.executeUpdate()
                println("\nNuevo proveedor: '$nomProveedor' insertado con éxito.\n")
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun eliminarProveedor() {
        println()
        mostrarTodosProveedores()
        println()

        var idProveedor: Int? = null

        while (idProveedor == null) {
            print("\nIntroduce el ID del proveedor a eliminar: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProveedor = tempId
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement("DELETE FROM proveedores WHERE id = ?").use { pstmt ->
                pstmt.setInt(1, idProveedor)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Proveedor con id: $idProveedor eliminado correctamente.")
                } else {
                    println("No se encontró ningun proveedor con id: $idProveedor.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarNombreProveedor() {
        println()
        mostrarNombreProveedores()
        println()

        var idProveedor: Int? = null
        var nuevoNombre = ""

        while (idProveedor == null) {
            print("\nIntroduce el ID del proveedor para modificar su nombre: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProveedor = tempId
            }
        }

        while (nuevoNombre.isBlank()) {
            print("\nIntroduce el nuevo nombre del proveedor: ")
            val tempNombre = readln()
            if (tempNombre.isBlank()) {
                println("\nEl nombre no puede estar vacío!\n")
            } else {
                nuevoNombre = tempNombre
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE proveedores SET nom_proveedor = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevoNombre)
                pstmt.setInt(2, idProveedor)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Nombre del proveedor con id: $idProveedor actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun proveedor con el id: $idProveedor.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarApellidosProveedor() {
        println()
        mostrarNombreProveedores()
        println()

        var idProveedor: Int? = null
        var nuevoApellidos = ""

        while (idProveedor == null) {
            print("\nIntroduce el ID del proveedor para modificar sus apellidos: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProveedor = tempId
            }
        }

        while (nuevoApellidos.isBlank()) {
            print("\nIntroduce los nuevos apellidos del proveedor: ")
            val tempNombre = readln()
            if (tempNombre.isBlank()) {
                println("\nLos apellidos no pueden estar vacíos!\n")
            } else {
                nuevoApellidos = tempNombre
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE proveedores SET apellidos_proveedor = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevoApellidos)
                pstmt.setInt(2, idProveedor)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Apellidos del proveedor con id: $idProveedor actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun proveedor con el id: $idProveedor.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarLocalidadProeedor() {
        println()
        mostrarTodosProveedores()
        println()

        var idProveedor: Int? = null
        var nuevaLocalidad = ""

        while (idProveedor == null) {
            print("\nIntroduce el ID del proveedor para modificar su localidad: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProveedor = tempId
            }
        }

        while (nuevaLocalidad.isBlank()) {
            print("\nIntroduce la nueva localidad del proveedor: ")
            val tempNombre = readln()
            if (tempNombre.isBlank()) {
                println("\nLa localidad no puede estar vacía!\n")
            } else {
                nuevaLocalidad = tempNombre
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE proveedores SET localidad_proveedor = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevaLocalidad)
                pstmt.setInt(2, idProveedor)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Localidad del proveedor con id: $idProveedor actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun proveedor con el id: $idProveedor.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
    }

    fun modificarTlfProveedor() {
        println()
        mostrarTodosProveedores()
        println()

        var idProveedor: Int? = null
        var nuevoTlf = ""

        while (idProveedor == null) {
            print("\nIntroduce el ID del proveedor para modificar su teléfono: ")
            val tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProveedor = tempId
            }
        }

        while (nuevoTlf.isBlank()) {
            print("\nIntroduce el nuevo teléfono del proveedor: ")
            val tempNombre = readln()
            if (tempNombre.isBlank()) {
                println("\nEl teléfono no puede estar vacío!\n")
            } else {
                nuevoTlf = tempNombre
            }
        }

        conectarBd(URL)?.use { conn ->
            conn.prepareStatement(
                "UPDATE proveedores SET tlf_proveedor = ? WHERE id = ?"
            ).use { pstmt ->
                pstmt.setString(1, nuevoTlf)
                pstmt.setInt(2, idProveedor)
                val filas = pstmt.executeUpdate()
                if (filas > 0) {
                    println("Teléfono del proveedor con id: $idProveedor actualizado con éxito.")
                } else {
                    println("Error: No se encontró ningun proveedor con el id: $idProveedor.")
                }
            }
        } ?: println("No se pudo establecer la conexión.")
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
