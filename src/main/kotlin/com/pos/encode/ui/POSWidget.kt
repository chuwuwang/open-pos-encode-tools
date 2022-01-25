package com.pos.encode.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.mediumFontFamily

@Composable
fun encryptButton(onClick: () -> Unit) {
    Button(modifier = Modifier.size(88.dp, 72.dp).padding(0.dp, 0.dp, DP.padding, 0.dp), colors = ButtonDefaults.buttonColors(POSTheme.colors.button), onClick = onClick) {
        Icon(painter = painterResource("images/ic_encrypt.png"), contentDescription = null, modifier = Modifier.size(36.dp), tint = POSTheme.colors.icon)
    }
}

@Composable
fun decryptButton(onClick: () -> Unit) {
    Button(modifier = Modifier.size(88.dp, 72.dp).padding(0.dp, 0.dp, DP.padding, 0.dp), colors = ButtonDefaults.buttonColors(POSTheme.colors.button), onClick = onClick) {
        Icon(painter = painterResource("images/ic_decrypt.png"), contentDescription = null, modifier = Modifier.size(36.dp), tint = POSTheme.colors.icon)
    }
}

@Composable
fun dataInputTextField(modifier: Modifier, text: String, value: String, maxLength: Int, onValueChange: (String) -> Unit) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(modifier = Modifier.width(120.dp), fontSize = DP.contentSize, textAlign = TextAlign.Center, text = text, color = POSTheme.colors.contentText, fontFamily = mediumFontFamily)
        OutlinedTextField(
            modifier = Modifier.weight(1.0f).fillMaxHeight(),
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(color = POSTheme.colors.contentText, fontSize = DP.contentSize, fontFamily = mediumFontFamily),
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