package br.com.uware.jetpackcomposeuwaretutorial.domain.use_cases.imc

import android.content.Context
import br.com.uware.jetpackcomposeuwaretutorial.data.model.ImcDTO
import br.com.uware.jetpackcomposeuwaretutorial.data.repository.imc.ImcRepository
import br.com.uware.jetpackcomposeuwaretutorial.domain.core.resource.Resource
import br.com.uware.jetpackcomposeuwaretutorial.domain.model.Imc
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.util.UiText
import javax.inject.Inject
import kotlin.math.pow

/**
 * CalculateImcUseCase
 *
 * Função que faz o cálculo do imc busca a informação no data
 * e emite a resposta para o presentation
 *
 * @param context Contexto da aplicação
 * @param repository Repositório o Imc
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
class CalculateImcUseCase @Inject constructor(
    private val context: Context,
    private val repository: ImcRepository
) {
    suspend operator fun invoke(weight: Float, height: Float): Resource {
        return try {
            val imc = weight/(height.pow(2))
            val imcDTO = repository.getImc(imc)
            if(imcDTO.isSuccessful) {
                val imcDTOData = imcDTO.toData<ImcDTO>()
                val imcResult = Imc(
                    imc = imc,
                    string = imcDTOData!!.string.asString(context),
                    color = imcDTOData.color
                )
                Resource.Success(imcResult)
            } else {
                Resource.Error(imcDTO.toData())
            }
        } catch (e: Exception) {
            Resource.Error(UiText.DynamicString(e.toString()))
        }
    }
}