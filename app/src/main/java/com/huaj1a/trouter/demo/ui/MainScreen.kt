package com.huaj1a.trouter.demo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.huaj1a.trouter.demo.ui.page.HomePage
import com.huaj1a.trouter.demo.ui.page.IdeaPage
import kotlinx.coroutines.launch

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/25
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState { 2 }
    Scaffold(
        modifier = Modifier
            .background(color = Color.White)
            .safeDrawingPadding(),
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
                title = {
                    Text(
                        text = "TRouter Demo",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White
            ) {
                Row(
                    modifier = Modifier.fillMaxSize()
                ) {
                    listOf(
                        Pair("Home", Icons.Default.Home),
                        Pair("Idea", Icons.Default.Star)
                    ).forEachIndexed { index, item ->
                        Column(
                            modifier = Modifier.weight(1f)
                                .fillMaxHeight()
                                .clickable {
                                    scope.launch { pagerState.animateScrollToPage(index) }
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = item.second,
                                contentDescription = item.first,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = item.first,
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(paddingValues)
        ) {
            when(it) {
                0 -> {
                    HomePage()
                }
                1 -> {
                    IdeaPage()
                }
            }
        }
    }
}