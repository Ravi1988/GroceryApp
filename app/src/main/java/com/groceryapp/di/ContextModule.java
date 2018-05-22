package com.groceryapp.di;

import android.support.v4.app.FragmentActivity;

import com.groceryapp.util.DefaultNavigator;
import com.groceryapp.util.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 */

@Module
@Singleton
public class ContextModule {

	private final FragmentActivity activity;

	public ContextModule(FragmentActivity activity){
		this.activity = activity;
	}

	@Provides
	public Navigator providesDefaultNavigator(){
		return new DefaultNavigator(activity);
	}
}
