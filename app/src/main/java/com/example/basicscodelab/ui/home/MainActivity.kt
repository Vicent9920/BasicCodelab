package com.example.basicscodelab.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.R
import com.example.basicscodelab.contant.StaticData
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme
import com.example.basicscodelab.ui.theme.Typography

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
    bottomBar = { MainBottomNavigation() },
    content = { paddingValues ->
      MoodScreen(modifier = Modifier.padding(paddingValues))
    })
}

@Composable
fun HomeScreen(modifier: Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(color = Color(0xFFFFF8EE)),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(24.dp))
    Text(
      text = "Meow Day",
      style = Typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold)
    )
    Spacer(modifier = Modifier.height(120.dp))
    Icon(
      modifier = Modifier.size(160.dp, 80.dp),
      painter = painterResource(id = R.mipmap.ic_home_empty_icon),
      tint = Color.Unspecified,
      contentDescription = null
    )
    Spacer(modifier = Modifier.weight(1f))
    ElevatedCard {
      Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Icon(
          modifier = Modifier.size(52.dp, 52.dp),
          painter = painterResource(id = R.drawable.ic_home_add),
          tint = Color.Unspecified,
          contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
          text = "Click to add anniversary",
          style = Typography.bodyMedium.copy(color = Color(0xFFBE8071))
        )
      }
    }
    Spacer(modifier = Modifier.height(24.dp))
  }
}

@Composable
fun MoodScreen(modifier: Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(color = Color(0xFFFFF8EE)),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(24.dp))
    Text(
      text = "Today's mood",
      style = Typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold)
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
      text = "How are you feeling at the moment?",
      style = Typography.bodySmall.copy(color = Color(0xFFBE8071))
    )
    Spacer(modifier = Modifier.height(10.dp))
    Card(
      modifier = Modifier
        .padding(16.dp, 0.dp)
        .border(width = 2.dp, color = Color(0xFF93664E), shape = RoundedCornerShape(12.dp))
        .background(color = Color(0xFFF4CFB5), shape = RoundedCornerShape(12.dp))
        .padding(end = 8.dp, bottom = 8.dp)
        .clip(RoundedCornerShape(bottomEnd = 8.dp))
        .background(color = Color.White, shape = RoundedCornerShape(12.dp))
        .padding(24.dp,22.dp,16.dp,14.dp),
      colors = CardDefaults.cardColors(containerColor =Color.White)
    ) {

      LazyVerticalGrid(
        modifier = Modifier.background(Color.White),

        columns = GridCells.Fixed(4),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        items(StaticData.moods) { item ->
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
              modifier = Modifier.size(52.dp, 52.dp),
              painter = painterResource(id = item.icon),
              tint = Color.Unspecified,
              contentDescription = null
            )
            Text(text = item.name, style = Typography.bodySmall.copy(color = Color(0xFF292929)))
          }
        }
      }
    }
    Spacer(modifier = Modifier.height(24.dp))
    ElevatedButton(
      onClick = { },
      colors = ButtonDefaults.elevatedButtonColors(containerColor = Color(0xFFF9B5B5)),
      border = BorderStroke(width = 2.dp, color = Color(0xFF784226)),
    ) {
      Text(
        textAlign = TextAlign.Center,
        modifier = Modifier.widthIn(min = 70.dp),
        text = "Confirm",
        style = Typography.titleMedium.copy(
          fontWeight = FontWeight.Bold,
          color = Color.White
        )
      )

    }
    Spacer(modifier = Modifier.height(24.dp))
    Row(
      modifier = Modifier.padding(30.dp, 0.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Divider(modifier = Modifier.weight(1f), color = Color(0xFFF4CFB5))
      Text(text = "Mood recording",
        modifier =  Modifier.padding(12.dp,0.dp),
        style = Typography.bodyLarge.copy(color = Color(0xFFF4CFB5)))
      Divider(modifier = Modifier.weight(1f), color = Color(0xFFF4CFB5))
    }
    Spacer(modifier = Modifier.weight(1f))
    Icon(
      modifier = Modifier.size(154.dp, 154.dp),
      painter = painterResource(id = R.mipmap.ic_mood_icon),
      tint = Color.Unspecified,
      contentDescription = null
    )
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