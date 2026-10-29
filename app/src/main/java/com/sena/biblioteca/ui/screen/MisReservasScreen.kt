package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca.ui.componentes.BarraSuperior
import com.sena.biblioteca.ui.componentes.BotonGrande
import com.sena.biblioteca.ui.componentes.DatoFila
import com.sena.biblioteca.ui.componentes.EtiquetaEstado
import com.sena.biblioteca.ui.componentes.PortadaLibro
import com.sena.biblioteca.ui.componentes.Tarjeta
import com.sena.biblioteca.ui.theme.Fondo
import com.sena.biblioteca.ui.theme.Morado
import com.sena.biblioteca.ui.theme.Rojo
import com.sena.biblioteca.ui.theme.Verde

// PANTALLA 1 (Parte 2): Mis Reservas
@Composable
fun MisReservasScreen(
    nombreLibro: String,
    fechaReserva: String,
    estado: String,                   // "Activa" o "Cancelada"
    onVerReserva: () -> Unit,
    onVolver: () -> Unit,
) {
    val estaActiva = estado == "Activa"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(16.dp)
    ) {
        BarraSuperior(titulo = "Mis Reservas", onVolver = onVolver)
        Text(text = "📚 Lista de reservas", fontWeight = FontWeight.Medium, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Si la reserva fue cancelada mostramos un aviso rojo
        if (!estaActiva) {
            Text(
                text = "✖ Reserva Cancelada",
                color = Rojo,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Rojo.copy(alpha = 0.1f), RoundedCornerShape(10.dp))
                    .padding(12.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

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

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "ℹ Aquí verás todas tus reservas.", color = Morado)
    }
}
