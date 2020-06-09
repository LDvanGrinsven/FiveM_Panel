package com.example.FiveM_Panel.ui

import androidx.lifecycle.MutableLiveData
import com.example.FiveM_Panel.database.DBRows
import com.example.FiveM_Panel.database.DBRowsRepository
import androidx.lifecycle.ViewModel

class DBRowsActivityViewModel : ViewModel(){
    private val dbrowsRepository = DBRowsRepository()

    var rowsitems = MutableLiveData<List<DBRows>>().apply {
        value = dbrowsRepository.getDBRows()
    }
    fun apply(){
        rowsitems = MutableLiveData<List<DBRows>>().apply {
            value = dbrowsRepository.getDBRows()
        }
    }
}