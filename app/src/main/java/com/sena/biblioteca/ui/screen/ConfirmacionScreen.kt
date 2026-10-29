package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.BotonGrande
import com.sena.biblioteca.ui.componentes.DatoFila
import com.sena.biblioteca.ui.componentes.Tarjeta
import com.sena.biblioteca.ui.section.ExitoSection
import com.sena.biblioteca.ui.theme.Morado
import com.sena.biblioteca.ui.theme.Verde

// PANTALLA 4 (Parte 1): Confirmación de la reserva
@Composable
fun ConfirmacionScreen(
    nombreLibro: String,
    fechaReserva: String,
    onVolverInicio: () -> Unit,
    onVerMisReservas: () -> Unit,     // puente hacia la Parte 2
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFF8F0))
            .padding(24.dp)
    ) {
        ExitoSection(titulo = "Reserva Exitosa", colorCirculo = Verde.copy(alpha = 0.15f))

        Spacer(modifier = Modifier.height(24.dp))

        Tarjeta {
            DatoFila(etiqueta = "📗 Libro:", valor = nombreLibro)
            DatoFila(etiqueta = "📅 Fecha:", valor = fechaReserva)
        }

        Spacer(modifier = Modifier.height(32.dp))

        BotonGrande(texto = "📋  Ver Mis Reservas", color = Morado, onClick = onVerMisReservas)
        Spacer(modifier = Modifier.height(12.dp))
        BotonGrande(texto = "🏠  Volver al Inicio", color = Verde, onClick = onVolverInicio)
    }
}
