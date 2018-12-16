package com.example.github.ui.pullrequests

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.github.R
import com.example.github.data.PullRequest
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_pull_request.*

class PullRequestFragment : DaggerFragment() {

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
    }

    private fun setupViewModel() {
    }

    private fun initObserver() {
    }

    private fun showProgressBar(loading: Boolean) {
        if (loading) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    private fun onSuccess(users: List<PullRequest>) {
    }

    private fun onError(throwable: Throwable?) {
    }

    private fun showPullRequests(users: List<PullRequest>) {
    }
}