package br.com.uware.jetpackcomposeuwaretutorial.data.model

import androidx.compose.ui.graphics.Color
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.util.UiText

/**
 * ImcDTO
 *
 * Data transfer object
 *
 * @param maxValue Valor máximo
 * @param minValue Valor mínimo
 * @param string String sobre o valor do imc
 * @param color Cor do valor do imc
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
data class ImcDTO(
    val maxValue: Float?,
    val minValue: Float?,
    val string: UiText,
    val color: Color
)
