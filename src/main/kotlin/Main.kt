import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.pos.encode.ui.des.des3DesView
import com.pos.encode.ui.dividerVerticalLightGray
import com.pos.encode.ui.drawerView
import com.pos.encode.ui.theme.WhiteColor

@Composable
@Preview
fun app() {
    var text by remember { mutableStateOf("Hello, World!") }
    MaterialTheme() {
        Row {
            val leftModifier = Modifier.weight(1f).background(WhiteColor)
            drawerView(leftModifier)

            dividerVerticalLightGray()

            Spacer(Modifier.size(20.dp))

            val rightModifier = Modifier.weight(3f).background(WhiteColor)
            BoxWithConstraints(modifier = rightModifier) {
                des3DesView(rightModifier)
            }

        }
    }
}

fun main() = application {
    Window(
        title = "POS Encode Tools",
        state = WindowState(
            size = DpSize(1200.dp, 800.dp),
            position = WindowPosition.Aligned(Alignment.Center)
        ),
        onCloseRequest = ::exitApplication
    ) {
        app()
    }
}