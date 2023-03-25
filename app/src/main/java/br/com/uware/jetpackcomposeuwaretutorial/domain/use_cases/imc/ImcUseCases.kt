package br.com.uware.jetpackcomposeuwaretutorial.domain.use_cases.imc


/**
 * ImcUseCases
 *
 * Data class que será injetada no viewModel
 *
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
data class ImcUseCases(
    val calculateImc: CalculateImcUseCase
)
