package br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.top_bar

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.Purple40
import javax.inject.Inject

/**
 * TopBarStateImpl
 *
 * Implementação da interface de TopBarState.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 18 - Top App Bar no Jetpack Compose
 */
class TopBarStateImpl @Inject constructor(
    private val context: Context
): TopBarState {

    private val _isEnabled: MutableState<Boolean> = mutableStateOf(false)
    override val isEnabled: State<Boolean>
        get() = _isEnabled
    private val _title: MutableState<String> = mutableStateOf(context.getString(R.string.app_name))
    override val title: State<String>
        get() = _title
    private val _containerColor: MutableState<Color> = mutableStateOf(Purple40)
    override val containerColor: State<Color>
        get() = _containerColor
    private val _contentColor: MutableState<Color> = mutableStateOf(Color.White)
    override val contentColor: State<Color>
        get() = _contentColor

    override fun enabled() {
        _isEnabled.value = true
    }

    override fun disabled() {
        _isEnabled.value = false
    }

    override fun setContainerColor(color: Color) {
        _containerColor.value = color
    }

    override fun setContentColor(color: Color) {
        _contentColor.value = color
    }

    override fun setTitle(title: String) {
        _title.value = title
    }

    override fun setTitle(resId: Int) {
        _title.value = context.getString(resId)
    }
}