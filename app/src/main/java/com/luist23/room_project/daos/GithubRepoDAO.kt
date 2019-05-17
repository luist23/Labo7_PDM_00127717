package com.luist23.room_project.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luist23.room_project.entities.GithubRepo

@Dao
interface GithubRepoDAO {

    @Query("SELECT*FROM repos")
    fun getAll():LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    fun insert()

    @Query("DELETE FROM repos")
    fun nukeTable()//elimina la tabla
}