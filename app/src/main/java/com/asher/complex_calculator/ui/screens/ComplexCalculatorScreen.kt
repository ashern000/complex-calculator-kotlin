package com.asher.complex_calculator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.asher.complex_calculator.ui.components.CustomButton
import com.asher.complex_calculator.ui.components.Footer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComplexCalculatorScreen() {
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var inputError by remember { mutableStateOf("") }
    var operationCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Complex Calculator") },
                actions = {
                    Text(
                        text = "Operações: $operationCount",
                        modifier = Modifier.padding(end = 16.dp),
                        color = Color.White
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = firstNumber,
                    onValueChange = { firstNumber = it },
                    label = { Text("Primeiro valor") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.width(340.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = secondNumber,
                    onValueChange = { secondNumber = it },
                    label = { Text("Segundo valor") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.width(340.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row {
                    CustomButton(
                        onPress = {
                            val n1 = firstNumber.toFloatOrNull()
                            val n2 = secondNumber.toFloatOrNull()

                            if (n1 != null && n2 != null) {
                                inputError = ""
                                result = (n1 + n2).toString()
                                operationCount++
                            } else {
                                result = ""
                                inputError = "Revise a operação matemática novamente :)"
                            }
                        },
                        buttonText = "+",
                        textColor = Color.White,
                        backgroundColor = Color.Blue,
                        pressedColor = Color.Red
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    CustomButton(
                        onPress = {
                            val n1 = firstNumber.toFloatOrNull()
                            val n2 = secondNumber.toFloatOrNull()

                            if (n1 != null && n2 != null) {
                                inputError = ""
                                result = (n1 - n2).toString()
                                operationCount++
                            } else {
                                result = ""
                                inputError = "Por favor, revise a operação matemática :)"
                            }
                        },
                        buttonText = "-",
                        textColor = Color.White,
                        backgroundColor = Color.Blue,
                        pressedColor = Color.Red
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    CustomButton(
                        onPress = {
                            val n1 = firstNumber.toFloatOrNull()
                            val n2 = secondNumber.toFloatOrNull()

                            if (n1 != null && n2 != null) {
                                inputError = ""
                                result = (n1 * n2).toString()
                                operationCount++
                            } else {
                                result = ""
                                inputError = "Por favor, revise a operação matemática :)"
                            }
                        },
                        buttonText = "*",
                        textColor = Color.White,
                        backgroundColor = Color.Blue,
                        pressedColor = Color.Red
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    CustomButton(
                        onPress = {
                            val n1 = firstNumber.toFloatOrNull()
                            val n2 = secondNumber.toFloatOrNull()

                            if (n2 != null && n2 == 0f) {
                                result = ""
                                inputError = "Por favor, não divida por zero, isso é uma heresia!"
                            } else if (n1 != null && n2 != null) {
                                inputError = ""
                                result = (n1 / n2).toString()
                                operationCount++
                            } else {
                                result = ""
                                inputError = "Por favor, revise a operação matemática :)"
                            }
                        },
                        buttonText = "/",
                        textColor = Color.White,
                        backgroundColor = Color.Blue,
                        pressedColor = Color.Red
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    CustomButton(
                        onPress = {
                            val n1 = firstNumber.toDoubleOrNull()
                            val n2 = secondNumber.toDoubleOrNull()

                            if (n1 != null && n2 != null) {
                                inputError = ""
                                result = (Math.pow(n1, n2)).toString()
                                operationCount++
                            } else {
                                result = ""
                                inputError = "Por favor, revise a operação matemática :)"
                            }
                        },
                        buttonText = "^",
                        textColor = Color.White,
                        backgroundColor = Color.Blue,
                        pressedColor = Color.Red
                    )

                    Spacer(modifier = Modifier.width(20.dp))


                    CustomButton(
                        onPress = {
                            val n1 = firstNumber.toFloatOrNull()

                            if (n1 != null) {
                                inputError = ""
                                result = Math.sqrt(n1.toDouble()).toString()
                                operationCount++
                            } else {
                                result = ""
                                inputError = "Por favor, revise a operação matemática :)"
                            }
                        },
                        buttonText = "√",
                        textColor = Color.White,
                        backgroundColor = Color.Blue,
                        pressedColor = Color.Red
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                if (result.isNotEmpty()) {
                    Text(text = "Resultado da operação: $result")
                }

                if (inputError.isNotEmpty()) {
                    Text(text = inputError)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Footer()
            }
        }
    }
}