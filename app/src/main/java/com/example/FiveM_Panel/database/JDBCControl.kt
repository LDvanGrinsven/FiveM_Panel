package com.example.FiveM_Panel.database

import android.os.StrictMode
import android.widget.Button
import androidx.room.Update
import com.example.FiveM_Panel.BuildConfig
import com.example.FiveM_Panel.ui.DBRowsActivity
import java.sql.*
import java.util.Properties

const val EXTRA_ROW = "EXTRA_ROW"
object JDBCControl{

    val drows = arrayListOf<DBRows>()
    //val rec = DBRowsActivity()
    var conn: Connection? = null
    var db: String? = null
    var tb: String? = null

    fun getConnection(dataB : String, table : String, IP : String, username : String, password : String){
            StrictModes()
            db = dataB
            tb = table
            val connectionProps = Properties()
            connectionProps.put("user", username)
            connectionProps.put("password", password)
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance()
                conn = DriverManager.getConnection(
                    "jdbc:mysql://$IP:3306/$dataB?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false",
                    username,
                    password
                )
                println("Hello?")
                PrintRows(dataB, table)
            } catch (ex: SQLException) {
                // handle any errors
                ex.printStackTrace()
            } catch (ex: Exception) {
                // handle any errors
                ex.printStackTrace()
            }
        }
        fun PrintRows(dataB: String, table: String){
            val sql = "SELECT * FROM $dataB.$table"
            val rs = conn?.createStatement()?.executeQuery(sql)
            while (rs!!.next()) {
                drows.add(DBRows(rs.getString("identifier"),rs.getString("firstname"), rs.getString("lastname"), rs.getString("dateofbirth"), rs.getInt("height"), rs.getString("job")))
            }
        }
    fun ReceiveRows(userid: String, first: String, last: String, birth: String, tall: Int, grouptype: String)
    {
        var useridReceive = userid
        var firstnameReceive = first
        var lastnameReceive = last
        var dateofbirthReceive = birth
        var heightReceive = tall
        var groupReceive = grouptype
        UpdateRows(db, tb, useridReceive, firstnameReceive, lastnameReceive, dateofbirthReceive, heightReceive, groupReceive)
    }
    fun UpdateRows(dataB: String?, table: String?, uid: String, first: String, last: String, birth: String, tall: Int, grouptype: String){
        println(first + last + birth + tall + grouptype)
        val sql = "UPDATE $dataB.$table SET firstname='$first', lastname='$last', dateofbirth='$birth', height='$tall', job='$grouptype' WHERE (identifier='$uid')"
        val rs = conn?.createStatement()?.executeUpdate(sql)

    }
    private fun StrictModes() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder().permitNetwork()
                    .penaltyLog().penaltyDeath().build())
        }
    }
}