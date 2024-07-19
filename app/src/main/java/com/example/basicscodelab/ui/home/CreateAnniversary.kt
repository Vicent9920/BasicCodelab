package com.example.basicscodelab.ui.home

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicscodelab.R
import com.example.basicscodelab.ui.theme.Typography

/**
 * Description:
 * Author: Vincent
 * Date: 2024/7/18
 * Email:vincent.wei@backgardon.com
 * Version:
 */

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Anniversary() {
  var name by remember { mutableStateOf("") }
  var isTop by remember { mutableStateOf(false) }
  var isRemind by remember { mutableStateOf(false) }
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(color = Color(0xFFFFF8EE))
      .autoCloseKeyboard(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(16.dp))
    Card(
      modifier = Modifier
        .padding(16.dp, 0.dp)
        .border(width = 2.dp, color = Color(0xFF93664E), shape = RoundedCornerShape(16.dp))
        .background(color = Color(0xFFF4CFB5), shape = RoundedCornerShape(16.dp))
        .padding(end = 8.dp, bottom = 8.dp)
        .clip(RoundedCornerShape(bottomEnd = 8.dp))
        .background(
          color = Color.White,
          shape = RoundedCornerShape(bottomEnd = 16.dp, topStart = 16.dp)
        )
        .padding(14.dp, 22.dp, 6.dp, 12.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

      Column(
        modifier = Modifier
          .fillMaxWidth()
      ) {
        Row(
          modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
          Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.mipmap.ic_name_icon),
            contentDescription = ""
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Name",
            style = Typography.bodyMedium.copy(
              fontWeight = FontWeight.Bold,
              color = Color.Black
            )
          )
          Spacer(modifier = Modifier.weight(1f))

          Box(modifier = Modifier.fillMaxWidth()) {
            var onFocusChanged by remember { mutableStateOf(false) }
            if (name.isEmpty() && onFocusChanged.not()) {
              Text(
                text = "Please enter",
                style = TextStyle(color = Color(0xFF7A7A7A), fontSize = 12.sp),
                modifier = Modifier.align(Alignment.CenterEnd)
              )
            }
            // val focusManager = LocalFocusManager.current
            BasicTextField(
              value = name,
              onValueChange = { text ->
                name = if (text.length > 16) {
                  text.substring(0, 16)
                } else {
                  text
                }
              },
              decorationBox = { innerTextField ->
                innerTextField()
              },
              textStyle = TextStyle(color = Color.Black, fontSize = 12.sp),
              singleLine = true,
              cursorBrush = SolidColor(Color(0xFF784226)),
              keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
              ),
              keyboardActions = KeyboardActions(
                onDone = {
                  // focusManager.clearFocus() // 按下完成键时清除焦点
                }
              ),
              modifier = Modifier
                .onFocusChanged {
                  onFocusChanged = it.isFocused
                  Log.e("","onFocusChanged：${it.hasFocus}")
                }
                .align(Alignment.CenterEnd)
            )
          }

        }


        Row(
          modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
          Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.mipmap.ic_img_icon),
            contentDescription = "icon"
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Icon",
            style = Typography.bodyMedium.copy(
              fontWeight = FontWeight.Bold,
              color = Color.Black
            )
          )
          Spacer(modifier = Modifier.weight(1f))
          Text(
            text = "Edit",
            style = Typography.bodySmall.copy(
              color = Color(0xFF7A7A7A)
            )
          )
          Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "icon"
          )
        }
        Row(
          modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
          Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.mipmap.ic_date_icon),
            contentDescription = "icon"
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Days",
            style = Typography.bodyMedium.copy(
              fontWeight = FontWeight.Bold,
              color = Color.Black
            )
          )
          Spacer(modifier = Modifier.weight(1f))
          Text(
            text = "Please select",
            style = Typography.bodySmall.copy(
              color = Color(0xFF7A7A7A)
            )
          )
          Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "arrow"
          )
        }
        Row(
          modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
          Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.mipmap.ic_topping_icon),
            contentDescription = "top"
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Topping",
            style = Typography.bodyMedium.copy(
              fontWeight = FontWeight.Bold,
              color = Color.Black
            )
          )
          Spacer(modifier = Modifier.weight(1f))

          Image(
            painter = painterResource(id = if (isTop) R.mipmap.ic_switch_able else R.mipmap.ic_switch_disable),
            contentDescription = "arrow",
            modifier = Modifier.pointerInput(Unit) {
              detectTapGestures(onTap = {
                isTop = !isTop
              })
            },
          )
        }
        Row(
          modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
          Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.mipmap.ic_remind_icon),
            contentDescription = "top"
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Remind",
            style = Typography.bodyMedium.copy(
              fontWeight = FontWeight.Bold,
              color = Color.Black
            )
          )
          Spacer(modifier = Modifier.weight(1f))

          Image(
            painter = painterResource(id = if (isRemind) R.mipmap.ic_switch_able else R.mipmap.ic_switch_disable),
            contentDescription = "arrow",
            modifier = Modifier.pointerInput(Unit) {
              detectTapGestures(onTap = {
                isRemind = !isRemind
              })
            },
          )
        }
      }
    }
    Spacer(modifier = Modifier.height(20.dp))
    ElevatedButton(
      onClick = { },
      colors = ButtonDefaults.elevatedButtonColors(containerColor = Color(0xFFF9B5B5)),
      border = BorderStroke(width = 2.dp, color = Color(0xFF784226)),
    ) {
      Text(
        textAlign = TextAlign.Center,
        modifier = Modifier.widthIn(min = 70.dp),
        text = "I Agree",
        style = Typography.titleMedium.copy(
          fontWeight = FontWeight.Bold,
          color = Color.White
        )
      )

    }

  }
}

@Preview
@Composable
fun PreviewAnniversary() {
  Anniversary()
}

@OptIn(ExperimentalComposeUiApi::class) fun Modifier.autoCloseKeyboard():Modifier = composed{
  val keyboardController = LocalSoftwareKeyboardController.current
  pointerInput(this){
    detectTapGestures(onTap = {
      keyboardController?.hide()
    })
  }
}