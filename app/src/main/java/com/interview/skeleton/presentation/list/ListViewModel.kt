package com.interview.skeleton.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.skeleton.domain.model.Data
import com.interview.skeleton.domain.usecase.GetDataListUseCase
import kotlinx.coroutines.launch

class ListViewModel(
    private val getDataListUseCase: GetDataListUseCase
) : ViewModel() {

    private val _dataList = MutableLiveData<List<Data>>()
    val dataList: LiveData<List<Data>> = _dataList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadDataList() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val dataList = getDataListUseCase()
                _dataList.value = dataList
            } catch (e: Exception) {
                _error.postValue("Failed to load data list: ${e.message}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}
