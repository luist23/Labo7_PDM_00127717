package com.luist23.room_project

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.luist23.room_project.daos.GithubRepoDAO
import com.luist23.room_project.entities.GithubRepo

@Database(entities = [GithubRepo::class],version = 1,exportSchema = false)//en caso de mas entidades se agregan al arreglo.. despues de la version si se cambi se tiene que migrar
public abstract class RoomDB:RoomDatabase(){

    abstract fun repoDao():GithubRepoDAO
    //aqui se agregan todos los DAOs

    companion object {//solo se necesita una entidad de esta clase SInglenton

        @Volatile//notifica cambios a todos los hilos que lo estan usando
        private var INSTANCE:RoomDB?=null

        fun getInstance(context: Context):RoomDB{
            val temInstance = INSTANCE
            if(temInstance!=null){
                return temInstance
            }

            synchronized(this){//para que solo un hilo la use y puedan crearse dos bases
                val instance = Room
                    .databaseBuilder(context,RoomDB::class.java,"Repo_DB")
                    .build()
                INSTANCE=instance
                return instance
            }
        }
    }


}