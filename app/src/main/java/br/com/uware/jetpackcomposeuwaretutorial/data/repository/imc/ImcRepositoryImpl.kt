package br.com.uware.jetpackcomposeuwaretutorial.data.repository.imc

import android.util.Log
import br.com.uware.jetpackcomposeuwaretutorial.data.local.data_source.imc.ImcLocalDataSource
import br.com.uware.jetpackcomposeuwaretutorial.domain.core.resource.Resource
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.util.UiText
import javax.inject.Inject

/**
 * ImcRepositoryImpl
 *
 * Implementação do repositório do IMC
 *
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
class ImcRepositoryImpl @Inject constructor(
    private val imcLocalDataSource: ImcLocalDataSource
): ImcRepository {

    private val TAG = javaClass.simpleName

    override suspend fun getImc(imc: Float): Resource {
        return try {
            Resource.Success(imcLocalDataSource.getImcFromDataSource(imc))
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
            Resource.Error(UiText.DynamicString(e.toString()))
        }
    }
}