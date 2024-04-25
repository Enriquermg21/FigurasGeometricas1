package com.example.geometricfigures

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class AreaActivity : AppCompatActivity() {

    private lateinit var mainViewModel: mainViewModel
    private lateinit var areaViewModel: AreaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.area_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewarea)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainViewModel = ViewModelProvider(this).get(mainViewModel::class.java)
        areaViewModel = ViewModelProvider(this).get(areaViewModel::class.java)
    }
}