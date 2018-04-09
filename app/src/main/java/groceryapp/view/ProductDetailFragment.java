package groceryapp.view;


import android.os.Bundle;
import android.support.annotation.Nullable;

import groceryapp.R;
import groceryapp.TheGroceryApp;
import groceryapp.di.AppComponent;
import groceryapp.di.ContextModule;
import groceryapp.util.Contants.BundleKeys;
import groceryapp.viewmodel.ProductVM;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */

public class ProductDetailFragment extends BaseMVVMFragment<ProductVM> {

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
