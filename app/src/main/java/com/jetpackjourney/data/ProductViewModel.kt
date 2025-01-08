package com.jetpackjourney.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpackjourney.model.Product
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val _state = MutableStateFlow<ProductState>(ProductState.Loading)
    val state: StateFlow<ProductState> get() = _state

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val products = ApiClient.apiService.getProducts() // Network call
                _state.value = ProductState.Success(products)
            } catch (e: CancellationException) {
                // Request was cancelled, handle gracefully
                println("Request cancelled: ${e.message}")
            } catch (e: Exception) {
                _state.value = ProductState.Error("Failed to load products: ${e.message}")
            }
        }
    }
}