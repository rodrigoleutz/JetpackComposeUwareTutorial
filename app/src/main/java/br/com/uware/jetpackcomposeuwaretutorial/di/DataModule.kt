package br.com.uware.jetpackcomposeuwaretutorial.di

import br.com.uware.jetpackcomposeuwaretutorial.data.local.data_source.imc.ImcLocalDataSource
import br.com.uware.jetpackcomposeuwaretutorial.data.local.data_source.imc.ImcLocalDataSourceImpl
import br.com.uware.jetpackcomposeuwaretutorial.data.repository.imc.ImcRepository
import br.com.uware.jetpackcomposeuwaretutorial.data.repository.imc.ImcRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


/**
 * DataModule
 *
 * Injeção dos recursos de data usando viewModelScope.
 *
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    /**
     * Data Source
     */
    @Provides
    @ViewModelScoped
    fun provideImcLocalDataSource(): ImcLocalDataSource = ImcLocalDataSourceImpl()

    /**
     * Repository
     */
    @Provides
    @ViewModelScoped
    fun provideImcRepository(dataSource: ImcLocalDataSource): ImcRepository =
        ImcRepositoryImpl(dataSource)

}