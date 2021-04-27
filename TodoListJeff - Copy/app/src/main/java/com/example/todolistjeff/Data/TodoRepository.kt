package com.example.todolistjeff.Data

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao) {

    val readAllData: LiveData<List<Todo>> = todoDao.readAllData()

    suspend fun addTodo(todo: Todo){
        todoDao.addTodo(todo)
    }

}