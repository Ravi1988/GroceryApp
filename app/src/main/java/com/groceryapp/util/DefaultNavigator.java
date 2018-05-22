package com.groceryapp.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.groceryapp.R;
import com.groceryapp.util.Contants.BundleKeys;
import com.groceryapp.view.ProductDetailFragment;
import com.groceryapp.view.ProductListFragment;

/**
 */

public class DefaultNavigator implements Navigator{

	private final FragmentActivity activity;

	public DefaultNavigator(FragmentActivity activity){
		this.activity = activity;
	}

	@Override
	public void openProductDetailPage(long prodId) {
		Fragment fragment = new ProductDetailFragment();
		Bundle bundle = new Bundle();
		bundle.putLong(BundleKeys.PRODUCT_ID,prodId);
		fragment.setArguments(bundle);
		addToBackStack(fragment,true);
	}

	@Override
	public void openProductDetailListPage() {
		Fragment fragment = new ProductListFragment();
		addToBackStack(fragment,false);
	}

	private void addToBackStack(Fragment fragment, boolean addToBackStack) {
		FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.frag_container,fragment,fragment.getClass().getName());
		if(addToBackStack){
			transaction.addToBackStack(null);
		}
		transaction.commit();
	}
}
