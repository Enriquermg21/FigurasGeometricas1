package com.example.geometricfigures

import android.widget.EditText
import kotlin.math.sqrt

abstract class FormaGeometrica {

    abstract fun calcularArea(): Double
}

class Triangulo(private val base: EditText, private val altura: EditText) : FormaGeometrica() {
    override fun calcularArea(): Double {
        val baseDouble = base.text.toString().toDoubleOrNull() ?: 0.0
        val alturaDouble = altura.text.toString().toDoubleOrNull() ?: 0.0
        return (baseDouble * alturaDouble) / 2
    }
}

class Pentagono(private val lado: EditText) : FormaGeometrica() {
    override fun calcularArea(): Double {
        val ladoDouble = lado.text.toString().toDoubleOrNull() ?: 0.0
        return 0.25 * sqrt(5.0 * (5 + 2 * sqrt(5.0))) * ladoDouble * ladoDouble
    }
}

class Ovalo(private val semiEjeMayor: EditText, private val semiEjeMenor: EditText) :
    FormaGeometrica() {
    override fun calcularArea(): Double {
        val semiEjeMayorDouble = semiEjeMayor.text.toString().toDoubleOrNull() ?: 0.0
        val semiEjeMenorDouble = semiEjeMenor.text.toString().toDoubleOrNull() ?: 0.0
        return Math.PI * semiEjeMayorDouble * semiEjeMenorDouble
    }
}
