package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca.ui.componentes.BotonGrande
import com.sena.biblioteca.ui.componentes.DatoFila
import com.sena.biblioteca.ui.componentes.Tarjeta
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(140.dp)
                .background(Color.White, CircleShape)
        ) {
            Text(text = "✔", fontSize = 80.sp, color = Verde)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Reserva Renovada",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Verde
        )

        Spacer(modifier = Modifier.height(24.dp))

        Tarjeta {
            DatoFila(etiqueta = "📗 Libro:", valor = nombreLibro)
            DatoFila(etiqueta = "📅 Nueva Fecha:", valor = fechaNueva)
        }

        Spacer(modifier = Modifier.height(32.dp))

        BotonGrande(texto = "🏠  Volver a Mis Reservas", color = Verde, onClick = onVolverMisReservas)
    }
}
