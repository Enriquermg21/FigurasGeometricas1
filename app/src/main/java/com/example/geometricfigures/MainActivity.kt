package com.example.geometricfigures

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var areaView: View
    private lateinit var imgvarea: ImageView
    private lateinit var tvtitlevarea: TextView
    private lateinit var tvcalcular: TextView
    private lateinit var tvheight: TextView
    private lateinit var tvbase: TextView
    private lateinit var etheight: TextView
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
        etheight = areaView.findViewById(R.id.etHeight)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    fun imageClicked(view: View) {
        val intent = Intent(this, AreaActivity::class.java)

        when (view.id) {
            R.id.ivTriangle -> {
                intent.putExtra("figura", "triangulo")
                intent.putExtra("titulo", getString(R.string.tvTitlevArea))
                intent.putExtra("calcular", getString(R.string.tvCalculateArea))
                intent.putExtra("altura", getString(R.string.tvComponentHeight))
                intent.putExtra("base", getString(R.string.tvheightpentagono))
            }
            R.id.ivPentagon -> {
                intent.putExtra("figura", "pentagono")
                intent.putExtra("titulo", getString(R.string.tvTitlevpentagono))
                intent.putExtra("calcular", getString(R.string.tvCalculateAreaPentagono))
                intent.putExtra("base", getString(R.string.tvheightpentagono))
                intent.putExtra("alturaVisible", false)
            }
            R.id.ivOval -> {
                intent.putExtra("figura", "ovalo")
                intent.putExtra("titulo", getString(R.string.tvTitlevovalo))
                intent.putExtra("calcular", getString(R.string.tvCalculateAreaOvalo))
                intent.putExtra("altura", getString(R.string.tvheightovalo))
                intent.putExtra("base", getString(R.string.tvbaseOvalo))
            }
        }
        startActivity(intent)
    }
}