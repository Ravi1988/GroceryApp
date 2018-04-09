package groceryapp.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import groceryapp.R;
import groceryapp.util.Contants.BundleKeys;
import groceryapp.view.ProductDetailFragment;
import groceryapp.view.ProductListFragment;

/**
 * Created by ravi.sharma01 on 2/23/18.
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
		addToBackStack(fragment);
	}

	@Override
	public void openProductDetailListPage() {
		Fragment fragment = new ProductListFragment();
		addToBackStack(fragment);
	}

	private void addToBackStack(Fragment fragment) {
		FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.frag_container,fragment,fragment.getClass().getName());
		transaction.addToBackStack(null);
		transaction.commit();
	}
}
