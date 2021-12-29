package com.pos.encode.ui.des

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pos.encode.ui.theme.Strings

@Composable
fun des3DesView(modifier: Modifier) {
    Column(modifier = modifier) {
        Row {
            Text(Strings.des3des_des)
            Text(Strings.des3des_des)
        }
    }
}