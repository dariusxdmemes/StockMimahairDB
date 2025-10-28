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
                1 -> ProductosDAO.mostrarProductos()
                2 -> ProductosDAO.mostrarProductoPorId()
                3 -> menuModificarProducto()
                4 -> ProductosDAO.insertarProducto()
                5 -> println()
                6 -> {
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
                3 -> menuModificarClientes()
                4 -> println()
                5 -> println()
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
                1 -> println()
                2 -> println()
                3 -> println()
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
                1 -> println()
                2 -> println()
                3 -> menuModificarProveedores()
                4 -> println()
                5 -> println()
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
                1 -> println()
                2 -> println()
                3 -> println()
                4 -> println()
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
                println("ID: ${producto.id}, Nombre: ${producto.nombre_prod}, Marca: ${producto.marca_prod}, Categoria: ${producto.categoria_prod}, Precio: ${producto.precio_prod}, Stock: ${producto.stock}")
            } else {
                println("No existe ningun producto con ese ID!")
            }
        }
    }

    fun insertarProducto() {
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
            print("\nIntroduce el ID del producto del producto a modificar: ")
            var tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevoNombre.isBlank()) {
            print("\nIntroduce el nuevo nombre del producto: ")
            var tempNombre = readln()
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
            print("\nIntroduce el ID del producto del producto a modificar: ")
            var tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevaMarca.isBlank()) {
            print("\nIntroduce la nueva narca del producto: ")
            var tempMarca = readln()
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
            print("\nIntroduce el ID del producto del producto a modificar: ")
            var tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevaCategoria.isBlank()) {
            print("\nIntroduce la nueva categoría del producto: ")
            var tempCategoria = readln()
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
            print("\nIntroduce el ID del producto del producto a modificar: ")
            var tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevoPrecio == null) {
            print("\nIntroduce el nuevo precio del producto: ")
            var tempPrecio = readln().toDoubleOrNull()
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
            print("\nIntroduce el ID del producto del producto a modificar: ")
            var tempId = readln().toIntOrNull()
            if (tempId == null) {
                println("\nEl id ha de ser un número entero!\n")
            } else {
                idProd = tempId
            }
        }

        while (nuevoStock == null) {
            print("\nIntroduce el nuevo stock del producto: ")
            var tempStock = readln().toIntOrNull()
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
