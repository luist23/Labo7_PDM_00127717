package com.luist23.room_project.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.luist23.room_project.database.daos.GithubRepoDAO
import com.luist23.room_project.database.entities.GithubRepo

class GithubRepoRepository (private val repoDAO: GithubRepoDAO){

    fun getAll():LiveData<List<GithubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread//esta funcion solo puede ser llamada en un workerThread (un hilo)
    suspend fun insert(repo:GithubRepo) = repoDAO.insert()
}