package com.example.FiveM_Panel.database
import java.sql.*
import java.util.Properties

object JDBCControl {
    internal var conn: Connection? = null
    internal var username = "username" // provide the username
    internal var password = "password" // provide the corresponding password
    @JvmStatic fun main(args: Array<String>) {
        // make a connection to MySQL Server
        getConnection()
    }

    fun getConnection() {
        val connectionProps = Properties()
        connectionProps.put("user", username)
        connectionProps.put("password", password)
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "127.0.0.1" +
                        ":" + "3306" + "/" +
                        "",
                connectionProps)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }
}