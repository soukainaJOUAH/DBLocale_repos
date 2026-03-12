package com.example.mykotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger le layout XML
        setContentView(R.layout.activity_main)

        val buttonShared = findViewById<Button>(R.id.buttonShared)
        val buttonSQLite = findViewById<Button>(R.id.buttonSQLite)

        buttonShared.setOnClickListener {

            val intent = Intent(this, SharedPreferencesActivity::class.java)
            startActivity(intent)

        }

        buttonSQLite.setOnClickListener {

            val intent = Intent(this, SQLiteActivity::class.java)
            startActivity(intent)

        }
    }
}