package com.example.github.ui.pullrequests

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.github.R
import com.example.github.data.PullRequest
import kotlinx.android.synthetic.main.item_pull_request.view.*

class PullRequestListAdapter(data: ArrayList<PullRequest>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var pullRequests: ArrayList<PullRequest> = data

    override fun getItemCount(): Int {
        return pullRequests.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PullRequestViewHolder(inflater.inflate(R.layout.item_pull_request, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pullRequest: PullRequest = pullRequests[position]
        val pullRequestViewHolder = holder as PullRequestViewHolder
        pullRequestViewHolder.number.text = pullRequest.number
        pullRequestViewHolder.title.text = pullRequest.title
    }

    inner class PullRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val number = itemView.number as AppCompatTextView
        val title = itemView.title as AppCompatTextView
    }
}