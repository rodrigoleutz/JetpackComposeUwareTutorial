package br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.loading

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color


/**
 * LoadingStateImpl
 *
 * Implementação do estado de loading
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 19 - Loading no Jetpack Compose
 */
class LoadingStateImpl : LoadingState {
    private val _loading: MutableState<LoadingState.LoadingType> =
        mutableStateOf(LoadingState.LoadingType.Idle)
    override val loading: State<LoadingState.LoadingType>
        get() = _loading
    override val isLoading: Boolean
        get() = loading.value == LoadingState.LoadingType.Loading
    private val _errorMessage: MutableState<String> = mutableStateOf("")
    override val errorMessage: State<String>
        get() = _errorMessage
    private val _color: MutableState<Color> = mutableStateOf(Color.Gray)
    override val color: State<Color>
        get() = _color
    private val _trackColor: MutableState<Color> = mutableStateOf(Color.Black)
    override val trackColor: State<Color>
        get() = _trackColor

    override fun start() {
        _loading.value = LoadingState.LoadingType.Loading
    }

    override fun end() {
        _loading.value = LoadingState.LoadingType.Idle
    }

    override fun error(message: String) {
        _errorMessage.value = message
        _loading.value = LoadingState.LoadingType.Error
    }

    override fun setColor(color: Color) {
        _color.value = color
    }

    override fun setTrackColor(color: Color) {
        _trackColor.value = color
    }
}