package com.example.FiveM_Panel.database
import android.os.StrictMode
import com.example.FiveM_Panel.BuildConfig
import com.example.FiveM_Panel.ui.DBRowsActivity
import kotlinx.coroutines.*
import java.sql.*
import java.util.Properties



const val EXTRA_ROW = "EXTRA_ROW"
object JDBCControl{

    val drows = arrayListOf<DBRows>()
    val rec = DBRowsActivity()

    fun getConnection(dataB : String, table : String, IP : String, username : String, password : String){
            StrictModes()
            val connectionProps = Properties()
            connectionProps.put("user", username)
            connectionProps.put("password", password)
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance()
                val conn: Connection = DriverManager.getConnection(
                    "jdbc:mysql://$IP:3306/$dataB?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false",
                    username,
                    password
                )
                println("Hello?")
                PrintRows(conn, dataB, table)
            } catch (ex: SQLException) {
                // handle any errors
                ex.printStackTrace()
            } catch (ex: Exception) {
                // handle any errors
                ex.printStackTrace()
            }
        }
        fun PrintRows(conn: Connection, dataB: String, table: String){
            val sql = "SELECT * FROM $dataB.$table"
            val rs = conn.createStatement().executeQuery(sql)
            while (rs.next()) {
                drows.add(DBRows(rs.getString("firstname"), rs.getString("lastname"), rs.getString("dateofbirth"), rs.getInt("height"), rs.getString("group")))
                /*rec.receiveData(
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("dateofbirth"),
                    rs.getInt("height"),
                    rs.getString("group")
                )*/
            }
        }
    private fun StrictModes() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder().permitNetwork()
                    .penaltyLog().penaltyDeath().build())
        }
    }
}