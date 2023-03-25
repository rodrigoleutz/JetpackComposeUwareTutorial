package br.com.uware.jetpackcomposeuwaretutorial.domain.model

import androidx.compose.ui.graphics.Color

/**
 * Imc
 *
 * Model Imc do domain passado para o presentation.
 *
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
data class Imc(
    val imc: Float,
    val string: String,
    val color: Color
)
