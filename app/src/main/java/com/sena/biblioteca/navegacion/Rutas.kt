package com.sena.biblioteca.navegacion

import kotlinx.serialization.Serializable

// Cada pantalla de la app es una RUTA.
// data object  -> pantalla que NO recibe parámetros
// data class   -> pantalla que SÍ recibe parámetros (sus variables son los parámetros)

// ---------- PARTE 1: Biblioteca ----------

@Serializable
data object Inicio

@Serializable
data object ListaLibros

@Serializable
data class DetalleLibro(
    val nombreLibro: String,
)

@Serializable
data class Confirmacion(
    val nombreLibro: String,
    val fechaReserva: String,
)

// ---------- PARTE 2: Mis Reservas ----------

@Serializable
data class MisReservas(
    val nombreLibro: String,
    val fechaReserva: String,
    val estado: String,
)

@Serializable
data class DetalleReserva(
    val nombreLibro: String,
    val fechaReserva: String,
    val codigoReserva: String,
)

@Serializable
data class RenovarReserva(
    val nombreLibro: String,
    val fechaReserva: String,
)

@Serializable
data class RenovacionExitosa(
    val nombreLibro: String,
    val fechaNueva: String,
)
