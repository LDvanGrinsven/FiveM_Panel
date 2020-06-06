package com.example.FiveM_Panel.ui


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.FiveM_Panel.database.FiveM
import com.example.FiveM_Panel.database.FiveMRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val gameRepository = FiveMRepository(application.applicationContext)
    val games: LiveData<List<FiveM>> = gameRepository.getGames()

    fun insertGame(game: FiveM) {
        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }

    fun deleteGame(game: FiveM) {
        ioScope.launch {
            gameRepository.deleteGame(game)
        }
    }

    fun deleteAllGames(){
        ioScope.launch {
            gameRepository.deleteAllGames()
        }
    }

}
