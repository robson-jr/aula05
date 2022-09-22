package com.example.teste

import android.app.AlertDialog
import android.content.Context

fun alert(titulo: String,msg:String, context : Context){
    AlertDialog.Builder(context)
        .setTitle(titulo)
        .setMessage(msg)
        .setPositiveButton("OK", null)
        .create()
        .show()
}