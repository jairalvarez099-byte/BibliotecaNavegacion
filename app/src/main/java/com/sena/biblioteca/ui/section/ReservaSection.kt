package com.sena.biblioteca.ui.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.BotonGrande
import com.sena.biblioteca.ui.componentes.DatoFila
import com.sena.biblioteca.ui.componentes.EtiquetaEstado
import com.sena.biblioteca.ui.componentes.PortadaLibro
import com.sena.biblioteca.ui.componentes.Tarjeta
import com.sena.biblioteca.ui.theme.Morado
import com.sena.biblioteca.ui.theme.Rojo
import com.sena.biblioteca.ui.theme.Verde

// Tarjeta de una reserva: portada, libro, fecha, estado y botón "Ver Reserva"
@Composable
fun ReservaSection(
    nombreLibro: String,
    fechaReserva: String,
    estado: String,                   // "Activa" o "Cancelada"
    onVerReserva: () -> Unit,
) {
    val estaActiva = estado == "Activa"

    Tarjeta {
        Row {
            PortadaLibro(nombreLibro = nombreLibro, tamano = 70)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                DatoFila(etiqueta = "Libro:", valor = nombreLibro)
                DatoFila(etiqueta = "Fecha:", valor = fechaReserva)
                Spacer(modifier = Modifier.height(4.dp))
                EtiquetaEstado(estado = estado, color = if (estaActiva) Verde else Rojo)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Solo se puede ver/renovar una reserva activa
        if (estaActiva) {
            BotonGrande(texto = "👁  Ver Reserva", color = Morado, onClick = onVerReserva)
        }
    }
}
