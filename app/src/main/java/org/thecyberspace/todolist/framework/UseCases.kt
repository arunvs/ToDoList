package org.thecyberspace.todolist.framework

import org.thecyberspace.core.usecase.AddTodoItem
import org.thecyberspace.core.usecase.GetAllTodoItem
import org.thecyberspace.core.usecase.GetTodoItem
import org.thecyberspace.core.usecase.RemoveTodoItem

data class UseCases(
    val addTodoItem: AddTodoItem,
    val getAllTodoItem: GetAllTodoItem,
    val getTodoItem: GetTodoItem,
    val removeTodoItem: RemoveTodoItem
)