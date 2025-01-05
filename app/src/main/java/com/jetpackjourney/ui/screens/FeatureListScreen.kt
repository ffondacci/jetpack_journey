package com.jetpackjourney.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jetpackjourney.navigation.Screen

@Composable
fun FeatureListScreen(navHostController: NavHostController) {
    val features = listOf(
        "Product List" to Screen.ProductsList.route,
        "Demo Blur Video" to Screen.DemoBlurVideo.route
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(features.size) { index ->
            val feature = features[index]
            Row (modifier = Modifier
                .fillMaxWidth()
                .clickable { navHostController.navigate(feature.second) }
                .padding(16.dp)) {
                Text(feature.first)
            }
        }
    }
}