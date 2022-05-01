package com.pos.encode.ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.*

object ButtonHelper {

    @Composable
    fun encryptButton(onClick: () -> Unit) {
        Button(
            modifier = Modifier.size(DP.buttonWidth, DP.buttonHeight).padding(0.dp, 0.dp, DP.paddingEnd, 0.dp),
            colors = ButtonDefaults.buttonColors(POSTheme.colors.button),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource("images/ic_encrypt.png"),
                modifier = Modifier.size(36.dp),
                tint = POSTheme.colors.icon,
                contentDescription = null
            )
        }
    }

    @Composable
    fun decryptButton(onClick: () -> Unit) {
        Button(
            modifier = Modifier.size(DP.buttonWidth, DP.buttonHeight).padding(0.dp, 0.dp, DP.paddingEnd, 0.dp),
            colors = ButtonDefaults.buttonColors(POSTheme.colors.button),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource("images/ic_decrypt.png"),
                modifier = Modifier.size(36.dp),
                tint = POSTheme.colors.icon,
                contentDescription = null
            )
        }
    }

    @Composable
    fun radioButton(modifier: Modifier, text: String, selected: Boolean, onClick: () -> Unit) {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            RadioButton(onClick = onClick, selected = selected, colors = RadioButtonDefaults.colors(POSTheme.colors.button))
            Text(text = text, fontSize = DP.contentSize, fontFamily = mediumFontFamily, color = POSTheme.colors.contentText)
        }
    }

    @Composable
    fun radioGroup(modifier: Modifier, text: String, content: @Composable () -> Unit) {
        val borderWidth = DP.borderWidth
        val borderColor = POSTheme.colors.borderChecked
        Box(modifier = modifier.height(72.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Divider(modifier = Modifier.width(24.dp).height(borderWidth), color = borderColor)
                    Text(modifier = Modifier.padding(4.dp, 0.dp), fontSize = DP.contentSize, color = POSTheme.colors.contentText, text = text, fontFamily = boldFontFamily)
                    Divider(modifier = Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
                }
                val params = Modifier.weight(1.0f)
                Spacer(params)
                Divider(modifier = Modifier.fillMaxWidth().height(borderWidth), color = borderColor)
            }
            Row(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp), horizontalArrangement = Arrangement.Start) {
                Divider(modifier = Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
                val params = Modifier.weight(1.0f)
                Spacer(params)
                Divider(modifier = Modifier.width(borderWidth).fillMaxHeight(), color = borderColor)
            }
            content()
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