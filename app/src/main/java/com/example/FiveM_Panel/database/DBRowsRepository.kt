package com.example.FiveM_Panel.database


class DBRowsRepository {
    fun getDBRows(): List<DBRows> {
        var dbrowsarray = JDBCControl.drows
            for (x in 0 until dbrowsarray.size) {
                DBRows(dbrowsarray[x].useridentifier, dbrowsarray[x].firstname, dbrowsarray[x].lastname, dbrowsarray[x].dateofbirth, dbrowsarray[x].height, dbrowsarray[x].group)
            }
        println(dbrowsarray)
        return dbrowsarray
    }
}