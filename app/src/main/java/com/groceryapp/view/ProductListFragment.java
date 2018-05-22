package com.groceryapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.groceryapp.R;
import com.groceryapp.TheGroceryApp;
import com.groceryapp.adapters.ProductListAdapter;
import com.groceryapp.di.AppComponent;
import com.groceryapp.di.ContextModule;
import com.groceryapp.viewmodel.ProductListVM;

import javax.inject.Inject;

import static android.support.v7.widget.DividerItemDecoration.HORIZONTAL;
import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 */

public class ProductListFragment extends BaseMVVMFragment<ProductListVM>{

	@Inject
	ProductListAdapter productListAdapter;

	@Override
	public int getFragmentLayout() {
		return R.layout.product_main_view;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		resolveDependency();
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		productListAdapter.setData(getViewModel().getProductList());
		RecyclerView rvList = view.findViewById(R.id.rvList);
		setupRv(rvList);
	}

	private void resolveDependency() {
		AppComponent appComponent = ((TheGroceryApp)getActivity().getApplication()).getAppComponent();
		appComponent.plus(new ContextModule(getActivity()))
				.inject(this);
	}

	private void setupRv(RecyclerView rvList) {
		rvList.setAdapter(productListAdapter);
		rvList.setLayoutManager(new GridLayoutManager(getActivity(),2));
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), VERTICAL);
		DividerItemDecoration dividerItemDecorationHorizontal = new DividerItemDecoration(getActivity(), HORIZONTAL);
		rvList.addItemDecoration(dividerItemDecoration);
		rvList.addItemDecoration(dividerItemDecorationHorizontal);
	}
}
