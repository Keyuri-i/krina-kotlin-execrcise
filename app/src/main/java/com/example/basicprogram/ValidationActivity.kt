package com.example.basicprogram

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText


class ValidationActivity : AppCompatActivity() {

   private lateinit var name: TextInputEditText
   private lateinit var password: TextInputEditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validation)

        name = findViewById(R.id.etInputName)
        password = findViewById(R.id.etInputPass)

    }

    fun validate(): Boolean {
        if (name.text.toString().equals("")) {
            name.error = "Name must be required!"
            return false
        } else if (password.text.toString().equals("")) {
            password.error = "Password must be required"
            return false
        }
        return true
    }

    fun validate(view: View) {
        validate()
    }
/*
    fun validate() {
        if (isEmpty(name)){
            name!!.error="Name must be required!"
        }else if (isEmpty(password)){
            password!!.error="Password must be required"
        }
    }
*/
}