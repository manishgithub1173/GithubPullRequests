package com.example.github.ui.pullrequests

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.github.R
import com.example.github.data.PullRequest
import kotlinx.android.synthetic.main.fragment_pull_request_list.*

class PullRequestListFragment : Fragment() {
    private lateinit var pullRequestListAdapter: PullRequestListAdapter
    private lateinit var pullRequests: ArrayList<PullRequest>
    private lateinit var pullRequestFragmentViewModel: PullRequestFragmentViewModel

    companion object {
        var TAG = PullRequestListFragment::class.java.canonicalName!!
        var ARG_PULL_REQUEST = "pull_request"

        fun newInstance(users: ArrayList<PullRequest>): PullRequestListFragment {
            val args = Bundle()
            args.putParcelableArrayList(ARG_PULL_REQUEST, users)
            val userListFragment = PullRequestListFragment()
            userListFragment.arguments = args
            return userListFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pullRequests = arguments?.getParcelableArrayList(ARG_PULL_REQUEST)!!
        setupViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pull_request_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLayoutManager()
        setupAdapter()
    }

    private fun setupViewModel() {
        pullRequestFragmentViewModel = ViewModelProviders.of(activity!!)
            .get(PullRequestFragmentViewModel::class.java)
    }

    private fun setupAdapter() {
        pullRequestListAdapter = context?.let { PullRequestListAdapter(pullRequests) }!!
        list.adapter = pullRequestListAdapter
    }

    private fun setupLayoutManager() {
        val layoutManager = LinearLayoutManager(context)
        list.layoutManager = layoutManager
        list.addItemDecoration(DividerItemDecoration(
            context,
                DividerItemDecoration.VERTICAL))
    }
}