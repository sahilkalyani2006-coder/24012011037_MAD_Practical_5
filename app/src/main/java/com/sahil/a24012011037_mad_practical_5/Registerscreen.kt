package com.sahil.a24012011037_mad_practical_5

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sahil.a24012011037_mad_practical_5.ui.theme.Pink40

@Composable
fun RegisterScreen(
    context: Context = LocalContext.current,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        RegisterUI(
            context = context,
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun RegisterUI(
    context: Context,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo),
            contentDescription = "GUNI Logo",
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Name
                FormField(
                    label = "Name",
                    textState = name,
                    onTextChange = { name = it },
                    placeholder = "Enter Name"
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Phone number
                FormField(
                    label = "Phone",
                    textState = phoneNumber,
                    onTextChange = { phoneNumber = it },
                    placeholder = "Enter Phone Number",
                    isNumber = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                // City
                FormField(
                    label = "City",
                    textState = city,
                    onTextChange = { city = it },
                    placeholder = "Enter City"
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Email
                FormField(
                    label = "Email",
                    textState = email,
                    onTextChange = { email = it },
                    placeholder = "Enter Email"
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Password
                FormField(
                    label = "Password",
                    textState = password,
                    onTextChange = { password = it },
                    placeholder = "Enter Password",
                    isPasswordField = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Confirm password
                FormField(
                    label = "Confirm",
                    textState = confirmPassword,
                    onTextChange = { confirmPassword = it },
                    placeholder = "Confirm Password",
                    isPasswordField = true
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Register button
                Button(
                    onClick = {
                        when {
                            name.isBlank() ||
                                    phoneNumber.isBlank() ||
                                    city.isBlank() ||
                                    email.isBlank() ||
                                    password.isBlank() ||
                                    confirmPassword.isBlank() -> {
                                Toast.makeText(
                                    context,
                                    "Please fill in all fields",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            !android.util.Patterns.EMAIL_ADDRESS
                                .matcher(email.trim())
                                .matches() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter a valid email",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            phoneNumber.length != 10 -> {
                                Toast.makeText(
                                    context,
                                    "Enter a 10-digit phone number",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            password.length < 6 -> {
                                Toast.makeText(
                                    context,
                                    "Password must be at least 6 characters",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            password != confirmPassword -> {
                                Toast.makeText(
                                    context,
                                    "Passwords do not match",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            else -> {
                                Toast.makeText(
                                    context,
                                    "Registration successful (demo only)",
                                    Toast.LENGTH_SHORT
                                ).show()

                                navController.navigate("login") {
                                    popUpTo("register") {
                                        inclusive = true
                                    }
                                }
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Pink40
                    )
                ) {
                    Text(
                        text = "REGISTER",
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Navigate to Login screen
                TextButton(
                    onClick = {
                        navController.navigate("login") {
                            popUpTo("register") {
                                inclusive = true
                            }
                        }
                    }
                ) {
                    Text(
                        text = "Already have an account? LOGIN",
                        color = Pink40
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun navigatetoregistrationScreen(
    navController: NavController
) {
    navController.navigate("login") {
        popUpTo("register") {
            inclusive = true
        }
    }
}