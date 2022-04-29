package org.software.meister.gsm.data

import org.software.meister.gsm.domain.TodoItem
import org.software.meister.gsm.domain.TodoRepository

class TodoRepositoryImpl(val dao: TodoDao) : TodoRepository {
    override suspend fun getTodoList(): List<TodoItem> {
        return dao.getTodoList().map {
            TodoMapper.exchangeTodo(it)
        }
    }

    override suspend fun getTodoItemById(id: Int): TodoItem {
        return TodoMapper.exchangeTodo(dao.getTodoItemById(id))
    }

    override suspend fun postTodoItem(todoItem: TodoItem) {
        return dao.postTodo(TodoMapper.exchangeTodoItem(todoItem))
    }

    override suspend fun updateTodoItem(todoItem: TodoItem) {
        return dao.updateTodo(TodoMapper.exchangeTodoItem(todoItem))
    }

    override suspend fun deleteTodoItem(id: Int) {
        return dao.delete(id)
    }
}