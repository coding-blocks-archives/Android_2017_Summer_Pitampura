package com.codingblocks.database

import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.codingblocks.database.db.TodoDatabaseHelper
import com.codingblocks.database.db.tables.TodoTable

import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {
    var db: SQLiteDatabase? = null


    //var todos: ArrayList<Todo> = ArrayList<Todo>()
    var todos: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = TodoDatabaseHelper(this).writableDatabase
        todos = TodoTable.getTodos(db)


        var todoAdapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1,
                todos

        )
        lvTodos.adapter = todoAdapter


        btnAddTodo.setOnClickListener {
            TodoTable.addTodo(db, etNewTodo.text.toString())

            //todos.add(etNewTodo.text.toString()) //Only add the new task to view layer
            todos.clear();
            todos.addAll(TodoTable.getTodos(db))  // Refresh the entire list
            Log.d(TAG, "" + todos.size)

            todoAdapter.notifyDataSetChanged()
        }

    }

    companion object {
        val TAG = "TODO"
    }
}
