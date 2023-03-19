package br.com.uware.jetpackcomposeuwaretutorial.presentation.core.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

/**
 * UiText
 *
 * @author Philipp Lackner
 * @version https://www.youtube.com/watch?v=mB1Lej0aDus&t=371s
 */
sealed class UiText {
    data class DynamicString(val value: String): UiText()
    class StringResource(
        @StringRes val resId: Int,
        vararg val args: Any
    ): UiText()

    @Composable
    fun asString(): String =
        when(this) {
            is DynamicString -> value
            is StringResource -> stringResource(id = resId, *args)
        }

    fun asString(context: Context): String =
        when(this) {
            is DynamicString -> value
            is StringResource -> context.getString(resId, *args)
        }
}
