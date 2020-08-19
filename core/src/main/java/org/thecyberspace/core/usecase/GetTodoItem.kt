package org.thecyberspace.core.usecase

import org.thecyberspace.core.repository.TodoRepository

class GetTodoItem (private val todoRepository: TodoRepository) {
    suspend operator fun invoke(id:Long) = todoRepository.getTodoItem(id)
}