package org.thecyberspace.core.usecase

import org.thecyberspace.core.data.TodoItem
import org.thecyberspace.core.repository.TodoRepository

class RemoveTodoItem (private val todoRepository: TodoRepository) {
    suspend operator fun invoke(todoItem: TodoItem) = todoRepository.removeTodoItem(todoItem)
}