package com.groceryapp.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.groceryapp.BR;
import com.groceryapp.R;
import com.groceryapp.TheGroceryApp;
import com.groceryapp.di.AppComponent;
import com.groceryapp.di.ContextModule;
import com.groceryapp.viewmodel.MainActivityVM;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

	@Inject
	MainActivityVM viewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		resolveDependency();
		ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
		binding.setVariable(BR.vm,viewModel);
		viewModel.onLoad();
	}


	private void resolveDependency() {
		AppComponent appComponent = ((TheGroceryApp)getApplication()).getAppComponent();
		appComponent.plus(new ContextModule(this))
		.inject(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		viewModel.onDestroy();
		viewModel = null;
	}
}
