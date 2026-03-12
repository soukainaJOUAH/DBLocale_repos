package com.example.mykotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SQLiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        // Enable back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val editTextUser = findViewById<EditText>(R.id.editTextUser)
        val buttonAddUser = findViewById<Button>(R.id.buttonAddUser)
        val buttonShowUsers = findViewById<Button>(R.id.buttonShowUsers)
        val textViewUsers = findViewById<TextView>(R.id.textViewUsers)

        val dbHelper = DatabaseHelper(this)

        // Add user
        buttonAddUser.setOnClickListener {

            val name = editTextUser.text.toString()

            if (name.isNotEmpty()) {
                dbHelper.addUser(name)
                editTextUser.text.clear()
            }
        }

        // Show users
        buttonShowUsers.setOnClickListener {

            val users = dbHelper.getAllUsers()
            textViewUsers.text = users
        }
    }
}