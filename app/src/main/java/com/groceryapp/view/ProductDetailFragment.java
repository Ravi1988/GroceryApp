package com.groceryapp.view;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.groceryapp.R;
import com.groceryapp.TheGroceryApp;
import com.groceryapp.di.AppComponent;
import com.groceryapp.di.ContextModule;
import com.groceryapp.util.Contants.BundleKeys;
import com.groceryapp.viewmodel.ProductDetailVM;

/**
 */

public class ProductDetailFragment extends BaseMVVMFragment<ProductDetailVM> {

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		resolveDependency();
		long productId = getArguments().getLong(BundleKeys.PRODUCT_ID);
		getViewModel().setId(productId);
	}

	private void resolveDependency() {
		AppComponent appComponent = ((TheGroceryApp)getActivity().getApplication()).getAppComponent();
		appComponent.plus(new ContextModule(getActivity()))
				.inject(this);
	}

	@Override
	public int getFragmentLayout() {
		return R.layout.product_detail_view;
	}

}
