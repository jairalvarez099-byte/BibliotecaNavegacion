package com.sena.biblioteca.ui.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.DatoFila
import com.sena.biblioteca.ui.componentes.PortadaLibro
import com.sena.biblioteca.ui.componentes.Tarjeta
import com.sena.biblioteca.ui.theme.Morado

// Portada grande y tarjeta con los datos del libro
@Composable
fun InfoLibroSection(
    nombreLibro: String,
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

    Column {
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
    }
}
