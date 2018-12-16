package com.example.github.di

import com.example.github.ui.main.MainActivity
import com.example.github.ui.pullrequests.PullRequestFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [PullRequestFragmentModule::class])
    internal abstract fun contributeMainActivity(): MainActivity
}