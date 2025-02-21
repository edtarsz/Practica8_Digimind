package com.example.practica8_digimind

import java.io.Serializable

/*
    Eduardo Talavera Ramos
    00000245244
    18/02/2025
 */
class Carrito : Serializable {
    var recordatorios = ArrayList<Recordatorio>()

    fun agregar(p: Recordatorio): Boolean {
        return recordatorios.add(p)
    }
}