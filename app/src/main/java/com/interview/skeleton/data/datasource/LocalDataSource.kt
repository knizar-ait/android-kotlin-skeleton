package com.interview.skeleton.data.datasource

import com.interview.skeleton.domain.model.Data

class LocalDataSource {

    fun getDataList(): List<Data> {
        return listOf(
            Data(1, "Laptop", "High-performance laptop for professionals", 1299.99, "laptop.jpg"),
            Data(2, "Smartphone", "Latest smartphone with advanced features", 899.99, "phone.jpg"),
            Data(3, "Headphones", "Wireless noise-cancelling headphones", 299.99, "headphones.jpg"),
            Data(4, "Tablet", "Portable tablet for work and entertainment", 599.99, "tablet.jpg"),
            Data(5, "Smartwatch", "Fitness tracker and smartwatch", 399.99, "watch.jpg")
        )
    }

    fun getDataById(id: Int): Data? {
        return getDataList().find { it.id == id }
    }
}
