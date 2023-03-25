package br.com.uware.jetpackcomposeuwaretutorial.presentation.components.texts.input_field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

/**
 * InputFieldComponent
 *
 * Campo para entrada de texto.
 *
 * @param valueState MutableState de uma String com o valor do campo.
 * @param label Nome do título do campo.
 * @param containerColor Cor do container.
 * @param contentColor Cor das letras.
 * @param imeAction Ação do botão de enter.
 * @param keyboardType Tipo de teclado.
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 20 - Calculadora de IMC no Jetpack Compose
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFieldComponent(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    label: String,
    isEnable: Boolean = true,
    isSingleLine: Boolean = true,
    containerColor: Color = Color.Transparent,
    contentColor: Color = Color.Black,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    leadingIcon: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {}
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(text = label)
        },
        enabled = isEnable,
        singleLine = isSingleLine,
        value = valueState.value,
        onValueChange = {
            valueState.value = it
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = containerColor,
            focusedTextColor = contentColor,
            unfocusedTextColor = contentColor,
            disabledTextColor = contentColor,
            unfocusedLabelColor = contentColor,
            focusedPlaceholderColor = contentColor,
            disabledPlaceholderColor = contentColor,
            unfocusedPlaceholderColor = contentColor
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        leadingIcon = {
            leadingIcon()
        },
        trailingIcon = {
            trailingIcon()
        }
    )
}