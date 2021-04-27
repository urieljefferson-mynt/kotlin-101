package com.example.todolistjeff

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistjeff.dao.DatabaseHandler
import com.example.todolistjeff.model.TodoModelClass
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewRecord()
        btn_add.setOnClickListener(this)
    }

    override fun onClick(pressed: View) {
        when(pressed.id){
            R.id.btn_add -> {
                saveRecord()
            }
            else -> {
                Toast.makeText(this, "Unknown press", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun saveRecord(){
        val title = et_todo.text.toString()
        val isChecked = "false"
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        if(title.trim()!=""){
            val status = databaseHandler.addTodo(TodoModelClass(title, isChecked))
            if(status > -1){
                Toast.makeText(applicationContext,"New task added", Toast.LENGTH_LONG).show()
                et_todo.text.clear()
            }
        }else{
            Toast.makeText(applicationContext,"You cannot enter a blank task", Toast.LENGTH_LONG).show()
        }

        viewRecord()

    }
    //method for read records from database in ListView
    fun viewRecord(){
        //creating the instance of DatabaseHandler class
        val databaseHandler: DatabaseHandler= DatabaseHandler(this)
        //calling the viewEmployee method of DatabaseHandler class to read the records
        val emp: List<TodoModelClass> = databaseHandler.viewTasks()
        val taskArrayId = Array<String>(emp.size){"0"}
        val taskArrayTitle = Array<String>(emp.size){"null"}
        val taskArrayisChecked = Array<String>(emp.size){"null"}
        var index = 0
        for(e in emp){
            taskArrayTitle[index] = e.title
            taskArrayisChecked[index] = e.isChecked
            index++
        }
        //creating custom ArrayAdapter
        val myListAdapter = RVTodoAdapter(this,taskArrayId,taskArrayTitle,taskArrayisChecked)
        rv_todo_items.adapter = myListAdapter
        rv_todo_items.layoutManager = LinearLayoutManager(this)
    }
}
