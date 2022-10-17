package lab.uro.kitori.samplewearosapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.TimeText
import lab.uro.kitori.samplewearosapp.theme.SampleWearOSAppTheme

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    Scaffold(timeText = {
        TimeText()
    }) {
        SampleWearOSAppTheme {
            val degrees by viewModel.degrees.observeAsState()
            IkaRoll(degrees ?: 0f)

//            ScalingLazyColumn(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center
//            ) {
//                items(30) {
//                    val text = stringResource(R.string.hello_world, greetingName) + it
//                    Text(
//                        modifier = Modifier.fillMaxWidth(),
//                        text = text,
//                        textAlign = TextAlign.Center,
//                        color = MaterialTheme.colors.primary
//                    )
//                }
//            }
        }
    }
}

@Composable
fun IkaRoll(degrees: Float) {
    Image(
        painter = painterResource(id = R.drawable.ika), // ika の drawable を追加すること
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .rotate(degrees)
    )
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
