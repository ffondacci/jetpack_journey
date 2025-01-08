package com.jetpackjourney.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jetpackjourney.data.ProductState
import com.jetpackjourney.data.ProductViewModel
import com.jetpackjourney.navigation.Screen
import com.jetpackjourney.ui.components.ProductItemComponent

@Composable
fun ProductListScreen(navController: NavController, viewModel: ProductViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchProducts()
    }

    when(state) {
        ProductState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is ProductState.Success -> {
            val products = (state as ProductState.Success).products
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(products.size) { index: Int ->
                    val product = products[index]

                    ProductItemComponent(product = product) {
                        navController.navigate(Screen.ProductDetail.createRoute(product.id))
                    }

                    HorizontalDivider()
                }
            }
        }
        is ProductState.Error -> {
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Text(text = (state as ProductState.Error).message)
            }
        }
    }
}