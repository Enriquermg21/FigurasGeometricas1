package com.example.geometricfigures

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel

class AreaViewModel : ViewModel() {
    fun swapview(context: Context) {
        val intent = Intent(context, AreaActivity::class.java)
        context.startActivity(intent)
    }
}