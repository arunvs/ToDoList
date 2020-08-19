package org.thecyberspace.core.usecase

import org.thecyberspace.core.data.TodoItem
import org.thecyberspace.core.repository.TodoRepository

class AddTodoItem(private val todoRepository: TodoRepository) {
    suspend operator fun invoke(todoItem: TodoItem) = todoRepository.addTodoItem(todoItem)
}