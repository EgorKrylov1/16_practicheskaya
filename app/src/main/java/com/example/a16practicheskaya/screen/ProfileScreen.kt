package com.example.a16practicheskaya.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    var images by remember { mutableStateOf(listOf("image1.jpg", "image2.jpg")) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile Screen",
            style = MaterialTheme.typography.h4,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(images) { image ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clickable { navController.navigate("photo") }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = image)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Delete",
                        modifier = Modifier.clickable {
                            images = images.filter { it != image }
                        },
                        color = Color.Red
                    )
                }
            }
        }
    }
}