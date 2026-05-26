package com.cibertec.das.one.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cibertec.das.one.R
import kotlinx.coroutines.launch
import java.util.Objects

@Composable
fun LoginScreen(navController: NavController) {

    var errorMessage by remember { mutableStateOf<String?>(null) }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Scaffold (


    ) { paddingValues ->
        if (errorMessage != null) {
            AlertDialog(
                onDismissRequest = {
                    errorMessage = null
                },
                confirmButton = {
                    Button (onClick = {
                        errorMessage = null
                    }) {
                        Text("OK")
                    }
                },
                title = {
                    Text("Error")
                },
                text = {
                    Text(errorMessage ?: "")
                }
            )
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.foodtravel),
                contentDescription = "Logo",
                modifier = Modifier.size(140.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            FieldEmail(
                email = email,
                onEmailChange = {
                    email = it
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            FieldPassword(
                password = password,
                onPasswordChange = {
                    password = it
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(

                onClick = fun(){

                    val error = validateLogin(email, password)

                    if(error != null) {
                        errorMessage = error
                        return
                    }

                    val loginSucces = login(email,password);
                    if(!loginSucces){
                        errorMessage = "Email o Contraseña Incorrecta"
                    }
                    navController.navigate("home")
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                )

            ) {

                Text("INGRESAR")
            }
        }
    }
}
@Composable
fun FieldEmail(    email: String,
                   onEmailChange: (String) -> Unit){
    Text(
        text = "Correo",
        modifier = Modifier.fillMaxWidth(),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )

    Spacer(modifier = Modifier.height(6.dp))

    OutlinedTextField(

        value = email,

        onValueChange = { value ->
            onEmailChange(value)
        },

        modifier = Modifier.fillMaxWidth(),

        placeholder = {
            Text("correo@ejemplo.com")
        },

        singleLine = true
    )
}
@Composable
fun FieldPassword(password: String,
                  onPasswordChange: (String) -> Unit){
    Text(
        text = "Contraseña",
        modifier = Modifier.fillMaxWidth(),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )

    Spacer(modifier = Modifier.height(6.dp))

    OutlinedTextField(
        value = password,

        onValueChange = { value ->
            onPasswordChange(value)
        },

        modifier = Modifier.fillMaxWidth(),

        placeholder = {
            Text("********")
        },

        visualTransformation = PasswordVisualTransformation(),

        singleLine = true
    )
}

fun validateLogin(
    email: String,
    password: String
): String? {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
    if(email.isEmpty() ) {
        return "Campo Email vacio"
    }
    val isValid = emailRegex.matches(email)
    if (!isValid) {
        return "Email inválido"
    }
    if(password.isEmpty()){
        return "Campo Contraseña vacio"
    }

    if(password.length < 6) {
        return "La contraseña es muy corta"
    }
    return null
}


fun login(    email: String,
              password: String):Boolean{
    val user = UserData.getUserData().firstOrNull {
        it.email == email && it.password == password
    }
    println(email);
    println(password);
    println(user)
    return !Objects.isNull(user);
}