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
    val tabBar: Color,
    val tabBarBackground: Color,
    val icon: Color,
    val iconCurrent: Color,
)

private val WeChat = POSColors(
    tabBar = WeColor.green,
    tabBarBackground = WeColor.black,
    icon = whiteColor,
    iconCurrent = WeColor.green,
)

@Composable
fun seaTheme(theme: POSTheme.Theme = POSTheme.Theme.WeChat, content: @Composable () -> Unit) {
    val targetColors = when (theme) {
        POSTheme.Theme.WeChat -> WeChat
        else -> WeChat
    }
    val animationSpec = TweenSpec<Color>(durationMillis = 600)
    val tabBar = animateColorAsState(targetColors.tabBar, animationSpec)
    val tabBarBackground = animateColorAsState(targetColors.tabBarBackground, animationSpec)
    val icon = animateColorAsState(targetColors.icon, animationSpec)
    val iconCurrent = animateColorAsState(targetColors.iconCurrent, animationSpec)
    val colors = POSColors(
        tabBar = tabBar.value,
        tabBarBackground = tabBarBackground.value,
        icon = icon.value,
        iconCurrent = iconCurrent.value,
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