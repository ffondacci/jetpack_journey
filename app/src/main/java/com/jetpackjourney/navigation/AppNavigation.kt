package com.jetpackjourney.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jetpackjourney.ui.screens.FeatureListScreen

sealed class Screen(val route: String) {
    object FeatureList: Screen("feature_list")
    object ProductsList: Screen("products_list")
    object ProductDetail: Screen("product_details/{productId}") {
        fun createRoute(productId: String) = "product_details/$productId"
    }
    object DemoBlurVideo: Screen("demo_blur_video")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.FeatureList.route) {
        composable(Screen.FeatureList.route) {
            FeatureListScreen(navController)
        }
        composable(Screen.ProductsList.route) {
            // ProductListScreen(navController)
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