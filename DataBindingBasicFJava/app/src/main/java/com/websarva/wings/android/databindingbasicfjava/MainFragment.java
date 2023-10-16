package com.websarva.wings.android.databindingbasicfjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.websarva.wings.android.databindingbasicfjava.databinding.FragmentMainBinding;
import com.websarva.wings.android.databindingbasicfjava.ui.MainViewModel;

public class MainFragment extends Fragment {
	private MainViewModel _mainViewModel;
	private FragmentMainBinding _fragmentMainBinding;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		_fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
		View contentView = _fragmentMainBinding.getRoot();
		return contentView;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ViewModelProvider provider = new ViewModelProvider(MainFragment.this);
		_mainViewModel = provider.get(MainViewModel.class);

		_fragmentMainBinding.setRandNum(_mainViewModel.getRandNumStr());
		_fragmentMainBinding.btnRand.setOnClickListener(new ButtonClickListener());
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		_fragmentMainBinding = null;
	}

	private class ButtonClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			_mainViewModel.generateNewRandNum();
			_fragmentMainBinding.setRandNum(_mainViewModel.getRandNumStr());
		}
	}
}
