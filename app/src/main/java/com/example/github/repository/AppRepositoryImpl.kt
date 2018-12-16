package com.example.github.repository

import com.example.github.data.PullRequest
import com.example.github.data.RetrofitService
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : AppRepository {
    override fun getPullRequests(repo: String, project: String, state: String): Observable<Response<List<PullRequest>>> {
        return retrofitService.getPullRequests(repo, project, state)
    }
}