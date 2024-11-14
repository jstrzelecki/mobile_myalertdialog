package com.example.ivgr1alertdialog

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var someMsg: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.showDialogButton).setOnClickListener {
            showAlertDialog("to jest super wiadomość")

        }
        someMsg = findViewById(R.id.some_msg_textview)
    }

    private fun showAlertDialog(msg: String){
        val input = EditText(this)
        input.hint = "Napisz coś"

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Jakiś tytuł")
            .setMessage(msg)
            .setIcon(R.drawable.android_black)
            .setView(input)
            .setPositiveButton("Tak") { dialog, which ->
                Log.i("btn", "Akcja na tak. which: $which")
                val userInput = input.text.toString()
                someMsg.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
                someMsg.text = userInput
                dialog.dismiss()
            }
            .setNegativeButton("No nie"){dialog, which ->
                Log.i("btn", "Ni nie: which: $which")
                dialog.dismiss()
            }
            .create()

        alertDialog.show()
    }
}