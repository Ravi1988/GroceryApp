package groceryapp.di;

import android.support.v4.app.FragmentActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import groceryapp.util.DefaultNavigator;
import groceryapp.util.Navigator;

/**
 * Created by ravi.sharma01 on 2/23/18.
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
