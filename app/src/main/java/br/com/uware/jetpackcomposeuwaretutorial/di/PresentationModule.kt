package br.com.uware.jetpackcomposeuwaretutorial.di

import android.content.Context
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.loading.LoadingState
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.loading.LoadingStateImpl
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.top_bar.TopBarState
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.top_bar.TopBarStateImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    @Singleton
    fun provideTopBarState(@ApplicationContext context: Context): TopBarState =
        TopBarStateImpl(context)

    @Provides
    @Singleton
    fun provideLoadingState(): LoadingState = LoadingStateImpl()
}