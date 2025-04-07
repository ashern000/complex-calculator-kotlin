package com.asher.complex_calculator.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*

@Composable
fun CustomButton(
    onPress: () -> Unit,
    buttonText: String,
    textColor: Color,
    backgroundColor: Color,
    pressedColor: Color
) {
    val interactionSource = remember { MutableInteractionSource() }
    Button(
        onClick = onPress,
        modifier = Modifier
            .width(160.dp)
            .height(48.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(color = pressedColor),
                onClick = onPress
            ),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        )
    ) {
        Text(text = buttonText, fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    CustomButton(
        onPress = {},
        buttonText = "Button name",
        textColor = Color.White,
        backgroundColor = Color.Black,
        pressedColor = Color.Gray
    )
}