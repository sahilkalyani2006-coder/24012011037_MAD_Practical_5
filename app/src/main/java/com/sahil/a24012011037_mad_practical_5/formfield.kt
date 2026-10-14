package com.sahil.a24012011037_mad_practical_5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahil.a24012011037_mad_practical_5.ui.theme._24012021005_practical_5Theme

@Composable fun FormField(
    label: String,
    textState: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isPasswordField: Boolean = false,
    isNumber: Boolean = false,
    placeholder: String? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF333333),
            modifier = Modifier.weight(1f)
        )
        OutlinedTextField( value = textState,
            onValueChange = { newValue ->
                if (!isNumber || newValue.all { it.isDigit() }) {
                    onTextChange(newValue)
                }
            },
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(2f),
            textStyle = LocalTextStyle.current.copy(fontSize = 14.sp),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            visualTransformation = if (isPasswordField)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,
            placeholder = { Text(
                text = placeholder ?: "Enter $label",
                fontSize = 14.sp,
                color = Color(0xFF666666)
            )
            },
            keyboardOptions = if (isNumber)
                KeyboardOptions(keyboardType = KeyboardType.Number)
            else
                KeyboardOptions.Default,
            colors = OutlinedTextFieldDefaults.colors( focusedBorderColor = Color(0xFF7A7A7A),
                unfocusedBorderColor = Color(0xFF8E8E93),
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)

@Composable
fun FormFieldPreview() {
    _24012021005_practical_5Theme() {
        FormField(
            label = "Password", textState = "", onTextChange = {}, isPasswordField = true
        )
    }
}