package com.sena.biblioteca.ui.section

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.DatoFila
import com.sena.biblioteca.ui.componentes.Tarjeta

// Tarjeta con la reserva actual y el campo para escribir la nueva fecha.
// La variable fechaNueva vive en la pantalla; aquí solo se muestra y se avisa cuando cambia.
@Composable
fun NuevaFechaSection(
    fechaReserva: String,
    fechaNueva: String,
    onFechaNuevaChange: (String) -> Unit,
) {
    Tarjeta {
        DatoFila(etiqueta = "Reserva Actual:", valor = "📅 $fechaReserva")
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = fechaNueva,
            onValueChange = onFechaNuevaChange,
            label = { Text(text = "Nueva Fecha (dd/mm/aaaa)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
