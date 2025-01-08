package com.jetpackjourney.data

import com.jetpackjourney.model.Product

sealed class ProductState {
    data object Loading: ProductState()
    data class Success(val products: List<Product>): ProductState()
    data class Error(val message: String): ProductState()
}