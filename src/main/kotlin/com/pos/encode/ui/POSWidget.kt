package com.pos.encode.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.boldFontFamily
import com.pos.encode.ui.theme.mediumFontFamily

@Composable
fun encryptButton(onClick: () -> Unit) {
    Button(modifier = Modifier.size(96.dp, 72.dp).padding(0.dp, 0.dp, DP.padding, 0.dp), colors = ButtonDefaults.buttonColors(POSTheme.colors.button), onClick = onClick) {
        Icon(painter = painterResource("images/ic_encrypt.png"), contentDescription = null, modifier = Modifier.size(36.dp), tint = POSTheme.colors.icon)
    }
}

@Composable
fun decryptButton(onClick: () -> Unit) {
    Button(modifier = Modifier.size(96.dp, 72.dp).padding(0.dp, 0.dp, DP.padding, 0.dp), colors = ButtonDefaults.buttonColors(POSTheme.colors.button), onClick = onClick) {
        Icon(painter = painterResource("images/ic_decrypt.png"), contentDescription = null, modifier = Modifier.size(36.dp), tint = POSTheme.colors.icon)
    }
}

@Composable
fun dataInputTextField(modifier: Modifier, text: String, value: String, maxLength: Int, onValueChange: (String) -> Unit) {
    Column(modifier) {
        Text(
            modifier = Modifier.padding(DP.padding, 0.dp, 0.dp, 0.dp),
            fontSize = DP.contentSize,
            textAlign = TextAlign.Center,
            text = text,
            color = POSTheme.colors.contentText,
            fontFamily = boldFontFamily
        )
        Row(modifier = Modifier.padding(DP.padding, DP.innerPadding, 0.dp, 0.dp), verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                modifier = Modifier.weight(1.0f).fillMaxHeight(),
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(color = POSTheme.colors.contentText, fontSize = DP.contentSize, fontFamily = mediumFontFamily, letterSpacing = DP.letterSpacing),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = POSTheme.colors.contentText,
                    cursorColor = POSTheme.colors.borderChecked,
                    unfocusedBorderColor = POSTheme.colors.border,
                    focusedBorderColor = POSTheme.colors.borderChecked
                )
            )
            Text(
                modifier = Modifier.width(56.dp),
                fontSize = DP.contentSize,
                textAlign = TextAlign.Center,
                text = "[" + value.length.toString() + "]",
                color = if (value.length > maxLength) POSTheme.colors.borderError else POSTheme.colors.borderChecked,
                fontFamily = mediumFontFamily
            )
        }
    }
}

@Composable
fun modeSelectionWidget(modifier: Modifier, text: String, height: Dp = 72.dp, borderWidth: Dp = 1.5.dp, borderColor: Color = POSTheme.colors.borderChecked, content: @Composable () -> Unit) {
    Box(modifier = modifier.height(height).fillMaxWidth(), contentAlignment = Alignment.Center) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Divider(Modifier.width(DP.padding).height(borderWidth), color = borderColor)
                Text(modifier = Modifier.padding(4.dp, 0.dp), fontSize = DP.contentSize, color = POSTheme.colors.contentText, text = text, fontFamily = boldFontFamily)
                Divider(Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
            }
            val maxHeight = Modifier.weight(1.0f)
            Spacer(maxHeight)
            Divider(Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
        }
        Row(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp), horizontalArrangement = Arrangement.Start) {
            Divider(Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
            val maxHeight = Modifier.weight(1.0f)
            Spacer(maxHeight)
            Divider(Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
        }
        content()
    }
}

@Composable
fun singleSelectButton(modifier: Modifier, text: String, selected: Boolean, onClick: () -> Unit) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected, colors = RadioButtonDefaults.colors(POSTheme.colors.button), onClick = onClick)
        Text(fontSize = DP.contentSize, color = POSTheme.colors.contentText, text = text, fontFamily = mediumFontFamily)
    }
}
