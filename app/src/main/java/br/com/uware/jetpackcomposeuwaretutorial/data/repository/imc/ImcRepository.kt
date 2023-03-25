package br.com.uware.jetpackcomposeuwaretutorial.data.repository.imc

import br.com.uware.jetpackcomposeuwaretutorial.domain.core.resource.Resource

/**
 * ImcRepository
 *
 * Interface do repositório do IMC
 *
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
interface ImcRepository {
    suspend fun getImc(imc: Float): Resource
}