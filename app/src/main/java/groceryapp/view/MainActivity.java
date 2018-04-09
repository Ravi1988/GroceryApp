package groceryapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import groceryapp.TheGroceryApp;
import groceryapp.di.AppComponent;
import groceryapp.di.ContextModule;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		resolveDependency();
	}


	private void resolveDependency() {
		AppComponent appComponent = ((TheGroceryApp)getApplication()).getAppComponent();
		appComponent.plus(new ContextModule(this))
		.inject(this);
	}

}
