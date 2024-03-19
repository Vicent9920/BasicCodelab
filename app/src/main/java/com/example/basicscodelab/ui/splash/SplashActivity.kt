package com.example.basicscodelab.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicscodelab.ui.dialog.PrivacyPolicyDialog
import com.example.basicscodelab.ui.home.MainActivity
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp(exit = {
                    this.finishAndRemoveTask()
                }, next = { startActivity(Intent(this, MainActivity::class.java)) })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(exit: () -> Unit, next: () -> Unit, viewModel: SplashViewModel = SplashViewModel()) {
    BasicsCodelabTheme {
        var pageIndex by rememberSaveable { mutableIntStateOf(0) }
        Scaffold { paddingValues ->
            when (pageIndex) {
                0 -> SplashScreen(modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), check = { viewModel.checkAgreed() }, next = {
                    viewModel.setAgreeFlag()
                    if (viewModel.checkGuided()) {
                        next()
                    } else {
                        pageIndex++
                    }
                }, exit = exit
                )

                1 -> GuideAScreen(modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), nextClick = { pageIndex++ })

                2 -> GuideBScreen(modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), nextClick = { pageIndex++ })

                3 -> GuideCScreen(modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), nextClick = {
                    viewModel.setGuideFlag()
                    next()
                })
            }

        }
    }

}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun MyAppPreview() {
    BasicsCodelabTheme {
        Surface {
//           SplashScreen()
            // GuideAScreen()
            PrivacyPolicyDialog({
            }, {})
        }
    }
}

