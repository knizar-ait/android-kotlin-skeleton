package com.interview.skeleton.data.repository

import com.interview.skeleton.data.datasource.LocalDataSource
import com.interview.skeleton.domain.model.Data
import com.interview.skeleton.domain.repository.DataRepository
import kotlinx.coroutines.delay

class DataRepositoryImpl(
    private val localDataSource: LocalDataSource
) : DataRepository {

    override suspend fun getDataList(): List<Data> {
        return localDataSource.getDataList()
    }

    override suspend fun getDataById(id: Int): Data? {
        return localDataSource.getDataById(id)
    }
}
