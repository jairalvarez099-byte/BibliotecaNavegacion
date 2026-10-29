package com.sena.biblioteca.ui.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.DatoFila
import com.sena.biblioteca.ui.componentes.EtiquetaEstado
import com.sena.biblioteca.ui.componentes.PortadaLibro
import com.sena.biblioteca.ui.componentes.Tarjeta
import com.sena.biblioteca.ui.theme.GrisTexto
import com.sena.biblioteca.ui.theme.Verde

// Tarjeta con los 3 parámetros recibidos (libro, fecha y código), el autor y el estado
@Composable
fun DatosReservaSection(
    nombreLibro: String,
    fechaReserva: String,
    codigoReserva: String,
) {
    val autor = when (nombreLibro) {
        "Clean Code" -> "Robert C. Martin"
        "Kotlin para Android" -> "Antonio Leiva"
        "Arquitectura de Software" -> "Mark Richards"
        else -> "Google Developers"
    }

    Tarjeta {
        Row {
            PortadaLibro(nombreLibro = nombreLibro, tamano = 80)
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                DatoFila(etiqueta = "Nombre:", valor = nombreLibro)
                DatoFila(etiqueta = "Autor:", valor = autor)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        DatoFila(etiqueta = "Fecha Reserva:", valor = fechaReserva)
        DatoFila(etiqueta = "Código:", valor = codigoReserva)
        Row {
            Text(text = "Estado:", color = GrisTexto, modifier = Modifier.width(130.dp))
            EtiquetaEstado(estado = "Activa", color = Verde)
        }
    }
}
