package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.BarraSuperior
import com.sena.biblioteca.ui.componentes.BotonGrande
import com.sena.biblioteca.ui.section.DatosReservaSection
import com.sena.biblioteca.ui.theme.Fondo
import com.sena.biblioteca.ui.theme.GrisTexto
import com.sena.biblioteca.ui.theme.Rojo
import com.sena.biblioteca.ui.theme.Verde

// PANTALLA 2 (Parte 2): Detalle de la reserva. Recibe 3 parámetros.
@Composable
fun DetalleReservaScreen(
    nombreLibro: String,
    fechaReserva: String,
    codigoReserva: String,
    onRenovar: () -> Unit,
    onCancelar: () -> Unit,
    onVolver: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(16.dp)
    ) {
        BarraSuperior(titulo = "Detalle de Reserva", onVolver = onVolver)

        Text(
            text = "✔ Argumentos recibidos",
            color = Verde,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(Verde.copy(alpha = 0.1f), RoundedCornerShape(10.dp))
                .padding(10.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        DatosReservaSection(
            nombreLibro = nombreLibro,
            fechaReserva = fechaReserva,
            codigoReserva = codigoReserva
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "ℹ Estos datos fueron enviados desde la pantalla anterior como parámetros.",
            color = GrisTexto
        )

        Spacer(modifier = Modifier.height(24.dp))

        BotonGrande(texto = "🔄  Renovar Reserva", color = Verde, onClick = onRenovar)
        Spacer(modifier = Modifier.height(12.dp))
        BotonGrande(texto = "✖  Cancelar Reserva", color = Rojo, onClick = onCancelar)
    }
}
