package com.pos.encode.com.pos.encode.ui.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme

object ButtonUtil {

    @Composable
    fun showEncryptButton(modifier: Modifier, onClick: () -> Unit) {
        Button(modifier = modifier.size(DP.buttonWidth, DP.buttonHeight).padding(end = DP.marginEnd), colors = ButtonDefaults.buttonColors(POSTheme.colors.button), onClick = onClick) {
            Icon(painter = painterResource("images/ic_encrypt.png"), modifier = Modifier.size(36.dp), tint = POSTheme.colors.icon, contentDescription = null)
        }
    }

}