package com.pos.encode.com.pos.encode.ui.home

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
import com.pos.encode.com.pos.encode.ui.helper.ThemeUtil
import com.pos.encode.com.pos.encode.ui.home.Sidebar.MENU_ENCRYPTION_ALGORITHM
import com.pos.encode.com.pos.encode.ui.home.Sidebar.MENU_HASH_ALGORITHM
import com.pos.encode.com.pos.encode.ui.home.Sidebar.MENU_ISO8583_BITMAP
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.theme.boldFontFamily

object Sidebar {

    const val MENU_HASH_ALGORITHM = 0
    const val MENU_ENCRYPTION_ALGORITHM = 1
    const val MENU_ISO8583_BITMAP = 2

}

@Composable
fun showSidebar(modifier: Modifier, index: Int, onClick: (Int) -> Unit) {
    Column(modifier) {
        val modifierHashAlgo = Modifier.clickable { onClick(MENU_HASH_ALGORITHM) }
        itemView(modifierHashAlgo, Strings.hash_algorithm, ThemeUtil.getIconColor(index, MENU_HASH_ALGORITHM), resourcePath = "images/ic_ago_sha_black.png")

        val modifierEncryptionAlgo = Modifier.clickable { onClick(MENU_ENCRYPTION_ALGORITHM) }
        itemView(modifierEncryptionAlgo, Strings.encryption_algorithm, ThemeUtil.getIconColor(index, MENU_ENCRYPTION_ALGORITHM), resourcePath = "images/ic_ago_des_black.png")

        val modifierISO8583Bitmap = Modifier.clickable { onClick(MENU_ISO8583_BITMAP) }
        itemView(modifierISO8583Bitmap, Strings.iso8583_bitmap, ThemeUtil.getIconColor(index, MENU_ISO8583_BITMAP), resourcePath = "images/ic_menu_bitmap_black.png")
    }
}

@Composable
private fun itemView(modifier: Modifier, text: String, tint: Color, resourcePath: String) {
    Row(modifier.fillMaxWidth().height(56.dp).padding(start = 24.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(resourcePath), contentDescription = null, modifier = Modifier.size(24.dp), tint = tint)
        Text(modifier = Modifier.padding(start = 12.dp), color = tint, textAlign = TextAlign.Start, fontSize = 16.sp, fontFamily = boldFontFamily, text = text)
    }
}