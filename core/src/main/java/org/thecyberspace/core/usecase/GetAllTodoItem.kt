package org.thecyberspace.core.usecase

import org.thecyberspace.core.repository.TodoRepository

class GetAllTodoItem (private val todoRepository: TodoRepository) {
    suspend operator fun invoke() = todoRepository.getAllTodoItems()
}