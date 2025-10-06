package com.interview.skeleton.domain.usecase

import com.interview.skeleton.domain.model.Data
import com.interview.skeleton.domain.repository.DataRepository

class GetDataListUseCase(private val repository: DataRepository) {
    suspend operator fun invoke(): List<Data> {
        return repository.getData()
    }
}
