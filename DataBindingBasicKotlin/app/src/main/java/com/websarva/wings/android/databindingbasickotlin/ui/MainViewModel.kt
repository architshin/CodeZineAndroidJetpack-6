package com.websarva.wings.android.databindingbasickotlin.ui

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
	var randNum = 0.0

	fun generateNewRandNum() {
		randNum = Math.random()
	}

	fun getRandNumStr(): String {
		return randNum.toString()
	}
}
