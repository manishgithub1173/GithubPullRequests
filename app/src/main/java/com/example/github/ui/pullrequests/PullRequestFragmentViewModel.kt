package com.example.github.ui.pullrequests

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.github.data.PullRequest
import com.example.github.repository.AppRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PullRequestFragmentViewModel @Inject constructor (private var appRepository: AppRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val usersLiveData = MutableLiveData<List<PullRequest>>()
    private val isLoading = MutableLiveData<Boolean>()
    private val errorLiveData = MutableLiveData<Throwable>()

    fun getLoadingValue(): MutableLiveData<Boolean> {
        return isLoading
    }

    fun getUsers(): MutableLiveData<List<PullRequest>> {
        return usersLiveData
    }

    fun getErrorValue(): MutableLiveData<Throwable> {
        return errorLiveData
    }

    fun fetchPullRequest(repo: String, project: String, state: String) {
    }

    private fun onAPIStart() {
        isLoading.value = true
    }

    private fun onAPIFinish() {
        isLoading.value = false
    }

    private fun onSuccess(users: List<PullRequest>) {
        usersLiveData.value = users
    }

    private fun onAPIError(throwable: Throwable) {
        isLoading.value = false
        errorLiveData.value = throwable
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}