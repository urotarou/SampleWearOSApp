package lab.uro.kitori.samplewearosapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(
    app: Application
) : AndroidViewModel(app) {
    private val _degrees = MutableLiveData<Float>()
    val degrees: LiveData<Float> = _degrees

    fun rotate(degrees: Double) {
        _degrees.value = degrees.toFloat()
    }
}
