package com.example.github.ui.pullrequests

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.github.R
import com.example.github.data.PullRequest
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_pull_request.*
import java.io.IOException
import java.net.ConnectException
import java.net.UnknownHostException

class PullRequestFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var pullRequestFragmentViewModel: PullRequestFragmentViewModel

    companion object {
        var TAG = PullRequestFragment::class.java.canonicalName!!

        fun newInstance(): PullRequestFragment {
            return PullRequestFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        initObserver()
        fetchPullRequests()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pull_request, container, false)
    }

    private fun fetchPullRequests() {
        pullRequestFragmentViewModel.fetchPullRequest("ReactiveX", "Rxjava", "open")
    }

    private fun setupViewModel() {
        pullRequestFragmentViewModel = ViewModelProviders.of(
            this,
            viewModelFactory).get(PullRequestFragmentViewModel::class.java
        )
    }

    private fun initObserver() {
        val loadingCallbackObserver =
            Observer<Boolean> { loading ->
                showProgressBar(loading!!)
            }

        val successCallbackObserver =
            Observer<List<PullRequest>> { users ->
                users?.let { onSuccess(it) }
            }

        val errorCallbackObserver =
            Observer<Throwable> { throwable ->
                onError(throwable)
            }

        pullRequestFragmentViewModel.getLoadingValue().observe(this, loadingCallbackObserver)
        pullRequestFragmentViewModel.getUsers().observe(this, successCallbackObserver)
        pullRequestFragmentViewModel.getErrorValue().observe(this, errorCallbackObserver)
    }

    private fun showProgressBar(loading: Boolean) {
        if (loading) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    private fun onSuccess(pullRequests: List<PullRequest>) {
        showPullRequests(pullRequests)
    }

    private fun onError(throwable: Throwable?) {
        var errorMessage = getString(R.string.something_went_wrong)
        when (throwable) {
            is ConnectException -> {
                errorMessage = getString(R.string.no_network)
            }
            is UnknownHostException -> {
                errorMessage = getString(R.string.no_network)
            }
            is HttpException -> {
                errorMessage = throwable.localizedMessage
            }
            is IOException -> {
                errorMessage = getString(R.string.no_network)
            }
        }
    }

    private fun showPullRequests(users: List<PullRequest>) {
    }
}