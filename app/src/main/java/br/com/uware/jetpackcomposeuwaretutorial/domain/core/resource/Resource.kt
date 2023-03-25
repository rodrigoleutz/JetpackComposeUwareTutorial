package br.com.uware.jetpackcomposeuwaretutorial.domain.core.resource

import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.util.UiText

/**
 * Resource
 *
 * Classe que passa o resultado de uma operação entre data, domain e presentation.
 *
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
sealed class Resource {
    data class Success<T>(val data: T? = null) : Resource()
    data class Error(val data: UiText? = null) : Resource()

    val isSuccessful: Boolean
        get() = this is Success<*>

    inline fun <reified T> toData(): T? = if(this is Success<*>) this.data as T else toError()
    inline fun <reified UiText> toError(): UiText? = if(this is Error) this.data as UiText else null
}
