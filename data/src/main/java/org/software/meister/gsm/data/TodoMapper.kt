package org.software.meister.gsm.data

import org.software.meister.gsm.domain.TodoItem

object TodoMapper {
    fun exchangeTodo(todo: Todo) : TodoItem{
        return TodoItem(
            id = todo.id,
            title = todo.todoTItle,
            text = todo.todoText,
            createdAt = todo.createdAt
        )
    }

    fun exchangeTodoItem(todoItem: TodoItem) : Todo{
        return Todo(
            id = todoItem.id,
            todoTItle = todoItem.title,
            todoText = todoItem.text,
            createdAt = todoItem.createdAt
        )
    }

    fun exchangeTodoItemInsert(todoItem: TodoItem) : Todo{
        return Todo(
            todoTItle = todoItem.title,
            todoText = todoItem.text,
            createdAt = todoItem.createdAt
        )
    }
}