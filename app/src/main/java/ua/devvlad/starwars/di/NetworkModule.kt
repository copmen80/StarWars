package ua.devvlad.starwars.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ua.devvlad.starwars.search.data.StarWarsService

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideAuthService(retrofit: Retrofit): StarWarsService =
        retrofit.create(StarWarsService::class.java)

}