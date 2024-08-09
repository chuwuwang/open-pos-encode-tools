package com.pos.encode.com.pos.encode.ui.widget

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun horizontal(width: Dp) {
    val modifier = Modifier.width(width)
    Spacer(modifier = modifier)
}

@Composable
fun vertical(height: Dp) {
    val modifier = Modifier.height(height)
    Spacer(modifier = modifier)
}