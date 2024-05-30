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
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.theme.boldFontFamily

object Sidebar {

    const val MENU_HASH_ALGORITHM = 0
    const val MENU_ENCRYPTION_ALGORITHM = 1

    @Composable
    fun showSidebar(modifier: Modifier, index: Int, onClick: (Int) -> Unit) {
        Column(modifier) {
            itemView(Modifier.clickable { onClick(MENU_HASH_ALGORITHM) }, Strings.hash_algorithm, getColor(index, MENU_HASH_ALGORITHM), resourcePath = "images/ic_ago_sha_black.png")
            itemView(Modifier.clickable { onClick(MENU_ENCRYPTION_ALGORITHM) }, Strings.encryption_algorithm, getColor(index, MENU_ENCRYPTION_ALGORITHM), resourcePath = "images/ic_ago_des_black.png")
        }
    }

    @Composable
    private fun itemView(modifier: Modifier, text: String, tint: Color, resourcePath: String) {
        Row(modifier.fillMaxWidth().height(DP.sidebarHeight).padding(start = DP.marginStart), verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(resourcePath), contentDescription = null, modifier = Modifier.size(DP.sidebarIconSize), tint = tint)
            Text(modifier = Modifier.padding(start = 12.dp), color = tint, textAlign = TextAlign.Start, fontSize = DP.titleSize, text = text, fontFamily = boldFontFamily)
        }
    }

    @Composable
    private fun getColor(index: Int, default: Int): Color {
        return if (index == default) POSTheme.colors.iconChecked else POSTheme.colors.icon
    }

}