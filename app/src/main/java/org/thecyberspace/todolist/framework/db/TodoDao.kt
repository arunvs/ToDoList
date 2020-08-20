package org.thecyberspace.todolist.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface TodoDao{

    @Insert(onConflict = REPLACE)
    suspend fun addTodoItemEntity(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo WHERE id= :id")
    suspend fun getTodoItemEntity(id:Long):TodoEntity?

    @Query("SELECT * FROM todo")
    suspend fun getAllTodoItemEntity():List<TodoEntity>

    @Delete
    suspend fun removeTodoItemEntity(todoEntity: TodoEntity)
}