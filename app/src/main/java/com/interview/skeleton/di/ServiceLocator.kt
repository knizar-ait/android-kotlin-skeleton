package com.interview.skeleton.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.interview.skeleton.data.datasource.LocalDataSource
import com.interview.skeleton.data.repository.DataRepositoryImpl
import com.interview.skeleton.domain.repository.DataRepository
import com.interview.skeleton.domain.usecase.GetDataDetailUseCase
import com.interview.skeleton.domain.usecase.GetDataListUseCase
import com.interview.skeleton.presentation.productdetail.ProductDetailViewModel
import com.interview.skeleton.presentation.productlist.ProductListViewModel

object ServiceLocator {

    private val localDataSource: LocalDataSource by lazy {
        LocalDataSource()
    }

    private val dataRepository: DataRepository by lazy {
        DataRepositoryImpl(localDataSource)
    }

    private val getDataListUseCase: GetDataListUseCase by lazy {
        GetDataListUseCase(dataRepository)
    }

    private val getDataDetailUseCase: GetDataDetailUseCase by lazy {
        GetDataDetailUseCase(dataRepository)
    }

    fun provideDataListViewModelFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DataListViewModel(getDataListUseCase) as T
            }
        }
    }

    fun provideDataDetailViewModelFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DataDetailViewModel(getDataDetailUseCase) as T
            }
        }
    }
}
