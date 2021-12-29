package com.pos.encode.ui.encrypt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pos.encode.ui.theme.LineColor
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.theme.WhiteColor
import com.pos.encode.ui.theme.greenColor
import com.pos.encode.ui.widget.whiteRectangleButton

@Composable
fun aesView(modifier: Modifier = Modifier) {
    val selectTab = remember { mutableStateOf(AesView.AES_128) }
    Column(modifier) {
        Row {
            val subModifier = Modifier.weight(1.0f)
            Column(subModifier) {
                whiteRectangleButton(
                    modifier = Modifier.height(56.dp).fillMaxWidth(),
                    onClick = {
                        selectTab.value = AesView.AES_128
                    }
                ) {
                    Text(
                        fontSize = 16.sp,
                        // fontWeight = textFontWeight(selectTab.value, AesView.AES_128),
                        color = selectColor(selectTab.value, AesView.AES_128),
                        text = Strings.aes_128
                    )
                }
                Divider(
                    Modifier.fillMaxWidth().height(3.dp),
                    color = selectColor(selectTab.value, AesView.AES_128),
                )
            }

            Column(subModifier) {
                whiteRectangleButton(
                    modifier = Modifier.height(56.dp).fillMaxWidth(),
                    onClick = {
                        selectTab.value = AesView.AES_256
                    }
                ) {
                    Text(
                        fontSize = 16.sp,
                        // fontWeight = textFontWeight(selectTab.value, AesView.AES_256),
                        color = selectColor(selectTab.value, AesView.AES_256),
                        text = Strings.aes_256
                    )
                }
                Divider(
                    Modifier.fillMaxWidth().height(3.dp),
                    color = selectColor(selectTab.value, AesView.AES_256),
                )
            }
        }
    }
}

private fun textFontWeight(tab: Int, currentTab: Int): FontWeight {
    return if (tab == currentTab) FontWeight.Bold
    else FontWeight.Normal
}

private fun selectColor(tab: Int, currentTab: Int): Color {
    return if (tab == currentTab) greenColor
    else WhiteColor
}

class AesView {

    companion object {
        const val AES_128 = 0
        const val AES_256 = 1
    }

}