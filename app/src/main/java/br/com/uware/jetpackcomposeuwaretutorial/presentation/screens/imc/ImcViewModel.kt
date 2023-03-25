package br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.imc

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.uware.jetpackcomposeuwaretutorial.domain.model.Imc
import br.com.uware.jetpackcomposeuwaretutorial.domain.use_cases.imc.ImcUseCases
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.loading.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ImcViewModel
 *
 * ViewModel para calcular o imc
 *
 * @param loading LoadingState para gerenciar o loading e os erros.
 * @param useCases Para acessar as funções do use case.
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
@HiltViewModel
class ImcViewModel @Inject constructor(
    private val loading: LoadingState,
    private val useCases: ImcUseCases
) : ViewModel() {

    private val _imcData: MutableState<Imc?> = mutableStateOf(null)
    val imcData: State<Imc?> = _imcData

    fun calculateImc(height: String, weight: String) {
        loading.start()
        viewModelScope.launch {
            try {
                val resource = useCases.calculateImc.invoke(weight.toFloat(), height.toFloat())
                if(resource.isSuccessful) _imcData.value = resource.toData<Imc>()
                else loading.error(resource.toError<String>().toString())
                loading.end()
            } catch (e: Exception) {
                loading.error(e.toString())
            }
        }
    }
}