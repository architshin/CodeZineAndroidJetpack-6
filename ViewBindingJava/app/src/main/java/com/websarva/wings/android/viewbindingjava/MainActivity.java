package com.websarva.wings.android.viewbindingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.websarva.wings.android.viewbindingjava.databinding.ActivityMainBinding;
import com.websarva.wings.android.viewbindingjava.ui.MainViewModel;

public class MainActivity extends AppCompatActivity {
	private MainViewModel _mainViewModel;
	private ActivityMainBinding _activityMainBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
		View contentView = _activityMainBinding.getRoot();
		setContentView(contentView);

		ViewModelProvider provider = new ViewModelProvider(MainActivity.this);
		_mainViewModel = provider.get(MainViewModel.class);

		_activityMainBinding.tvRand.setText(_mainViewModel.getRandNumStr());
		_activityMainBinding.btnRand.setOnClickListener(new ButtonClickListener());

//		TextView tvRand = findViewById(R.id.tvRand);
//		tvRand.setText(_mainViewModel.getRandNumStr());
//		Button btnRand = findViewById(R.id.btnRand);
//		btnRand.setOnClickListener(new ButtonClickListener());
	}

	private class ButtonClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			_mainViewModel.generateNewRandNum();
			_activityMainBinding.tvRand.setText(_mainViewModel.getRandNumStr());
		}
	}
}
