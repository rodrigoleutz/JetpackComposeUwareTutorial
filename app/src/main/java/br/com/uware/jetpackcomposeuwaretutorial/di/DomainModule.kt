package br.com.uware.jetpackcomposeuwaretutorial.di

import android.content.Context
import br.com.uware.jetpackcomposeuwaretutorial.data.local.data_source.imc.ImcLocalDataSource
import br.com.uware.jetpackcomposeuwaretutorial.data.local.data_source.imc.ImcLocalDataSourceImpl
import br.com.uware.jetpackcomposeuwaretutorial.data.repository.imc.ImcRepository
import br.com.uware.jetpackcomposeuwaretutorial.domain.use_cases.imc.CalculateImcUseCase
import br.com.uware.jetpackcomposeuwaretutorial.domain.use_cases.imc.ImcUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped


/**
 * DomainModule
 *
 * Módulo do domain, usando viewModelScope, precisa apenas rodar em um viewModel de cada vez.
 *
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {


    @Provides
    @ViewModelScoped
    fun provideImcUseCases(@ApplicationContext context: Context, imcRepository: ImcRepository) =
        ImcUseCases(
            calculateImc = CalculateImcUseCase(context, imcRepository)
        )


}