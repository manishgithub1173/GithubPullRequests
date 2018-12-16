package com.example.github.ui.pullrequests

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.github.data.PullRequest
import com.example.github.repository.AppRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
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
        compositeDisposable.add(appRepository.getPullRequests(repo, project, state)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onAPIStart() }
            .doOnTerminate { onAPIFinish() }
            .subscribeWith(object : DisposableObserver<Response<List<PullRequest>>>() {
                override fun onNext(result: Response<List<PullRequest>>) {
                    result.body()?.let {
                        onSuccess(it)
                    }
                }

                override fun onComplete() {
                }

                override fun onError(e: Throwable) {
                    onAPIError(e)
                }
            })
        )
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