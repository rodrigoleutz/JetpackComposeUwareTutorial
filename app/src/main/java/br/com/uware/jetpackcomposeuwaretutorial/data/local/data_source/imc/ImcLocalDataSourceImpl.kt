package br.com.uware.jetpackcomposeuwaretutorial.data.local.data_source.imc

import androidx.compose.ui.graphics.Color
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.data.model.ImcDTO
import br.com.uware.jetpackcomposeuwaretutorial.data.utils.lessThanOrEqual
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.util.UiText
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.*

/**
 * ImcLocalDataSourceImpl
 *
 * Implementação da fonte de dados de IMC.
 *
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
class ImcLocalDataSourceImpl : ImcLocalDataSource {

    private fun getString(imc: Float): UiText {
        val arrayStrings = arrayListOf<Int>(
            R.string.imc_string_0,
            R.string.imc_string_1,
            R.string.imc_string_2,
            R.string.imc_string_3,
            R.string.imc_string_4,
            R.string.imc_string_5,
            R.string.imc_string_6,
        )
        return UiText.StringResource(
            arrayStrings[getImcArrayPosition(imc)]
        )
    }

    private fun getColor(imc: Float): Color {
        val arrayColors = arrayListOf<Color>(
            ImcColor0,
            ImcColor1,
            ImcColor2,
            ImcColor3,
            ImcColor4,
            ImcColor5,
            ImcColor6,
        )
        return arrayColors[getImcArrayPosition(imc)]
    }

    private fun getMinAndMaxValue(imc: Float): Pair<Float?, Float?> {
        val arrayMinAndMaxValue = arrayListOf<Pair<Float?, Float?>>(
            Pair(null, 17.09f),
            Pair(17.1f, 18.49f),
            Pair(18.5f, 24.99f),
            Pair(25.0f, 29.99f),
            Pair(30.0f, 34.99f),
            Pair(35.0f, null)
        )
        return arrayMinAndMaxValue[getImcArrayPosition(imc)]
    }

    private fun getImcArrayPosition(imc: Float): Int =
        when {
            imc lessThanOrEqual 17.09f -> 0
            imc in 17.1f..18.49f -> 1
            imc in 18.5f..24.99f -> 2
            imc in 25.0f..29.99f -> 3
            imc in 30.0f..34.99f -> 4
            imc in 35.0f..39.99f -> 5
            else -> 6
        }

    override suspend fun getImcFromDataSource(imc: Float): ImcDTO {
        val minAndMaxValue = getMinAndMaxValue(imc)
        return ImcDTO(
            minValue = minAndMaxValue.first,
            maxValue = minAndMaxValue.second,
            string = getString(imc),
            color = getColor(imc)
        )
    }
}