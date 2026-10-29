package com.sena.biblioteca.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.sena.biblioteca.ui.theme.Verde

// Círculo con el chulo ✔ y un título verde.
// Se reutiliza en Confirmación ("Reserva Exitosa") y en Renovación Exitosa ("Reserva Renovada")
@Composable
fun ExitoSection(
    titulo: String,
    colorCirculo: Color,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(150.dp)
                .background(colorCirculo, CircleShape)
        ) {
            Text(text = "✔", fontSize = 85.sp, color = Verde)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = titulo,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Verde
        )
    }
}
