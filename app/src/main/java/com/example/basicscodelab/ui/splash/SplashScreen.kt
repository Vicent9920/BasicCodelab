package com.example.basicscodelab.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.R
import com.example.basicscodelab.ui.theme.Typography

@Composable
fun SplashScreen() {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Icon(painter = painterResource(id = R.mipmap.ic_splash),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.fillMaxWidth(0.76f))
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.mipmap.ic_logo),
                contentDescription = "Logo",
                tint = Color.Unspecified,)//tint = Color.Unspecified,
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Icon(
                    painter = painterResource(id = R.drawable.ic_app_name),
                    contentDescription = "App Name Icon",
                    tint = Color.Unspecified,
                )
                Text(
                    text = "Record your important days",
                    color = Color(0xFFBE8071),
                    style = Typography.bodySmall
                )
            }
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.2f))

    }

}

