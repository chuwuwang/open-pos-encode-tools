package com.pos.encode.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.boldFontFamily

@Composable
fun topItem(modifier: Modifier, text: String, tint: Color, divider: Color, onClick: () -> Unit) {
    BoxWithConstraints(modifier.fillMaxHeight().clickable(onClick = onClick), contentAlignment = Alignment.Center) {
        Text(textAlign = TextAlign.Center, color = tint, fontSize = 16.sp, text = text, fontFamily = boldFontFamily)
        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) { topItemDivider(divider) }
    }
}

@Composable
private fun topItemDivider(color: Color) {
    Divider(Modifier.height(3.dp).width(80.dp), color = color)
}

@Composable
fun topBarDivider() {
    Divider(Modifier.fillMaxWidth().height(1.dp), color = POSTheme.colors.divider)
}