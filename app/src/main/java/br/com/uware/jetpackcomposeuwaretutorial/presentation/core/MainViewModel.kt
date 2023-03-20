package br.com.uware.jetpackcomposeuwaretutorial.presentation.core

import androidx.lifecycle.ViewModel
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.loading.LoadingState
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.top_bar.TopBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * MainViewModel
 *
 * ViewModel principal que é instânciado na aplicação inteira.
 * Anotação de HiltViewModel para que possa receber injeção de dependência.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 18 - Top App Bar no Jetpack Compose
 * @version 1.0.0 - 2023 03 19 - Loading no Jetpack Compose(Adição do LoadingState)
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    val loading: LoadingState,
    val topBar: TopBarState
) : ViewModel() {

}