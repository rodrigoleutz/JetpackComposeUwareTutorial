package br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.top_bar

import androidx.annotation.StringRes
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color

/**
 * TopBarState
 *
 * Interface que será chamada no injeção de dependência.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 18 - Top App Bar no Jetpack Compose
 */
interface TopBarState {

    val isEnabled: State<Boolean>
    val title: State<String>
    val containerColor: State<Color>
    val contentColor: State<Color>

    fun enabled()
    fun disabled()

    fun setContainerColor(color: Color)
    fun setContentColor(color: Color)

    fun setTitle(title: String)
    fun setTitle(@StringRes resId: Int)

}