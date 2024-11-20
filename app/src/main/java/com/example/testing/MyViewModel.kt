package com.example.testing


class MyViewModel(private val repository: MyRepository) {

    fun fetchData() {
       repository.getData()
    }

}
