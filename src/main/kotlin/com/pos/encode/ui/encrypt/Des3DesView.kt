package com.pos.encode.ui.encrypt

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.widget.radioSelectView
import com.pos.encode.ui.widget.tabView
import com.pos.encode.ui.widget.textRectangleBorder

@Composable
fun des3DesView(modifier: Modifier) {
    val selectTab = remember { mutableStateOf(Des3DesView.DES) }
    Column(modifier) {
        Row {
            val sub = Modifier.weight(1.0f)
            Column(sub) {
                tabView(Strings.des3des_des, selectTab.value, Des3DesView.DES) { selectTab.value = Des3DesView.DES }
            }
            Column(sub) {
                tabView(Strings.des3des_3des, selectTab.value, Des3DesView.DES3) { selectTab.value = Des3DesView.DES3 }
            }
        }
        textRectangleBorder(Strings.mode) {
            val padding = Modifier.height(56.dp).padding(0.dp, 10.dp, 0.dp, 0.dp)
            Row(padding) {
                val sub = Modifier.weight(1.0f).fillMaxHeight()
                radioSelectView(sub, Strings.mode_ECB, false) { }
                radioSelectView(sub, Strings.mode_CBC, false) { }
                radioSelectView(sub, Strings.mode_CFB, false) { }

            }
        }
        textRectangleBorder(Strings.padding) {
            val padding = Modifier.height(56.dp).padding(0.dp, 10.dp, 0.dp, 0.dp)
            Row(padding) {
                val sub = Modifier.weight(1.0f).fillMaxHeight()
                radioSelectView(sub, Strings.padding_No, false) { }
                radioSelectView(sub, Strings.padding_PKCS5, false) { }
                radioSelectView(sub, Strings.padding_PKCS7, false) { }
            }
        }
    }
}

class Des3DesView {

    companion object {
        const val DES = 0
        const val DES3 = 1
    }

}
