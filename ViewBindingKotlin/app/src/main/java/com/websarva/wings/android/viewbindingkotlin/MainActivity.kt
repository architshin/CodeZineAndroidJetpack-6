package com.websarva.wings.android.viewbindingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.websarva.wings.android.viewbindingkotlin.databinding.ActivityMainBinding
import com.websarva.wings.android.viewbindingkotlin.ui.MainViewModel

class MainActivity : AppCompatActivity() {
	private val _mainViewModel by viewModels<MainViewModel>()
	private lateinit var _activityMainBinding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(_activityMainBinding.root)

		_activityMainBinding.tvRand.text = _mainViewModel.getRandNumStr()
		_activityMainBinding.btnRand.setOnClickListener(ButtonClickListener())

//		val tvRand = findViewById<TextView>(R.id.tvRand)
//		tvRand.text = _mainViewModel.getRandNumStr()
//		val btnRand = findViewById<Button>(R.id.btnRand)
//		btnRand.setOnClickListener(ButtonClickListener())
	}

	private inner class ButtonClickListener : View.OnClickListener {
		override fun onClick(view: View?) {
			_mainViewModel.generateNewRandNum()
			_activityMainBinding.tvRand.text = _mainViewModel.getRandNumStr()
		}
	}
}
