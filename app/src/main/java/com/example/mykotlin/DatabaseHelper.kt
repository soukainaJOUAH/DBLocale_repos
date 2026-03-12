package com.example.mykotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "MyDatabase.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        val createTable = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(name: String) {

        val db = writableDatabase
        val values = ContentValues()

        values.put("name", name)

        db.insert("users", null, values)
        db.close()
    }

    fun getAllUsers(): String {

        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users", null)

        val result = StringBuilder()

        if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndexOrThrow("id")
            val nameIndex = cursor.getColumnIndexOrThrow("name")

            do {
                val id = cursor.getInt(idIndex)
                val name = cursor.getString(nameIndex)

                result.append("$id - $name\n")

            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return result.toString()
    }
}