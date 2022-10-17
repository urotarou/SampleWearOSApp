/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package lab.uro.kitori.samplewearosapp

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import kotlin.math.atan2

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    private var pointerId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return true

        return when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                pointerId = event.getPointerId(event.actionIndex)
                true
            }
            MotionEvent.ACTION_MOVE -> {
                if (pointerId != -1) {
                    val pointerX = event.getX(event.findPointerIndex(pointerId))
                    val pointerY = event.getY(event.findPointerIndex(pointerId))

                    val windowMetrics = windowManager.currentWindowMetrics
                    val screenWidth = windowMetrics.bounds.width()
                    val screenHeight = windowMetrics.bounds.height()
                    val radians = atan2(
                        (screenHeight / 2 - pointerY).toDouble(),
                        (screenWidth / 2 - pointerX).toDouble()
                    )
                    val degrees = Math.toDegrees(radians)

                    viewModel.rotate(degrees - 90)
                }
                true
            }
            MotionEvent.ACTION_UP -> {
                pointerId = -1
                true
            }
            else -> super.onTouchEvent(event)
        }
    }
}
