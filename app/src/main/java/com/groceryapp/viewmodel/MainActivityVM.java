package com.groceryapp.viewmodel;

import com.groceryapp.util.Navigator;

import javax.inject.Inject;

/**
 */

public class MainActivityVM extends BaseViewModel{
	private Navigator navigator;

	@Inject
	public MainActivityVM(Navigator navigator){
		this.navigator = navigator;
	}

	@Override
	public void onLoad() {
		super.onLoad();
		navigator.openProductDetailListPage();
	}

}
