package org.thecyberspace.todolist.framework.viewmodels

import android.app.Application
import android.icu.text.LocaleDisplayNames
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.thecyberspace.core.data.TodoItem
import org.thecyberspace.core.repository.TodoRepository
import org.thecyberspace.core.usecase.AddTodoItem
import org.thecyberspace.core.usecase.GetAllTodoItem
import org.thecyberspace.core.usecase.GetTodoItem
import org.thecyberspace.core.usecase.RemoveTodoItem
import org.thecyberspace.todolist.framework.TodoRoomDataSource
import org.thecyberspace.todolist.framework.UseCases

class TodoDetailsViewModel(application: Application) : AndroidViewModel(application){

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val repository = TodoRepository(TodoRoomDataSource(application))

    val useCases = UseCases(
        AddTodoItem(repository),
        GetAllTodoItem(repository),
        GetTodoItem(repository),
        RemoveTodoItem(repository)
    )

    val saved = MutableLiveData<Boolean>()

    fun saveTodoItem(todoItem:TodoItem){

        coroutineScope.launch {
            useCases.addTodoItem(todoItem)
            saved.postValue(true)
        }


    }

}