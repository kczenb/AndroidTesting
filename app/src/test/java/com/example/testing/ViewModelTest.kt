package com.example.testing

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test



class ViewModelTest {
    private val repository = mockk<MyRepository>()
    private val viewModel = MyViewModel(repository)

    @Test
    fun fetchData_callsRepository() {
        every { repository.getData() } returns listOf("Item1", "Item2")

        viewModel.fetchData()

        verify { repository.getData() }
    }
}

