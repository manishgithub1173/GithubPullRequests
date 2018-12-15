package com.example.github.repository

import com.example.github.data.RetrofitService
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : AppRepository