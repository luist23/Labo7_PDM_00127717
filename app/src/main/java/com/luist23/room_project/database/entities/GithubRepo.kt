package com.luist23.room_project.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo


@Entity(tableName="repos")
data class GithubRepo (
    @ColumnInfo(name = "s_name")
    val name:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}