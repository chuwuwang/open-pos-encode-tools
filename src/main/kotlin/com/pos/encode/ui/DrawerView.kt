package com.pos.encode.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pos.encode.ui.theme.Strings
import com.pos.encode.ui.theme.WhiteColor

@Composable
fun drawerView(modifier: Modifier) {
    Column(modifier) {
        Button(
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(WhiteColor),
            elevation = ButtonDefaults.elevation(0.dp),
            shape = RoundedCornerShape(0.dp),
            onClick = {}
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp, 0.dp),
                textAlign = TextAlign.Start,
                text = Strings.aes
            )
        }

        // dividerLightGray()

        Button(
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(WhiteColor),
            elevation = ButtonDefaults.elevation(0.dp),
            shape = RoundedCornerShape(0.dp),
            onClick = {}
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp, 0.dp),
                textAlign = TextAlign.Start,
                text = Strings.des3des
            )
        }
    }
}