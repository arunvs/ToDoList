package org.thecyberspace.core.repository

import org.thecyberspace.core.data.TodoItem

interface ToDoDataSource {

    suspend fun add(todoItem:TodoItem)

    suspend fun getTodoItem(id:Long):TodoItem?

    suspend fun getAll():List<TodoItem>

    suspend fun remove(todoItem:TodoItem)

}