package com.example.basicscodelab.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicscodelab.R
import com.example.basicscodelab.data.DaysBean
import com.example.basicscodelab.ui.theme.Typography
import com.example.basicscodelab.utils.DateUtils

/**
 * HomeScreen
 * Description:
 * Author: Vincent
 * Date: 2024/7/17
 * Email:vincent.wei@backgardon.com
 * Version:
 */
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
  val list by homeViewModel.queryAllDaysBean().collectAsState(initial = emptyList())
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(color = Color(0xFFFFF8EE)),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    if (list.isEmpty()) {
      Spacer(modifier = Modifier.height(120.dp))
      Icon(
        modifier = Modifier.size(160.dp, 80.dp),
        painter = painterResource(id = R.mipmap.ic_home_empty_icon),
        tint = Color.Unspecified,
        contentDescription = null
      )
      Spacer(modifier = Modifier.weight(1f))
    } else {
      LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        items(list) { item ->
          if (item.tack){
            Box (modifier = Modifier
              .height(92.dp)
              .fillMaxWidth()){
              DayItemView(item = item, modifier = Modifier.align(Alignment.BottomCenter))
              Image(painter = painterResource(R.mipmap.ic_tack), contentDescription = "tack", modifier = Modifier.align(Alignment.TopEnd))
            }
          }else{
            DayItemView(item = item)
          }


        }

      }
    }

  }
}

@Composable
fun DayItemView(item:DaysBean,modifier:Modifier = Modifier){
  Card(
    modifier = modifier
      .height(80.dp)
      .fillMaxWidth()
      .border(width = 2.dp, color = Color(0xFF93664e), shape = RoundedCornerShape(16.dp))
      .background(color = Color(0xFFf6d9c4), shape = RoundedCornerShape(16.dp))
      .padding(end = 8.dp, bottom = 8.dp)
      .clip(RoundedCornerShape(bottomEnd = 8.dp))
      .background(
        color = Color.White,
        shape = RoundedCornerShape(bottomEnd = 16.dp, topStart = 16.dp)
      )
      .padding(8.dp, 16.dp, 8.dp, 8.dp),
    colors = CardDefaults.cardColors(
      contentColor = Color.Green,
      containerColor = Color.White
    )
  ) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
      Image(painter = painterResource(item.icon), contentDescription = item.name)
      Spacer(modifier = Modifier.width(6.dp))
      Column {
        Text(
          text = item.name,
          style = Typography.bodySmall.copy(
            color = Color(0xFF121212),
            fontWeight = FontWeight.Bold
          )
        )
        Text(
          text = DateUtils.parseDate(item.date),
          style = Typography.bodySmall.copy(color = Color(0xFFA6A6A6))
        )
      }
      Spacer(modifier = Modifier.weight(1f))
      Column(horizontalAlignment = Alignment.End) {
        val day = DateUtils.getTimeSpanByNow(item.date)
        Text(
          text = buildAnnotatedString {
            withStyle(
              style = SpanStyle(
                color = Color(0xFF93664E),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
              )
            ) {
              append(day.toString())
            }
            append(" Days")

          }, style =
          Typography.bodySmall.copy(
            color = Color(0xFF454545),
            fontSize = 12.sp
          )
        )

        Text(
          text = if (day > 0) {
            "remaining"
          } else "Has passed",
          style = Typography.bodySmall.copy(color = Color(0xFFA6A6A6))
        )
      }
    }
  }
}
