package com.interview.skeleton.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.skeleton.domain.model.Data
import com.interview.skeleton.domain.usecase.GetDataDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getDataDetailUseCase: GetDataDetailUseCase
) : ViewModel() {

    private val _data = MutableLiveData<Data>()
    val data: LiveData<Data> = _data

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadData(dataId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            try {
                val data = getDataDetailUseCase(dataId)
                if (data != null) {
                    _data.value = data
                } else {
                    _error.value = "Data not found"
                }
            } catch (e: Exception) {
                _error.value = "Failed to load data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
