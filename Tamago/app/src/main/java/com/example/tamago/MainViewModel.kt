package com.example.tamago

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    var stamina: MutableLiveData<Int> = MutableLiveData(100)

    public fun minusStamina(view: View): Unit {
        if (stamina.value!! > 0) {
            stamina.value = stamina.value!! - 1
        }
    }

    fun resetStamina(): Unit {
        stamina.value = 100
    }
}