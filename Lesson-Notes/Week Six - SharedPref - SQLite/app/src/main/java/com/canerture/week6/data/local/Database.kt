package com.canerture.week6.data.local

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.canerture.week6.common.bitmapToByte
import com.canerture.week6.common.byteToBitmap
import com.canerture.week6.data.model.User

/**
 * Created on 27.07.2023
 * @author Caner Türe
 */

class Database(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "AllData"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, image BLOB, name TEXT, email TEXT, type TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun addUser(user: User) {
        val db = writableDatabase
        val values = ContentValues()
        values.put("image", user.image.bitmapToByte())
        values.put("name", user.name)
        values.put("email", user.email)
        values.put("type", user.type)

        db.insert("users", null, values)
    }

    fun deleteUser(id: Int) {
        val db = writableDatabase
        db.delete("users", "id=$id", null)
    }

    fun getUsers(): List<User> {
        val db = readableDatabase
        val columns = arrayOf("id", "image", "name", "email", "type")

        val cursor = db.query("users", columns, null, null, null, null, null)

        val users = arrayListOf<User>()

        val idIx = cursor.getColumnIndex("id")
        val imageIx = cursor.getColumnIndex("image")
        val nameIx = cursor.getColumnIndex("name")
        val emailIx = cursor.getColumnIndex("email")
        val typeIx = cursor.getColumnIndex("type")

        while (cursor.moveToNext()) {
            users.add(
                User(
                    cursor.getInt(idIx),
                    cursor.getBlob(imageIx).byteToBitmap(),
                    cursor.getString(nameIx),
                    cursor.getString(emailIx),
                    cursor.getString(typeIx)
                )
            )
        }

        return users
    }
}