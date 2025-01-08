package com.jetpackjourney.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jetpackjourney.ui.screens.FeatureListScreen
import com.jetpackjourney.ui.screens.ProductListScreen

sealed class Screen(val route: String) {
    data object FeatureList: Screen("feature_list")
    data object ProductsList: Screen("products_list")
    data object ProductDetail: Screen("product_details/{productId}") {
        fun createRoute(productId: Int) = "product_details/$productId"
    }
    data object DemoBlurVideo: Screen("demo_blur_video")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.FeatureList.route) {
        composable(Screen.FeatureList.route) {
            FeatureListScreen(navController)
        }
        composable(Screen.ProductsList.route) {
             ProductListScreen(navController)
        }
        composable(Screen.DemoBlurVideo.route) {
            // DemoBlurVideoScreen(navController)
        }
        composable(Screen.ProductDetail.route) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            // ProductDetailsScreen(navController, productId)
        }
    }
}