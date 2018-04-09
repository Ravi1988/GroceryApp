package groceryapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import javax.inject.Inject;

import groceryapp.R;
import groceryapp.TheGroceryApp;
import groceryapp.adapters.ProductListAdapter;
import groceryapp.di.AppComponent;
import groceryapp.di.ContextModule;
import groceryapp.viewmodel.ProductListVM;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Created by ravi.sharma01 on 4/9/18.
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
		rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), VERTICAL);
		rvList.addItemDecoration(dividerItemDecoration);
	}
}
