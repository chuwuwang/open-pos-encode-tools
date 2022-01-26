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
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.boldFontFamily

@Composable
fun topItem(modifier: Modifier, text: String, index: Int, current: Int, onClick: () -> Unit) {
    BoxWithConstraints(modifier.fillMaxHeight().clickable(onClick = onClick), contentAlignment = Alignment.Center) {
        val topBarText = getTopBarText(index, current)
        val topBarDivider = getTopBarDivider(index, current)
        Text(textAlign = TextAlign.Center, color = topBarText, fontSize = DP.contentSize, text = text, fontFamily = boldFontFamily)
        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) { topItemDivider(topBarDivider) }
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

@Composable
private fun getTopBarText(index: Int, current: Int): Color {
    return if (current == index) POSTheme.colors.topBarTextChecked else POSTheme.colors.topBarText
}

@Composable
private fun getTopBarDivider(index: Int, current: Int): Color {
    return if (current == index) POSTheme.colors.topBarDividerChecked else POSTheme.colors.topBarDivider
}