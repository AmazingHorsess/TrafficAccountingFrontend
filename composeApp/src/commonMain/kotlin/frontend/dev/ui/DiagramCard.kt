package frontend.dev.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DiagramCard(

){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Column {


            }

        }
    }




}


@Preview
@Composable
private fun DiagramCardPreview() {
    MaterialTheme{
        Surface(
            modifier = Modifier
                .size(300.dp)
        ) {
            DiagramCard()

        }
    }
}