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
import com.pos.encode.ui.Sidebar.MENU_AES
import com.pos.encode.ui.Sidebar.MENU_DES
import com.pos.encode.ui.Sidebar.MENU_MD5
import com.pos.encode.ui.Sidebar.MENU_SHA
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.theme.boldFontFamily

object Sidebar {

    const val MENU_AES = 0
    const val MENU_MD5 = 1
    const val MENU_SHA = 2
    const val MENU_DES = 3
}

@Composable
fun showSidebar(modifier: Modifier, index: Int, onClick: (Int) -> Unit) {
    Column(modifier) {
        itemView(Modifier.clickable { onClick(MENU_AES) }, Strings.aes, resourcePath = "images/ic_ago_aes_black.png", if (index == MENU_AES) POSTheme.colors.iconChecked else POSTheme.colors.icon)
        itemView(Modifier.clickable { onClick(MENU_MD5) }, Strings.hash_md5, resourcePath = "images/ic_ago_md5_black.png", if (index == MENU_MD5) POSTheme.colors.iconChecked else POSTheme.colors.icon)
        itemView(Modifier.clickable { onClick(MENU_SHA) }, Strings.hash_sha, resourcePath = "images/ic_ago_sha_black.png", if (index == MENU_SHA) POSTheme.colors.iconChecked else POSTheme.colors.icon)
        itemView(Modifier.clickable { onClick(MENU_DES) }, Strings.des3des, resourcePath = "images/ic_ago_des_black.png", if (index == MENU_DES) POSTheme.colors.iconChecked else POSTheme.colors.icon)
    }
}

@Composable
private fun itemView(modifier: Modifier, text: String, resourcePath: String, tint: Color) {
    val marginStart = 24.dp
    val paddingStart = 12.dp
    Row(modifier.fillMaxWidth().height(56.dp).padding(start = marginStart), verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(resourcePath), contentDescription = null, modifier = Modifier.size(24.dp), tint = tint)
        Text(modifier = Modifier.padding(start = paddingStart), color = tint, textAlign = TextAlign.Start, fontSize = DP.titleSize, text = text, fontFamily = boldFontFamily)
    }
}