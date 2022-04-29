package org.software.meister.gsm.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val todoTItle : String,
    val todoText : String
)