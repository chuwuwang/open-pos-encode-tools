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
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings

@Composable
fun drawerBar(modifier: Modifier, current: Int, onDrawerBarChange: (Int) -> Unit) {
    Column(modifier) {
        drawerItem(
            Modifier.fillMaxWidth().height(56.dp).clickable { onDrawerBarChange(0) },
            Strings.aes,
            "images/ic_ago_aes_black.png",
            if (current == 0) POSTheme.colors.iconCurrent else POSTheme.colors.icon
        )
        drawerItem(
            Modifier.fillMaxWidth().height(56.dp).clickable { onDrawerBarChange(1) },
            Strings.des3des,
            "images/ic_ago_des_black.png",
            if (current == 1) POSTheme.colors.iconCurrent else POSTheme.colors.icon
        )
    }
}

@Composable
fun drawerItem(modifier: Modifier, text: String, resourcePath: String, tint: Color) {
    Row(modifier.padding(16.dp, 0.dp, 0.dp, 0.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(resourcePath), contentDescription = null, modifier = Modifier.size(24.dp), tint = tint)
        Text(modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp), color = tint, textAlign = TextAlign.Start, fontSize = 16.sp, text = text)
    }
}