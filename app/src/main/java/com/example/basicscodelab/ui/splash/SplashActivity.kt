package com.example.basicscodelab.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Surface(modifier) {
        GuideCScreen()
    }
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun MyAppPreview() {
    BasicsCodelabTheme {
        Surface {
//            SplashScreen()
            GuideAScreen()
        }
    }
}

