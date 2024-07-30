package org.example

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }

    fun connectToDatabase() {
        val jdbcUrl = "jdbc:mysql://localhost:3306/shahmeer"
        val username = "root"
        val password = ""

        var connection: Connection? = null

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password)
            println("Connection successful")

            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("SELECT * FROM users")

            while (resultSet.next()) {
                println("ID: ${resultSet.getString("id")}, NAME: ${resultSet.getString("Name")}")
            }

        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            connection?.close()
        }
    }
}

fun main() {
    val app = App()
    println(app.greeting)
    app.connectToDatabase()
}
