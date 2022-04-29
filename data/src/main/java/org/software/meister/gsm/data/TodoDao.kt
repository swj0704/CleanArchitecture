package org.software.meister.gsm.data

import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * From Todo")
    suspend fun getTodoList() : List<Todo>

    @Query("SELECT * from Todo Where id=:id")
    suspend fun getTodoItemById(id : Int) : Todo

    @Insert
    suspend fun postTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Query("DELETE FROM Todo WHERE id=:id")
    suspend fun delete(id:Int)
}