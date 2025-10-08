package com.interview.skeleton.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.interview.skeleton.data.datasource.LocalDataSource
import com.interview.skeleton.data.repository.DataRepositoryImpl
import com.interview.skeleton.domain.repository.DataRepository
import com.interview.skeleton.domain.usecase.GetDataDetailUseCase
import com.interview.skeleton.domain.usecase.GetDataListUseCase

object ServiceLocator {

    private val localDataSource: LocalDataSource by lazy {
        LocalDataSource()
    }

    private val dataRepository: DataRepository by lazy {
        DataRepositoryImpl(localDataSource)
    }
}
