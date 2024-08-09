package com.pos.encode.com.pos.encode.ui.iso8583

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pos.encode.com.pos.encode.ui.CommonUiUtil
import com.pos.encode.com.pos.encode.ui.widget.ButtonUtil
import com.pos.encode.com.pos.encode.ui.widget.decryptButton
import com.pos.encode.com.pos.encode.ui.widget.errorButton
import com.pos.encode.com.pos.encode.ui.widget.horizontal
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.mediumFontFamily
import com.pos.encode.ui.widget.TextFieldHelper

object Iso8583BitmapWidget {

    private val BITMAP = arrayOf(
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
        "7", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32",
        "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48",
        "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64",
    )

}

@Composable
fun parserIso8583Bitmap(modifier: Modifier) {

    val inputText = remember { mutableStateOf("") }
    val onInputValueChange: (String) -> Unit = { inputText.value = it }

    Column(modifier) {
        val modifierBitmap = Modifier.fillMaxWidth()
            .padding(start = DP.marginStart, top = DP.marginTop, end = DP.marginEnd)
            .border(DP.dividerHeight, POSTheme.colors.divider, CommonUiUtil.roundedCornerShapeWith8)
        val columns = GridCells.Fixed(16)
        LazyVerticalGrid(columns, modifier = modifierBitmap) {
            items(128) { i ->
                val text = i.toString()
                Column {
                    Row(Modifier.height(56.dp), verticalAlignment = Alignment.CenterVertically,) { bind(text, i) }
                    if (i != 112 && i != 127) {
                        CommonUiUtil.horizontalDivider()
                    }
                }
            }
        }


        TextFieldHelper.inputTextField(Modifier.padding(top = DP.marginTop).height(72.dp), "Bitmap", inputText.value, 32) { inputText.value = it }


        val modifierRow = Modifier.padding(DP.marginTop)
        Row(modifierRow) {
            decryptButton {}
            horizontal(16.dp)
            errorButton("RESET") {}
        }
    }
}

@Composable
fun RowScope.bind(text: String, position: Int) {
    val textStyle = TextStyle(color = POSTheme.colors.textSecondary, fontFamily = mediumFontFamily, fontSize = DP.titleSize, textAlign = TextAlign.Center)
    Text(text, modifier = Modifier.wrapContentHeight(Alignment.CenterVertically).weight(1f), style = textStyle)
    if (position != 15 && position != 127) {
        Divider(modifier = Modifier.fillMaxHeight().width(DP.dividerHeight), color = POSTheme.colors.divider)
    }
}