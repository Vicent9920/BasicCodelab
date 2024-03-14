package com.example.basicscodelab.ui.widget

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PointNormalView() {
    Card(
        modifier = Modifier.size(16.dp),
        shape = RoundedCornerShape(8.dp), // 使用圆角矩形形状
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7E7CD) )){}
}