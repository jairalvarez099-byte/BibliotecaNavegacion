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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.BarraSuperior
import com.sena.biblioteca.ui.componentes.BotonGrande
import com.sena.biblioteca.ui.section.InfoLibroSection
import com.sena.biblioteca.ui.theme.Fondo
import com.sena.biblioteca.ui.theme.Naranja

// PANTALLA 3 (Parte 1): Detalle del libro
@Composable
fun DetalleLibroScreen(
    nombreLibro: String,              // parámetro RECIBIDO desde la lista
    onReservar: (String) -> Unit,
    onVolver: () -> Unit,
) {
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

        InfoLibroSection(nombreLibro = nombreLibro)

        Spacer(modifier = Modifier.height(24.dp))

        BotonGrande(
            texto = "🔖  Reservar Libro",
            color = Naranja,
            onClick = { onReservar(nombreLibro) }
        )
    }
}
