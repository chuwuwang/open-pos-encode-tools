import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.pos.encode.ui.Sidebar
import com.pos.encode.ui.encrypt.MD5View
import com.pos.encode.ui.encrypt.ShaView
import com.pos.encode.ui.encrypt.aesView
import com.pos.encode.ui.encrypt.des3DesView
import com.pos.encode.ui.theme.POSTheme
import com.pos.encode.ui.theme.seaTheme

@Composable
@Preview
fun app() {
    val current = remember { mutableStateOf(0) }
    seaTheme {
        Row {
            Sidebar.preview(Modifier.weight(1f).fillMaxHeight().background(POSTheme.colors.drawerBarBackground), current.value) {
                current.value = it
            }
            val right = Modifier.weight(3f).fillMaxHeight().background(POSTheme.colors.contentBackground)
            BoxWithConstraints(modifier = right) {
                when (current.value) {
                    Sidebar.MENU_AES -> aesView(right)
                    Sidebar.MENU_MD5 -> MD5View.preview(right)
                    Sidebar.MENU_SHA -> ShaView.preview(right)
                    Sidebar.MENU_DES -> des3DesView(right)
                }
            }
        }
    }
}

fun main() = application {
    Window(title = "POS Encode Tools", state = WindowState(size = DpSize(1400.dp, 1000.dp), position = WindowPosition.Aligned(Alignment.Center)), onCloseRequest = ::exitApplication) {
        app()
    }
}