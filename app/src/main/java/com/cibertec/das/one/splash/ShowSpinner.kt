package com.cibertec.das.one.splash

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowSpinner(){
    Spacer(modifier = Modifier.height(8.dp))
    LinearProgressIndicator(
        color = Color(0xFF7FBD00),
        trackColor = Color(0xFFD0E8A0)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = "Cargando...",
        fontSize = 12.sp,
        color = Color(0xFF51A753),
        fontWeight = FontWeight.Bold
    )
}