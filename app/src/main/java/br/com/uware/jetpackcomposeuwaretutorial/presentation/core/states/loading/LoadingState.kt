package br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.loading

import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color

/**
 * LoadinState
 *
 * Interface que controla o loading na MainScreen
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 -
 */
interface LoadingState {

    val loading: State<LoadingType>
    val isLoading: Boolean
    val errorMessage: State<String>
    val color: State<Color>
    val trackColor: State<Color>
    fun start()
    fun end()
    fun error(message: String)
    fun setColor(color: Color)
    fun setTrackColor(color: Color)

    enum class LoadingType {
        Idle,
        Loading,
        Error;
    }
}