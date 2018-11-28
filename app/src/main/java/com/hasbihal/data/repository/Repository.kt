package com.hasbihal.data.repository

import com.hasbihal.data.response.Response

interface Repository {
    fun getData(): Response
}