package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.BarraSuperior
import com.sena.biblioteca.ui.componentes.BotonGrande
import com.sena.biblioteca.ui.componentes.DatoFila
import com.sena.biblioteca.ui.componentes.PortadaLibro
import com.sena.biblioteca.ui.componentes.Tarjeta
import com.sena.biblioteca.ui.section.NuevaFechaSection
import com.sena.biblioteca.ui.theme.Fondo
import com.sena.biblioteca.ui.theme.Naranja

// PANTALLA 3 (Parte 2): Renovar la reserva escogiendo una nueva fecha
@Composable
fun RenovarReservaScreen(
    nombreLibro: String,
    fechaReserva: String,
    onConfirmar: (String) -> Unit,    // envía la nueva fecha
    onVolver: () -> Unit,
) {
    // ESTADO: variable que Compose "recuerda". Cuando cambia, la pantalla se redibuja.
    // Empieza con una fecha propuesta; el usuario la puede cambiar.
    var fechaNueva by remember { mutableStateOf("30/06/2026") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(16.dp)
    ) {
        BarraSuperior(titulo = "Renovar Reserva", onVolver = onVolver)

        Spacer(modifier = Modifier.height(16.dp))

        Tarjeta {
            Row(verticalAlignment = Alignment.CenterVertically) {
                PortadaLibro(nombreLibro = nombreLibro, tamano = 60)
                Spacer(modifier = Modifier.width(16.dp))
                DatoFila(etiqueta = "Libro:", valor = nombreLibro)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // La section muestra el campo; cada letra escrita llega aquí y actualiza fechaNueva
        NuevaFechaSection(
            fechaReserva = fechaReserva,
            fechaNueva = fechaNueva,
            onFechaNuevaChange = { nuevoValor -> fechaNueva = nuevoValor }
        )

        Spacer(modifier = Modifier.height(24.dp))

        BotonGrande(
            texto = "✔  Confirmar Renovación",
            color = Naranja,
            onClick = { onConfirmar(fechaNueva) }
        )
    }
}
