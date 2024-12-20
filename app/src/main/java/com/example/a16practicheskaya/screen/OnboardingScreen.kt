package com.example.a16practicheskaya.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

data class OnboardingPage(val title: String, val imageRes: Int)

@Composable
fun OnboardingScreen(navController: NavController) {
    val pages = listOf(
        OnboardingPage("Welcome to the App", R.drawable.onboarding_1),
        OnboardingPage("Explore Features", R.drawable.onboarding_2),
        OnboardingPage("Get Started", R.drawable.onboarding_3)
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = pages.size,
            state = pagerState
        ) { page ->
            OnboardingPageContent(pages[page])
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (pagerState.currentPage == pages.lastIndex) {
                navController.navigate("login")
            } else {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        }) {
            Text(if (pagerState.currentPage == pages.lastIndex) "Get Started" else "Next")
        }
    }
}

@Composable
fun OnboardingPageContent(page: OnboardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = page.imageRes),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = page.title,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
    }
}