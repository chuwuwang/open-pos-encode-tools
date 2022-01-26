package com.pos.encode.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.theme.boldFontFamily

@Composable
fun drawerBar(modifier: Modifier, current: Int, onClick: (Int) -> Unit) {
    Column(modifier) {
        drawerItem(
            Modifier.clickable { onClick(0) },
            Strings.aes,
            resourcePath = "images/ic_ago_aes_black.png",
            if (current == 0) POSTheme.colors.iconChecked else POSTheme.colors.icon
        )
        drawerItem(
            Modifier.clickable { onClick(1) },
            Strings.hash,
            resourcePath = "images/ic_ago_md5_black.png",
            if (current == 1) POSTheme.colors.iconChecked else POSTheme.colors.icon
        )
        drawerItem(
            Modifier.clickable { onClick(2) },
            Strings.des3des,
            resourcePath = "images/ic_ago_des_black.png",
            if (current == 2) POSTheme.colors.iconChecked else POSTheme.colors.icon
        )
    }
}

@Composable
fun drawerItem(modifier: Modifier, text: String, resourcePath: String, tint: Color) {
    Row(modifier.fillMaxWidth().height(DP.drawerBarHeight).padding(DP.padding, 0.dp, 0.dp, 0.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(resourcePath), contentDescription = null, modifier = Modifier.size(DP.iconSize), tint = tint)
        Text(modifier = Modifier.padding(DP.padding, 0.dp, 0.dp, 0.dp), color = tint, textAlign = TextAlign.Start, fontSize = DP.titleSize, text = text, fontFamily = boldFontFamily)
    }
}