package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.BarraSuperior
import com.sena.biblioteca.ui.componentes.BotonGrande
import com.sena.biblioteca.ui.componentes.DatoFila
import com.sena.biblioteca.ui.componentes.PortadaLibro
import com.sena.biblioteca.ui.componentes.Tarjeta
import com.sena.biblioteca.ui.theme.Fondo
import com.sena.biblioteca.ui.theme.Morado
import com.sena.biblioteca.ui.theme.Naranja

// PANTALLA 3 (Parte 1): Detalle del libro
@Composable
fun DetalleLibroScreen(
    nombreLibro: String,              // parámetro RECIBIDO desde la lista
    onReservar: (String) -> Unit,
    onVolver: () -> Unit,
) {
    // Con el nombre recibido escogemos el resto de datos (datos estáticos)
    val autor = when (nombreLibro) {
        "Clean Code" -> "Robert C. Martin"
        "Kotlin para Android" -> "Antonio Leiva"
        "Arquitectura de Software" -> "Mark Richards"
        else -> "Google Developers"
    }
    val categoria = when (nombreLibro) {
        "Clean Code" -> "Programación"
        "Kotlin para Android" -> "Desarrollo móvil"
        "Arquitectura de Software" -> "Arquitectura"
        else -> "Interfaces"
    }
    val descripcion = when (nombreLibro) {
        "Clean Code" -> "Guía práctica para escribir código limpio, legible y mantenible. Un clásico imprescindible para desarrolladores."
        "Kotlin para Android" -> "Aprende el lenguaje oficial de Android desde cero con ejemplos prácticos."
        "Arquitectura de Software" -> "Conceptos y patrones para diseñar sistemas grandes, ordenados y fáciles de mantener."
        else -> "Crea interfaces modernas en Android escribiendo funciones de Kotlin en lugar de XML."
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        BarraSuperior(titulo = "Detalle del Libro", onVolver = onVolver)

        // Aviso que muestra el parámetro que llegó
        Text(
            text = "⬇ Parámetro recibido: $nombreLibro",
            color = Naranja,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Naranja.copy(alpha = 0.1f), RoundedCornerShape(10.dp))
                .padding(10.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            PortadaLibro(nombreLibro = nombreLibro, tamano = 120)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Tarjeta {
            DatoFila(etiqueta = "Nombre:", valor = nombreLibro)
            DatoFila(etiqueta = "Autor:", valor = autor)
            DatoFila(etiqueta = "Categoría:", valor = categoria, colorValor = Morado)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Descripción:", fontWeight = FontWeight.Bold)
            Text(text = descripcion)
        }

        Spacer(modifier = Modifier.height(24.dp))

        BotonGrande(
            texto = "🔖  Reservar Libro",
            color = Naranja,
            onClick = { onReservar(nombreLibro) }
        )
    }
}
