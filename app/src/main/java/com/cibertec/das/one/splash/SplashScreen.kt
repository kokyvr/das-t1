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

@Composable
fun SplashScreen(navController:NavController){
    var startAnimation by remember {
        mutableStateOf(false)
    }

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

        modifier = Modifier.fillMaxSize(),

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

            ShowSpinner()

        }

    }

}



