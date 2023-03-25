package br.com.uware.jetpackcomposeuwaretutorial.data.local.data_source.imc

import br.com.uware.jetpackcomposeuwaretutorial.data.model.ImcDTO

/**
 * ImcLocalDataSource
 *
 * Interface dos dados sobre o IMC
 *
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 20 - Calculadora de IMC no Jetpack Compose
 */
interface ImcLocalDataSource {

    suspend fun getImcFromDataSource(imc: Float): ImcDTO

}