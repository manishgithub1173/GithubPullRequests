package com.example.github.repository

import com.example.github.data.PullRequest
import io.reactivex.Observable
import retrofit2.Response

interface AppRepository {
    fun getPullRequests(repo: String, project: String, state: String): Observable<Response<List<PullRequest>>>
}