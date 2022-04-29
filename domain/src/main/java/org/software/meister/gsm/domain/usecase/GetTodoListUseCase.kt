package org.software.meister.gsm.domain.usecase

import org.software.meister.gsm.domain.TodoItem
import org.software.meister.gsm.domain.TodoRepository
import org.software.meister.gsm.domain.UseCase

class GetTodoListUseCase(val repository: TodoRepository) : UseCase {
    suspend operator fun invoke() : List<TodoItem>{
        return repository.getTodoList()
    }
}