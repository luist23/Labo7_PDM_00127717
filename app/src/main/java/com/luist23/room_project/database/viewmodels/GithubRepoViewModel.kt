package com.luist23.room_project.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.luist23.room_project.database.RoomDB
import com.luist23.room_project.database.entities.GithubRepo
import com.luist23.room_project.database.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app:Application):AndroidViewModel(app) {

    private val repository:GithubRepoRepository

    init{
        val repoDao= RoomDB.getInstance(app).repoDao()
        repository= GithubRepoRepository(repoDao)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()


    //Scope es una especie de context.. de donde estas(en el ambito del Viewmodel...... corutina.. se lanza en el hilo IO?
    fun insert(repo : GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }
}