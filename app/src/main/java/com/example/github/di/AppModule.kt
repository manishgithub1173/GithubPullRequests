package com.example.github.di
import android.content.Context
import com.example.github.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Suppress("unused")
@Module(includes = [
        NetworkModule::class])
class AppModule {

    @Provides
    @Singleton
    fun providesContext(application: MainApplication): Context {
        return application.applicationContext
    }
}