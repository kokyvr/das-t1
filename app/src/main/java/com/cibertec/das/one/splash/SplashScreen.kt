package com.cibertec.das.one.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.cibertec.das.one.R
import com.cibertec.das.one.routes.Routes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen(navController:NavController){
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val luckiestguyRegular = FontFamily(
        Font(R.font.luckiestguy_regular)
    )
    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1.2f else 0.8f,
        animationSpec = tween(1500),
        label = "scaleAnimation"
    )

    LaunchedEffect(true) {

        startAnimation = true

        delay(2500)

        navController.navigate(Routes.LOGIN) {

            popUpTo(Routes.SPLASH) {
                inclusive = true
            }

        }

    }

    Box(

        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFF5FFE0)),
        contentAlignment = Alignment.Center

    ) {

        Column(

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Image(

                painter = painterResource(id = R.drawable.foodtravel ),

                contentDescription = "Logo",

                modifier = Modifier
                    .size(180.dp)
                    .scale(scale)

            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "FOOD TRAVEL APP",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF51A753),
                            Color(0xFF84BE25)
                        )
                    ),
                    fontSize = 50.sp,
                    fontFamily = luckiestguyRegular,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            ShowSpinner()

        }

    }

}



