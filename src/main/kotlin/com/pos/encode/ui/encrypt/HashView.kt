package com.pos.encode.ui.encrypt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.topBarDivider
import com.pos.encode.ui.topItem

@Composable
fun hashView(modifier: Modifier) {
    val current = remember { mutableStateOf(0) }
    Column(modifier) {
        val modifierNew = Modifier.fillMaxWidth().height(DP.topBarHeight).background(POSTheme.colors.topBarBackground)
        Row(modifierNew) {
            topItem(Modifier.weight(1.0f), Strings.hash_md5, 0, current.value) {
                current.value = 0
            }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_1, 1, current.value) {
                current.value = 1
            }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_128, 2, current.value) {
                current.value = 2
            }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_256, 3, current.value) {
                current.value = 3
            }
            topItem(Modifier.weight(1.0f), Strings.hash_sha_512, 4, current.value) {
                current.value = 4
            }
        }
        topBarDivider()
    }
}