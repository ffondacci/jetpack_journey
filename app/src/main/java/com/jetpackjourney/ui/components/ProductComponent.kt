package com.jetpackjourney.ui.components

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jetpackjourney.model.Product

@Composable
fun ProductItemComponent(
    modifier: Modifier = Modifier,
    product: Product,
    onClick: () -> Unit,
) {

    Row(modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically) {

        AsyncImage(modifier = Modifier
            .fillMaxWidth(0.2f)
            .aspectRatio(1f)
            .padding(8.dp),
            model = product.image,
            contentDescription = "products image $${product.title}",
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier
            .fillMaxSize()
            .clickable { onClick() }
            .padding(16.dp)) {

            Text(text = product.title,
                style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "price: $${product.price}",
                style = MaterialTheme.typography.bodySmall
            )
        }

    }

}