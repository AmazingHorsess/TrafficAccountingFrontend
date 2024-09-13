package frontend.dev.core.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import frontend.dev.Header
import frontend.dev.TrafficHistory

@Composable
fun AppPage(
    firstLineHeaderText: String,
    secondLineHeaderText: String,
    firstContent: @Composable () -> Unit,
    secondContent: @Composable () -> Unit? = {},
    thirdContent: @Composable () -> Unit? = {},
    fourthContent: @Composable () -> Unit? = {},
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Header(
            firstLineHeaderText = firstLineHeaderText,
            secondLineHeaderText = secondLineHeaderText,
        )
        AppSection(
            firstContent = firstContent,
            secondContent = secondContent,
            thirdContent = thirdContent,
            fourthContent = fourthContent
        )
    }
}


@Composable
fun AppSection(
    firstContent: @Composable () -> Unit,
    secondContent: @Composable () -> Unit?,
    thirdContent: @Composable () -> Unit?,
    fourthContent: @Composable () -> Unit?,
){
    Column {
        Row(modifier = Modifier
            .weight(1f)
            .padding(12.dp)
        ) {
            firstContent()
            secondContent()
        }
        Row(modifier = Modifier
            .weight(1f)
            .padding(12.dp)
        ){
            thirdContent()
            fourthContent()
        }
    }


}