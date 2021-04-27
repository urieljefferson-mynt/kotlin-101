package ph.apper.training.valmores.database

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ph.apper.training.valmores.database.dao.DatabaseHandler
import ph.apper.training.valmores.database.model.TodoModelClass


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewRecord()
        btn_add.setOnClickListener(this)
//        view_record.setOnClickListener(this)
//        update_record.setOnClickListener(this)
//        delete_record.setOnClickListener(this)
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
    //method for updating records based on user id
//    fun updateRecord(){
//        val dialogBuilder = AlertDialog.Builder(this)
//        val inflater = this.layoutInflater
//        val dialogView = inflater.inflate(R.layout.update_dialog, null)
//        dialogBuilder.setView(dialogView)
//
//        val edtId = dialogView.findViewById(R.id.updateId) as EditText
//        val edtName = dialogView.findViewById(R.id.updateName) as EditText
//        val edtEmail = dialogView.findViewById(R.id.updateEmail) as EditText
//
//        dialogBuilder.setTitle("Update Record")
//        dialogBuilder.setMessage("Enter data below")
//        dialogBuilder.setPositiveButton("Update", DialogInterface.OnClickListener { _, _ ->
//
//            val updateId = edtId.text.toString()
//            val updateName = edtName.text.toString()
//            val updateEmail = edtEmail.text.toString()
//            //creating the instance of DatabaseHandler class
//            val databaseHandler: DatabaseHandler= DatabaseHandler(this)
//            if(updateId.trim()!="" && updateName.trim()!="" && updateEmail.trim()!=""){
//                //calling the updateEmployee method of DatabaseHandler class to update record
//                val status = databaseHandler.updateEmployee(TodoModelClass(Integer.parseInt(updateId),updateName, updateEmail))
//                if(status > -1){
//                    Toast.makeText(applicationContext,"record update", Toast.LENGTH_LONG).show()
//                }
//            }else{
//                Toast.makeText(applicationContext,"id or name or email cannot be blank", Toast.LENGTH_LONG).show()
//            }
//
//        })
//        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
//            //pass
//        })
//        val b = dialogBuilder.create()
//        b.show()
//    }
//    //method for deleting records based on id
//    fun deleteRecord(){
//        //creating AlertDialog for taking user id
//        val dialogBuilder = AlertDialog.Builder(this)
//        val inflater = this.layoutInflater
//        val dialogView = inflater.inflate(R.layout.delete_dialog, null)
//        dialogBuilder.setView(dialogView)
//
//        val dltId = dialogView.findViewById(R.id.deleteId) as EditText
//        dialogBuilder.setTitle("Delete Record")
//        dialogBuilder.setMessage("Enter id below")
//        dialogBuilder.setPositiveButton("Delete", DialogInterface.OnClickListener { _, _ ->
//
//            val deleteId = dltId.text.toString()
//            //creating the instance of DatabaseHandler class
//            val databaseHandler: DatabaseHandler= DatabaseHandler(this)
//            if(deleteId.trim()!=""){
//                //calling the deleteEmployee method of DatabaseHandler class to delete record
//                val status = databaseHandler.deleteEmployee(TodoModelClass(Integer.parseInt(deleteId),"",""))
//                if(status > -1){
//                    Toast.makeText(applicationContext,"record deleted", Toast.LENGTH_LONG).show()
//                }
//            }else{
//                Toast.makeText(applicationContext,"id or name or email cannot be blank", Toast.LENGTH_LONG).show()
//            }
//
//        })
//        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ ->
//            //pass
//        })
//        val b = dialogBuilder.create()
//        b.show()
//    }
}
