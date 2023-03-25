package br.com.uware.jetpackcomposeuwaretutorial.presentation.components.buttons.elevated

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.Purple40

/**
 * ButtonElevatedComponent
 *
 * Botão com elevação
 *
 * @param modifier Customizador
 * @param label Nome escrito no botão
 * @param containerColor Cor do botão
 * @param contentColor Cor da letra
 * @param onClick Fução de click
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
@Composable
fun ButtonElevatedComponent(
    modifier: Modifier = Modifier,
    label: String,
    containerColor: Color = Purple40,
    contentColor: Color = Color.White,
    onClick: () -> Unit
) {
    ElevatedButton(
        modifier = modifier.fillMaxWidth(),
        onClick = { onClick() },
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = AppDimensions.LARGE,
            pressedElevation = AppDimensions.NONE
        ),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Text(text = label)
    }
}