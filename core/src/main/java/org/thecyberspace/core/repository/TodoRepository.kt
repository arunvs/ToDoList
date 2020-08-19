package org.thecyberspace.core.repository

import org.thecyberspace.core.data.TodoItem

class TodoRepository(private val dataSource: ToDoDataSource) {

    suspend fun addTodoItem(todoItem:TodoItem) = dataSource.add(todoItem)

    suspend fun getTodoItem(id:Long) = dataSource.getTodoItem(id)

    suspend fun getAllTodoItems() = dataSource.getAll()

    suspend fun removeTodoItem(todoItem: TodoItem) = dataSource.remove(todoItem)
}