package com.example.basicscodelab.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

/**
 * CardView
 * Description:
 * Author: Vincent
 * Date: 2024/3/15
 * Email:vincent.wei@backgardon.com
 * Version:
 */

@Composable
fun CustomCardView(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 200.dp)
      .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(12.dp))
      .background(color = Color.Blue, shape = RoundedCornerShape(12.dp))
      .padding(end = 8.dp, bottom = 8.dp)
      .clip(RoundedCornerShape(bottomEnd = 8.dp))
      .background(color = Companion.Cyan, shape = RoundedCornerShape(12.dp))
      .padding(24.dp,22.dp,16.dp,14.dp),
    colors = CardDefaults.cardColors(contentColor = Color.Green, containerColor = Color.Yellow)
  ) {
    Box(modifier = Modifier.fillMaxSize()) {

    }
  }
}


@Composable
fun CustomCardView2(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 200.dp)
      .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(12.dp)),
    colors = CardDefaults.cardColors(contentColor = Color.Green, containerColor = Color.Yellow)
  ) {
    Box(modifier = Modifier.fillMaxSize().padding(end = 8.dp, bottom = 8.dp)
      .clip(RoundedCornerShape(bottomEnd = 8.dp))
      .background(Color.Black)) {

    }
  }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun CustomCardPreView() {
  BasicsCodelabTheme {
    Surface {
      CustomCardView {

      }
    }
  }
}
