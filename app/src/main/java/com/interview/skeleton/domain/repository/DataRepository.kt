package com.interview.skeleton.domain.repository

import com.interview.skeleton.domain.model.Data

interface DataRepository {
    suspend fun getDataList(): List<Data>
    suspend fun getDataById(id: Int): Data?
}
