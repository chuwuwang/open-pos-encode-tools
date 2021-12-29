package com.pos.encode.ui.encrypt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pos.encode.ui.theme.Strings

@Composable
fun aesView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row {
            Text(Strings.aes_128)
            Text(Strings.aes_256)
        }
    }
}