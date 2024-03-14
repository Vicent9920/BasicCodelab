package com.example.basicscodelab.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicscodelab.R
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainPage() }
    }
}

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    Screen(modifier)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier,
        bottomBar = {MainBottomNavigation()},
        content = { HomeScreen()})
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFF8EE))) {

    }
}

@Composable
private fun MainBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.mipmap.ic_home_selected),
                    tint = Color.Unspecified,
                    contentDescription = null
                )
            },
            label = {
                Text("Home")
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.mipmap.ic_mood_normal),
                    tint = Color.Unspecified,
                    contentDescription = null
                )
            },
            label = {
                Text("Mood")
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.mipmap.ic_setting_normal),
                    tint = Color.Unspecified,
                    contentDescription = null
                )
            },
            label = {
                Text("Setting")
            },
            selected = false,
            onClick = {}
        )
    }
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun MainPagePreview() {
    BasicsCodelabTheme {
        Surface {
            Screen()
        }
    }
}