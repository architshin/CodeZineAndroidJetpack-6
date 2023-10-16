package com.websarva.wings.android.databindingbasicfkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.websarva.wings.android.databindingbasicfkotlin.databinding.FragmentMainBinding
import com.websarva.wings.android.databindingbasicfkotlin.ui.MainViewModel

class MainFragment : Fragment() {
	private val _mainViewModel by viewModels<MainViewModel>()
	private var _fragmentMainBindingInit: FragmentMainBinding? = null
	private val _fragmentMainBinding get() = _fragmentMainBindingInit!!

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		_fragmentMainBindingInit = FragmentMainBinding.inflate(inflater, container, false)
		return _fragmentMainBinding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		_fragmentMainBinding.randNum = _mainViewModel.getRandNumStr()
		_fragmentMainBinding.btnRand.setOnClickListener(ButtonClickListener())
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_fragmentMainBindingInit = null;
	}

	private inner class ButtonClickListener : View.OnClickListener {
		override fun onClick(view: View?) {
			_mainViewModel.generateNewRandNum()
			_fragmentMainBinding.randNum = _mainViewModel.getRandNumStr()
		}
	}
}
