package com.example.github.data

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("repos/{repo}/{project}/pulls")
    fun getPullRequests(
        @Path("repo") repo: String,
        @Path("project") project: String,
        @Query("state") state: String
    ): Observable<Response<List<PullRequest>>>
}