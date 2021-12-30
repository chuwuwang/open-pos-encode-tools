package com.pos.encode.ui.encrypt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.widget.tabView

@Composable
fun aesView(modifier: Modifier = Modifier) {
    val selectTab = remember { mutableStateOf(AesView.AES_128) }
    Column(modifier) {
        Row {
            val sub = Modifier.weight(1.0f)
            Column(sub) {
                tabView(Strings.aes_128, selectTab.value, AesView.AES_128) { selectTab.value = AesView.AES_128 }
            }
            Column(sub) {
                tabView(Strings.aes_256, selectTab.value, AesView.AES_256) { selectTab.value = AesView.AES_256 }
            }
        }
    }
}

class AesView {

    companion object {
        const val AES_128 = 0
        const val AES_256 = 1
    }

}