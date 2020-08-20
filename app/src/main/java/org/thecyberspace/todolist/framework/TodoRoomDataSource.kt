package org.thecyberspace.todolist.framework

import android.content.Context
import org.thecyberspace.core.data.TodoItem
import org.thecyberspace.core.repository.ToDoDataSource
import org.thecyberspace.todolist.framework.db.DatabaseService
import org.thecyberspace.todolist.framework.db.TodoEntity

class TodoRoomDataSource (context: Context) : ToDoDataSource{

    val toDoDao = DatabaseService.getInstance(context).todoDao()

    override suspend fun add(todoItem: TodoItem) = toDoDao.addTodoItemEntity(TodoEntity.fromTodoList(todoItem))

    override suspend fun getTodoItem(id: Long) = toDoDao.getTodoItemEntity(id)?.toTodo()

    override suspend fun getAll() = toDoDao.getAllTodoItemEntity().map { it.toTodo() }

    override suspend fun remove(todoItem: TodoItem) = toDoDao.removeTodoItemEntity(TodoEntity.fromTodoList(todoItem))

}