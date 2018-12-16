package com.example.github.ui.main

import android.os.Bundle
import com.example.github.R
import com.example.github.common.addFragment
import com.example.github.ui.pullrequests.PullRequestFragment
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            addPullRequestFragment()
        }
    }

    private fun addPullRequestFragment() {
        addFragment(
            supportFragmentManager,
            PullRequestFragment.newInstance(),
            R.id.container, PullRequestFragment.TAG
        )
    }
}