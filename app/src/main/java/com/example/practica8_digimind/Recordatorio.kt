package com.example.practica8_digimind

import java.io.Serializable

/*
    Eduardo Talavera Ramos
    00000245244
    18/02/2025
 */
data class Recordatorio(
    var dias: String,
    var tiempo: String,
    var nombre: String
) : Serializable