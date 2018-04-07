package groceryapp.di;

import dagger.Subcomponent;
import groceryapp.view.MainActivity;
import groceryapp.view.ProductDetailFragment;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */
@Subcomponent(modules = ContextModule.class)
public interface ContextComponent {
	void inject(MainActivity mainActivity);
	void inject(ProductDetailFragment mainActivity);
}
