package groceryapp.di;

import dagger.Subcomponent;
import groceryapp.view.MainActivity;
import groceryapp.view.ProductDetailFragment;
import groceryapp.view.ProductListFragment;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */
@Subcomponent(modules = ContextModule.class)
public interface ContextComponent {
	void inject(MainActivity mainActivity);
	void inject(ProductDetailFragment productDetailFragment);
	void inject(ProductListFragment productListFragment);
}
