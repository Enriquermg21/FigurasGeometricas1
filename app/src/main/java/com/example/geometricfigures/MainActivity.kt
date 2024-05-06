package com.example.geometricfigures

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var areaView: View
    private lateinit var imgvarea: ImageView
    private lateinit var tvtitlevarea: TextView
    private lateinit var tvcalcular: TextView
    private lateinit var tvheight: TextView
    private lateinit var tvbase: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        areaView = layoutInflater.inflate(R.layout.area_view, null)
        imgvarea = areaView.findViewById(R.id.imgvArea)
        tvtitlevarea = areaView.findViewById(R.id.tvTitleArea)
        tvcalcular = areaView.findViewById(R.id.tvCalcular)
        tvheight = areaView.findViewById(R.id.tvHeigth)
        tvbase = areaView.findViewById(R.id.tvBase)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
    fun imageClicked(view: View) {
        when (view.id) {
            R.id.ivTriangle -> {
                imgvarea.setImageResource(R.drawable.triangulo)
                tvtitlevarea.text = "¿Cómo calcular el área del triángulo?"
                tvcalcular.text = "Calcular el area del triangulo: b=base * h=altura"
            }

            R.id.ivPentagon -> {
                imgvarea.setImageResource(R.drawable.pentagono)
                tvtitlevarea.text = "¿Cómo calcular el área del pentagono?"
                tvcalcular.text = "Calcular el area del pentagono: 1/4 * √5 * (5+2*√5) x lado^2 "
                tvheight.text = "Introduce el tamaño del lado"
                tvbase.visibility = View.INVISIBLE

            }

            R.id.ivOval -> {
                imgvarea.setImageResource(R.drawable.ovalo)
                tvtitlevarea.text = "¿Cómo calcular el área del ovalo?"
                tvcalcular.text = "Calcular el area del ovalo: π * a * b"
                tvheight.text = "Introduce el tamaño de la diagonal mayor"
                tvheight.text = "Introduce el tamaño de la diagonal menor"
            }
        }
        setContentView(areaView)
    }
}