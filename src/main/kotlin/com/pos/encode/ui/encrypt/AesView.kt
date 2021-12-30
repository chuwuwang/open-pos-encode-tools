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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.theme.primaryColor
import com.pos.encode.ui.theme.titleColor
import com.pos.encode.ui.theme.transparentColor
import com.pos.encode.ui.widget.whiteRectangleButton

@Composable
fun aesView(modifier: Modifier = Modifier) {
    val selectTab = remember { mutableStateOf(AesView.AES_128) }
    Column(modifier) {
        Row {
            val sub = Modifier.weight(1.0f)
            Column(sub) {
                itemView(Strings.aes_128, selectTab.value, AesView.AES_128) { selectTab.value = AesView.AES_128 }
            }
            Column(sub) {
                itemView(Strings.aes_256, selectTab.value, AesView.AES_256) { selectTab.value = AesView.AES_256 }
            }
        }
    }
}

@Composable
private fun itemView(text: String, tab: Int, currentTab: Int, onClick: () -> Unit) {
    whiteRectangleButton(modifier = Modifier.height(56.dp).fillMaxWidth(), onClick = onClick) {
        Text(fontSize = 16.sp, color = titleColor, text = text)
    }
    divider(tab, currentTab)
}

@Composable
private fun divider(tab: Int, currentTab: Int) {
    if (tab == currentTab) {
        Divider(Modifier.fillMaxWidth().height(3.dp), color = primaryColor)
    } else {
        Divider(Modifier.fillMaxWidth().height(3.dp), color = transparentColor)
    }
}

class AesView {

    companion object {
        const val AES_128 = 0
        const val AES_256 = 1
    }

}