package com.example.basicscodelab.ui.dialog

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.basicscodelab.R
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme
import com.example.basicscodelab.ui.theme.Typography

/**
 * Description:
 * Author: Vincent
 * Date: 2024/3/18
 * Email:vincent.wei@backgardon.com
 * Version:
 */

@Composable
fun PrivacyPolicyDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
        Dialog(onDismissRequest = onDismiss) {
            Box(modifier = Modifier.size(300.dp, 420.dp)) {
                Image(
                    painter = painterResource(id = R.mipmap.bg_privacy),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, top = 104.dp, end = 20.dp, bottom = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val annotatedText = getPrivacyAgreementContent()
                    Text(
                        text = "User Agreement and Privacy Policy",
                        textAlign = TextAlign.Center,
                        style = Typography.titleLarge.copy(color = Color(0xFF784226))
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                    ) {
                        ClickableText(text = annotatedText,
                            style = Typography.bodySmall.copy(color = Color(0xFF9CA3AF)),
                            maxLines = Int.MAX_VALUE,
                            overflow = TextOverflow.Visible,
                            onClick = { offset ->
                                annotatedText.getStringAnnotations(
                                    tag = "UserAgreement", start = offset,
                                    end = offset
                                ).firstOrNull()?.let {
                                    Log.e("TAG", "UserAgreement click")
                                }

                                annotatedText.getStringAnnotations(
                                    tag = "PrivacyPolicy", start = offset,
                                    end = offset
                                ).firstOrNull()?.let {
                                    Log.e("TAG", "PrivacyPolicy click")
                                }
                            })
                    }

                    // Text(text = "Thank you for using Chiccuts. Clicking agree means that you agree to the 《service agreement》, 《privacy agreement》 and 《copyright policy》. If you do not agree, you will not be able to continue using Chiccuts.",
                    //   textAlign = TextAlign.Center,
                    //   style = Typography.bodySmall.copy(color = Color(0xFF9CA3AF)),
                    //   modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.height(20.dp))
                    ElevatedButton(
                        onClick = {
                            onConfirm()
                            onDismiss()
                        },
                        colors = ButtonDefaults.elevatedButtonColors(
                            containerColor = Color(
                                0xFFF88E78
                            )
                        ),
                        modifier = Modifier
                            .size(166.dp, 40.dp)
                            .background(
                                color = Color(0xFFF88E78),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = Color(0xFF784226),
                                shape = RoundedCornerShape(20.dp)
                            )
                    ) {
                        Text(
                            text = "I Agree",
                            style = Typography.bodyMedium.copy(color = Color.White)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Disagree",
                        modifier = Modifier.clickable {
                            onDismiss()
                        },
                        style = Typography.labelMedium.copy(color = Color(0xFFBE8071))
                    )
                }
            }
    }

}

fun getPrivacyAgreementContent(): AnnotatedString {
    return buildAnnotatedString {
        append("Congratulations on finding the interesting Meow Meow Day app. We highly respect and value your account security and privacy. Before using our product, please carefully read and understand the ")
        pushStringAnnotation(
            tag = "UserAgreement",
            annotation = "User Agreement"
        )
        withStyle(
            style = SpanStyle(
                color = Color(0xFF374151),
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("User Agreement")
        }
        pop()
        append(" and ")
        pushStringAnnotation(
            tag = "PrivacyPolicy",
            annotation = "Privacy Policy"
        )
        withStyle(
            style = SpanStyle(
                color = Color(0xFF374151),
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Privacy Policy")
        }
        pop()
        append(". We will never disclose your personal information to third parties. If you agree to this agreement, please click the 'I Agree' button to start using our products and services. If you have any questions, please contact us via email asedykoji66@gmail.com")

    }
    // ClickableText(text = annotatedText,
    //   // textAlign = TextAlign.Center,
    //   style = Typography.bodySmall.copy(color = Color(0xFF9CA3AF)),
    //   // modifier = Modifier.weight(1f),
    //   onClick = { offset ->
    //   annotatedText.getStringAnnotations(
    //     tag = "UserAgreement", start = offset,
    //     end = offset
    //   ).firstOrNull()?.let {
    //   }
    //
    //   annotatedText.getStringAnnotations(
    //     tag = "PrivacyPolicy", start = offset,
    //     end = offset
    //   ).firstOrNull()?.let {
    //   }
    // })
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DialogPreview() {
    BasicsCodelabTheme {
        Surface {
            PrivacyPolicyDialog({}, {})
        }
    }
}