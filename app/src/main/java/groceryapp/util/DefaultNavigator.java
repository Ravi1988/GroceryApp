package groceryapp.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import groceryapp.R;
import groceryapp.view.ProductDetailFragment;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */

public class DefaultNavigator implements Navigator{

	private final FragmentActivity activity;

	public DefaultNavigator(FragmentActivity activity){
		this.activity = activity;
	}

	@Override
	public void openProductDetailPage(int pos) {
		FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
		Fragment fragment = new ProductDetailFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("position",pos);
		fragment.setArguments(bundle);
		transaction.add(R.id.frag_container,fragment,fragment.getClass().getName());
		transaction.addToBackStack(null);
		transaction.commit();
	}
}
