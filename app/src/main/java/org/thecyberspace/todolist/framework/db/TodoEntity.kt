package org.thecyberspace.todolist.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.thecyberspace.core.data.TodoItem

@Entity(tableName = "todo")
data class TodoEntity(
    var title:String,
    var content:String,

    @ColumnInfo(name = "creation_time")
    var creationTime:Long,

    @ColumnInfo(name = "update_time")
    var updateTime:Long,

    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L) {

    companion object{
        fun fromTodoList(toDoItem:TodoItem) = TodoEntity(toDoItem.title,toDoItem.content,toDoItem.creationTime,toDoItem.updateTime)
    }

    fun toTodo() = TodoItem(title,content,creationTime,updateTime,id)
}