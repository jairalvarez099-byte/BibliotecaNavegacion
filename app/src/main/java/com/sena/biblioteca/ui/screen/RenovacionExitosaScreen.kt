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
import com.sena.biblioteca.ui.theme.Verde

// PANTALLA 4 (Parte 2): Renovación exitosa
@Composable
fun RenovacionExitosaScreen(
    nombreLibro: String,
    fechaNueva: String,
    onVolverMisReservas: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFF8F0))
            .padding(24.dp)
    ) {
        ExitoSection(titulo = "Reserva Renovada", colorCirculo = Color.White)

        Spacer(modifier = Modifier.height(24.dp))

        Tarjeta {
            DatoFila(etiqueta = "📗 Libro:", valor = nombreLibro)
            DatoFila(etiqueta = "📅 Nueva Fecha:", valor = fechaNueva)
        }

        Spacer(modifier = Modifier.height(32.dp))

        BotonGrande(texto = "🏠  Volver a Mis Reservas", color = Verde, onClick = onVolverMisReservas)
    }
}
