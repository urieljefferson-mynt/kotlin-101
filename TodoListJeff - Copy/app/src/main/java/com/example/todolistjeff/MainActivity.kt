package com.example.todolistjeff

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistjeff.Data.Todo
import com.example.todolistjeff.Data.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter : TodoAdapter
    private lateinit var mTodoViewModel : TodoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        //Code that should immediately activated once activity is created
        super.onCreate(savedInstanceState) //function that is called once the activity is created
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())
        rv_todo_items.adapter = todoAdapter

        rv_todo_items.layoutManager = LinearLayoutManager(this)
        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        btn_add_todo.setOnClickListener{
            insertDataToDatabase()


        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }

    private fun insertDataToDatabase() {
        val title = et_todo.text.toString()
        val todoTitle = et_todo.text.toString()

        if(todoTitle.isNotEmpty()){
            val todo = Todo(0, title, false)
            mTodoViewModel.addTodo(todo)
            Toast.makeText(this, "Added New Task", Toast.LENGTH_SHORT).show()

            todoAdapter.addTodo(todo)
            et_todo.text.clear()
        }
    }
}