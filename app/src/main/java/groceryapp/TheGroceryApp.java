package groceryapp;

import android.app.Application;

import groceryapp.di.AppComponent;
import groceryapp.di.AppModule;
import groceryapp.di.DaggerAppComponent;


/**
 * Created by ravi.sharma01 on 1/28/18.
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
