package com.example.geometricfigures

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AreaActivity : AppCompatActivity() {

    private lateinit var heightuser: EditText
    private lateinit var resultadoAreaTextView: TextView
    private lateinit var tvheight: TextView
    private lateinit var tvtitlearea: TextView
    private lateinit var tvcalcular: TextView
    private lateinit var tvbase: TextView
    private lateinit var etheight: EditText
    private lateinit var imagenview: ImageView
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("AreaActivity", "Botón de calcular primero")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.area_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewarea)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa las vistas primero
        tvheight = findViewById(R.id.tvHeigth)
        tvtitlearea = findViewById(R.id.tvTitleArea)
        tvcalcular = findViewById(R.id.tvCalcular)
        tvbase = findViewById(R.id.tvBase)
        etheight = findViewById(R.id.etHeight)
        heightuser = findViewById(R.id.tlHeightUser)
        resultadoAreaTextView = findViewById(R.id.tvresult)
        imagenview = findViewById(R.id.imgvArea)
        btnCalcular = findViewById(R.id.btnCalcular)

        // Luego obtén los datos del Intent
        val figura = intent.getStringExtra("figura")
        val titulo = intent.getStringExtra("titulo")
        val calcular = intent.getStringExtra("calcular")
        val base = intent.getStringExtra("base")
        val altura = intent.getStringExtra("altura")

        // Configura las vistas con los datos del Intent
        imagenview.setImageResource(getDrawableResource(figura))
        tvtitlearea.text = titulo
        tvcalcular.text = calcular
        tvbase.text = base
        tvheight.text = altura
        if (figura != "pentagono") {
            tvheight.visibility = View.VISIBLE
            etheight.visibility = View.VISIBLE
        } else {
            tvheight.visibility = View.INVISIBLE
            etheight.visibility = View.INVISIBLE
        }

        // Configura el listener del botón después de inicializar las vistas
        btnCalcular.setOnClickListener {
            Log.d("AreaActivity", "Botón de calcular presionado")
            calcularArea()
        }
    }

    private fun getDrawableResource(figura: String?): Int {
        return when (figura) {
            "triangulo" -> R.drawable.triangulo
            "pentagono" -> R.drawable.pentagono
            "ovalo" -> R.drawable.ovalo
            else -> throw IllegalArgumentException("Figura desconocida: $figura")
        }
    }

    private fun calcularArea() {
        Log.d("AreaActivity", "Calculando área...")

        val tipoForma = when (imagenview.drawable.constantState) {
            resources.getDrawable(R.drawable.pentagono, null).constantState -> "pentagono"
            resources.getDrawable(R.drawable.triangulo, null).constantState -> "triangulo"
            resources.getDrawable(R.drawable.ovalo, null).constantState -> "ovalo"
            else -> null
        }

        val resultado = when (tipoForma) {
            "triangulo" -> {
                val base = heightuser.text.toString().toDoubleOrNull() ?: 0.0
                val altura = etheight.text.toString().toDoubleOrNull() ?: 0.0
                (base * altura) / 2
            }

            "pentagono" -> {
                val lado = heightuser.text.toString().toDoubleOrNull() ?: 0.0
                0.25 * Math.sqrt(5.0 * (5 + 2 * Math.sqrt(5.0))) * lado * lado
            }

            "ovalo" -> {
                val semiEjeMayor = heightuser.text.toString().toDoubleOrNull() ?: 0.0
                val semiEjeMenor = etheight.text.toString().toDoubleOrNull() ?: 0.0
                Math.PI * semiEjeMayor * semiEjeMenor
            }

            else -> 0.0
        }

        Log.d("AreaActivity", "Área calculada: $resultado")

        resultadoAreaTextView.text = "Área: $resultado"
    }
}