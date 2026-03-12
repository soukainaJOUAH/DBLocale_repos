package com.example.mykotlin

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        // Enable back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonLoad = findViewById<Button>(R.id.buttonLoad)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        val sharedPrefFile = "MyPrefs"
        val nameKey = "name"

        // Save name
        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()

            val sharedPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
            sharedPreferences.edit {

                putString(nameKey, name)
            }
        }

        // Load name
        buttonLoad.setOnClickListener {

            val sharedPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
            val savedName = sharedPreferences.getString(nameKey, "No name found")

            textViewResult.text = savedName
        }
    }
}