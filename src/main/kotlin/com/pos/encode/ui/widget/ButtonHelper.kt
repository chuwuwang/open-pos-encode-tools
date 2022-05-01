package com.pos.encode.ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.DP
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.whiteColor

object ButtonHelper {

    @Composable
    fun encryptButton(onClick: () -> Unit) {
        Button(
            modifier = Modifier.size(DP.buttonWidth, DP.buttonHeight).padding(0.dp, 0.dp, DP.endPadding, 0.dp),
            colors = ButtonDefaults.buttonColors(POSTheme.colors.button),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource("images/ic_encrypt.png"),
                contentDescription = null,
                modifier = Modifier.size(36.dp),
                tint = POSTheme.colors.icon
            )
        }
    }

    @Composable
    fun decryptButton(onClick: () -> Unit) {
        Button(
            modifier = Modifier.size(DP.buttonWidth, DP.buttonHeight).padding(0.dp, 0.dp, DP.endPadding, 0.dp),
            colors = ButtonDefaults.buttonColors(POSTheme.colors.button),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource("images/ic_decrypt.png"),
                contentDescription = null,
                modifier = Modifier.size(36.dp),
                tint = POSTheme.colors.icon
            )
        }
    }

}

@Composable
fun posButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: Dp = 0.dp,
    cornerRadius: Dp = 0.dp,
    backgroundColor: Color = whiteColor,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    border: BorderStroke ? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = ButtonDefaults.elevation(elevation),
        shape = RoundedCornerShape(cornerRadius),
        border = border,
        colors = ButtonDefaults.buttonColors(backgroundColor),
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun whiteRectangleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    border: BorderStroke ? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = ButtonDefaults.elevation(0.dp),
        shape = RoundedCornerShape(0.dp),
        border = border,
        colors = ButtonDefaults.buttonColors(whiteColor),
        contentPadding = contentPadding,
        content = content
    )
}