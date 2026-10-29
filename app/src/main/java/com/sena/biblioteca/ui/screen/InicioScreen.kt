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
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.BotonGrande
import com.sena.biblioteca.ui.section.BienvenidaSection
import com.sena.biblioteca.ui.theme.Fondo
import com.sena.biblioteca.ui.theme.Morado

// PANTALLA 1 (Parte 1): Bienvenida a la biblioteca
@Composable
fun InicioScreen(
    onVerLibros: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(24.dp)
    ) {
        BienvenidaSection()

        Spacer(modifier = Modifier.height(48.dp))

        // Al tocar el botón se ejecuta onVerLibros (la navegación la decide AppNavegacion)
        BotonGrande(
            texto = "📖  Ver Libros",
            color = Morado,
            onClick = onVerLibros
        )
    }
}
