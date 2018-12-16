package com.example.github.di

import com.example.github.MainApplication
import com.example.github.di.viewmodel.ViewModelModule
import com.example.github.repository.AppRepositoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Suppress("unused")
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ViewModelModule::class,
    AppRepositoryModule::class,
    ActivityBindingModule::class])
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()
}