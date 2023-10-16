package com.websarva.wings.android.databindingbasickotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.websarva.wings.android.databindingbasickotlin.databinding.ActivityMainBinding
import com.websarva.wings.android.databindingbasickotlin.ui.MainViewModel

class MainActivity : AppCompatActivity() {
	private val _mainViewModel by viewModels<MainViewModel>()
	private lateinit var _activityMainBinding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_activityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
		_activityMainBinding.randNum = _mainViewModel.getRandNumStr()

		_activityMainBinding.btnRand.setOnClickListener(ButtonClickListener())

	}

	private inner class ButtonClickListener : View.OnClickListener {
		override fun onClick(view: View?) {
			_mainViewModel.generateNewRandNum()
			_activityMainBinding.randNum = _mainViewModel.getRandNumStr()
		}
	}
}
