import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.pos.encode.ui.dividerVerticalLightGray
import com.pos.encode.ui.drawerBar
import com.pos.encode.ui.encrypt.aesView
import com.pos.encode.ui.encrypt.des3DesView
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.whiteColor

@Composable
@Preview
fun app() {
    val current = remember { mutableStateOf(0) }
    MaterialTheme {
        POSTheme {
            Row {
                val leftModifier = Modifier.weight(1f).background(POSTheme.colors.tabBarBackground)
                drawerBar(leftModifier, current.value) { current.value = it }

                dividerVerticalLightGray()

                val rightModifier = Modifier.weight(3f).background(whiteColor).fillMaxHeight()
                BoxWithConstraints(modifier = rightModifier) {
                    when (current.value) {
                        0 -> aesView(rightModifier)
                        1 -> des3DesView(rightModifier)
                    }
                }
            }
        }
    }
}

fun main() = application {
    Window(
        title = "POS Encode Tools", state = WindowState(
            size = DpSize(1200.dp, 800.dp), position = WindowPosition.Aligned(Alignment.Center)
        ), onCloseRequest = ::exitApplication
    ) {
        app()
    }
}