package com.websarva.wings.android.databindingbasicfjava.ui;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
	private double _randNum = 0;

	public void generateNewRandNum() {
		_randNum = Math.random();
	}

	public String getRandNumStr() {
		return String.valueOf(_randNum);
	}
}
