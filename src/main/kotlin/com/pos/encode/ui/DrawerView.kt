package com.pos.encode.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.theme.primaryColor
import com.pos.encode.ui.theme.titleColor
import com.pos.encode.ui.widget.whiteRectangleButton

@Composable
fun drawerView(modifier: Modifier, onClick: (state: MenuState) -> Unit) {
    val state = remember { mutableStateOf<MenuState>(MenuState.Aes) }
    Column(modifier) {
        val sub = Modifier.fillMaxWidth().height(56.dp)
        whiteRectangleButton(
            modifier = sub,
            onClick = {
                state.value = MenuState.Aes
                onClick(MenuState.Aes)
            }
        ) { itemView(Strings.aes, MenuState.Aes, state.value) }

        whiteRectangleButton(
            modifier = sub,
            onClick = {
                state.value = MenuState.Des3Des
                onClick(MenuState.Des3Des)
            }
        ) { itemView(Strings.des3des, MenuState.Des3Des, state.value) }
    }
}

@Composable
private fun itemView(text: String, state: MenuState, currentState: MenuState) {
    val modifier = Modifier.fillMaxWidth()
    Row(modifier) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = getImage(state, currentState),
            contentDescription = "icon",
        )
        Text(
            modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp),
            color = getTextColor(state, currentState),
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            text = text
        )
    }
}

private fun getTextColor(state: MenuState, currentState: MenuState): Color {
    return if (state == currentState) primaryColor else titleColor
}

@Composable
private fun getImage(state: MenuState, currentState: MenuState): Painter {
    return when (state) {
        MenuState.Aes -> {
            if (state == currentState) {
                painterResource("images/ic_ago_aes_blue.png")
            } else {
                painterResource("images/ic_ago_aes_black.png")
            }
        }
        MenuState.Des3Des -> {
            if (state == currentState) {
                painterResource("images/ic_ago_des_blue.png")
            } else {
                painterResource("images/ic_ago_des_black.png")
            }
        }
    }
}

sealed class MenuState {
    object Aes : MenuState()
    object Des3Des : MenuState()
}