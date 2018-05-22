package com.groceryapp.di;

import com.groceryapp.view.MainActivity;
import com.groceryapp.view.ProductDetailFragment;
import com.groceryapp.view.ProductListFragment;

import dagger.Subcomponent;

/**
 */
@Subcomponent(modules = ContextModule.class)
public interface ContextComponent {
	void inject(MainActivity mainActivity);
	void inject(ProductDetailFragment productDetailFragment);
	void inject(ProductListFragment productListFragment);
}
