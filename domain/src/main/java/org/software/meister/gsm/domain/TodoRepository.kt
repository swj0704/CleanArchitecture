package org.software.meister.gsm.domain

interface TodoRepository {
    suspend fun getTodoList() : List<TodoItem>
    suspend fun getTodoItemById(id : Int) : TodoItem
    suspend fun postTodoItem(todoItem: TodoItem)
    suspend fun updateTodoItem(todoItem: TodoItem)
    suspend fun deleteTodoItem(id : Int)
}