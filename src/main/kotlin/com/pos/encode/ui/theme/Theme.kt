package com.pos.encode.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
object POSTheme {

    enum class Theme {
        Light, Dark, WeChat
    }

    val colors: POSColors
        @Composable get() = DefaultLocalColors.current

}

private val DefaultLocalColors = staticCompositionLocalOf { WeChat }

@Stable
class POSColors(
    val drawerBar: Color,
    val drawerBarBackground: Color,
    val icon: Color,
    val iconChecked: Color,
    val topBar: Color,
    val topBarBackground: Color,
    val topBarText: Color,
    val topBarTextChecked: Color,
    val topBarDivider: Color,
    val topBarDividerChecked: Color,
    val divider: Color,
)

private val WeChat = POSColors(
    drawerBar = WeColor.green,
    drawerBarBackground = WeColor.black,
    icon = whiteColor,
    iconChecked = WeColor.green,
    topBar = WeColor.green,
    topBarBackground = whiteColor,
    topBarText = WeColor.black,
    topBarTextChecked = WeColor.green,
    topBarDivider = WeColor.green,
    topBarDividerChecked = transparentColor,
    divider = WeColor.gray,
)

@Composable
fun seaTheme(theme: POSTheme.Theme = POSTheme.Theme.WeChat, content: @Composable () -> Unit) {
    val targetColors = when (theme) {
        POSTheme.Theme.WeChat -> WeChat
        else -> WeChat
    }
    val animationSpec = TweenSpec<Color>(durationMillis = 600)
    val drawerBar = animateColorAsState(targetColors.drawerBar, animationSpec)
    val drawerBarBackground = animateColorAsState(targetColors.drawerBarBackground, animationSpec)
    val icon = animateColorAsState(targetColors.icon, animationSpec)
    val iconChecked = animateColorAsState(targetColors.iconChecked, animationSpec)
    val topBar = animateColorAsState(targetColors.topBar, animationSpec)
    val topBarBackground = animateColorAsState(targetColors.topBarBackground, animationSpec)
    val topBarText = animateColorAsState(targetColors.topBarText, animationSpec)
    val topBarTextChecked = animateColorAsState(targetColors.topBarTextChecked, animationSpec)
    val topBarDivider = animateColorAsState(targetColors.topBarDivider, animationSpec)
    val topBarDividerChecked = animateColorAsState(targetColors.topBarDividerChecked, animationSpec)
    val divider = animateColorAsState(targetColors.divider, animationSpec)
    val colors = POSColors(
        drawerBar = drawerBar.value,
        drawerBarBackground = drawerBarBackground.value,
        icon = icon.value,
        iconChecked = iconChecked.value,
        topBar = topBar.value,
        topBarBackground = topBarBackground.value,
        topBarText = topBarText.value,
        topBarTextChecked = topBarTextChecked.value,
        topBarDivider = topBarDivider.value,
        topBarDividerChecked = topBarDividerChecked.value,
        divider = divider.value,
    )
    // Use the font family to define a custom typography
    val craneTypography = Typography(
        defaultFontFamily = POSFontFamily,
        /* ... */
    )
    CompositionLocalProvider(DefaultLocalColors provides colors) {
        MaterialTheme(typography = craneTypography, content = content)
    }
}