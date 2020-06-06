package com.example.FiveM_Panel.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface FiveMDao {

    @Insert
    suspend fun insertNote(game: FiveM)

    @Query("SELECT * FROM fivemdb")
    fun getGames(): LiveData<List<FiveM>>

    @Update
    suspend fun updateGame(game: FiveM)

    @Insert
    suspend fun insertGame(game: FiveM)

    @Delete
    suspend fun deleteGame(game: FiveM)

    @Query("DELETE  FROM fivemdb WHERE 1")
    suspend fun deleteAllGames()
}
