package org.software.meister.gsm.domain.usecase

import org.software.meister.gsm.domain.TodoItem
import org.software.meister.gsm.domain.TodoRepository
import org.software.meister.gsm.domain.UseCase

class PostTodoItemUseCase(val repository: TodoRepository) : UseCase {
    suspend operator fun invoke(todoItem : TodoItem){
        return repository.postTodoItem(todoItem)
    }
}