package com.example.basicscodelab.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

@Composable
fun MyApp(modifier: Modifier = Modifier,viewModel: SplashViewModel = SplashViewModel()) {
    Surface(modifier) {
        SplashScreen{

        }
        // 获取与当前Composable关联的CoroutineScope
        val coroutineScope = rememberCoroutineScope()

        // 开启协程
        LaunchedEffect(Unit) {
            coroutineScope.launch {
                delay(2000L)
                if(viewModel.checkGuided()){
                    // 打开主页
                }else{
                    // 开启隐私弹窗
                }
            }
        }

    }
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun MyAppPreview() {
    BasicsCodelabTheme {
        Surface {
           SplashScreen(){}
            // GuideAScreen()
        }
    }
}

