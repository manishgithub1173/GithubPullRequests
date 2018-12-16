package com.example.github.ui.pullrequests

import android.arch.lifecycle.ViewModel
import com.example.github.di.FragmentScoped
import com.example.github.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
internal abstract class PullRequestFragmentModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributePullRequestFragment(): PullRequestFragment

    @Binds
    @IntoMap
    @ViewModelKey(PullRequestFragmentViewModel::class)
    abstract fun bindPullRequestFragmentViewModel(
        pullRequestFragmentViewModel: PullRequestFragmentViewModel
    ): ViewModel
}