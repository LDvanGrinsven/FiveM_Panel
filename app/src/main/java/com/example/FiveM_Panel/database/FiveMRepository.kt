package com.example.FiveM_Panel.database

import android.content.Context
import androidx.lifecycle.LiveData


class FiveMRepository(context: Context) {

    private val fiveMDao: FiveMDao

    init {
        val database = FiveMRoomDatabase.getDatabase(context)
        fiveMDao = database!!.gameDao()
    }

    fun getGames(): LiveData<List<FiveM>> {
        return fiveMDao.getGames()
    }

    suspend fun updateGame(game: FiveM) {
        fiveMDao.updateGame(game)
    }
    suspend fun insertGame(game: FiveM) {
        fiveMDao.insertGame(game)
    }
    suspend fun deleteGame(game: FiveM) {
        fiveMDao.deleteGame(game)
    }

    suspend fun deleteAllGames(){
        fiveMDao.deleteAllGames()
    }

}
