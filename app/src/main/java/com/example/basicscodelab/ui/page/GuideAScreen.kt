package com.example.basicscodelab.ui.page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.R
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme
import com.example.basicscodelab.ui.theme.Typography
import com.example.basicscodelab.ui.widget.PointNormalView

@Composable
fun GuideAScreen(nextClick: () -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.mipmap.ic_guide_first),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(32.dp, 0.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Meow Meow -\nCountdown day",
            color = Color(0xFF784226),
            style = Typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Record your important days",
            color = Color(0xFFBE8071),
            style = Typography.bodySmall
        )
        Spacer(modifier = Modifier.height(46.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_point_indicator),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            PointNormalView()
            Spacer(modifier = Modifier.width(12.dp))
            PointNormalView()
            Spacer(modifier = Modifier.weight(1f))
            ElevatedButton(
                onClick = nextClick,
                colors = ButtonDefaults.elevatedButtonColors(containerColor = Color(0xFFF9B5B5)),
                border = BorderStroke(width = 2.dp, color = Color(0xFF784226)),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Next step",
                        style = Typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.guide_arrow),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )

                }

            }

            Spacer(modifier = Modifier.width(32.dp))
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))

    }

}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun GuideAScreenPreview() {
    BasicsCodelabTheme {
        Surface {
            GuideAScreen()
        }
    }
}