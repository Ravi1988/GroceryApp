package com.groceryapp;

import android.app.Application;

import com.groceryapp.di.AppComponent;
import com.groceryapp.di.AppModule;
import com.groceryapp.di.DaggerAppComponent;


/**
 */

public class TheGroceryApp extends Application{


	private AppComponent appComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		initAppComponent();
	}

	private void initAppComponent() {
		appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
	}

	public AppComponent getAppComponent(){
		return appComponent;
	}
}
