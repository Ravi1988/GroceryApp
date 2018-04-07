package groceryapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import javax.inject.Inject;

import groceryapp.R;
import groceryapp.TheGroceryApp;
import groceryapp.adapters.ProductListAdapter;
import groceryapp.databinding.ProductMainViewBinding;
import groceryapp.di.AppComponent;
import groceryapp.di.ContextModule;
import groceryapp.viewmodel.ProductListVM;

public class MainActivity extends AppCompatActivity {

	@Inject
	ProductListAdapter productListAdapter;

	@Inject
	ProductListVM viewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("ActivityLifeCycle","onCreate");
		super.onCreate(savedInstanceState);
		resolveDependency();
		ProductMainViewBinding binding = DataBindingUtil.setContentView(this, R.layout.product_main_view);
		binding.setVm(viewModel);
		productListAdapter.setData(viewModel.getProductList());
		viewModel.load();
		RecyclerView rvList = (RecyclerView) findViewById(R.id.rvList);
		setupRv(rvList);
		SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
		setupSwipeLayout(refreshLayout);

	}

	private void resolveDependency() {
		AppComponent appComponent = ((TheGroceryApp)getApplication()).getAppComponent();
		appComponent.plus(new ContextModule(this))
		.inject(this);
	}

	private void setupSwipeLayout(SwipeRefreshLayout refreshLayout) {
		refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				viewModel.load();
			}
		});
	}

	private void setupRv(RecyclerView rvList) {
		rvList.setAdapter(productListAdapter);
		rvList.setLayoutManager(new LinearLayoutManager(this));
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
				DividerItemDecoration.VERTICAL);
		rvList.addItemDecoration(dividerItemDecoration);
	}

	@Override
	protected void onStart() {
		Log.d("ActivityLifeCycle","onStart");
		super.onStart();
	}

	@Override
	protected void onPause() {
		Log.d("ActivityLifeCycle","onPause");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.d("ActivityLifeCycle","onRestart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d("ActivityLifeCycle","onResume");
		super.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
		Log.d("ActivityLifeCycle","onSaveInstanceState");
		super.onSaveInstanceState(outState, outPersistentState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		Log.d("ActivityLifeCycle","onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
	}


	@Override
	public void onAttachFragment(android.support.v4.app.Fragment fragment) {
		Log.d("ActivityLifeCycle","onAttachFragment");
		super.onAttachFragment(fragment);
	}

	@Override
	protected void onDestroy() {
		Log.d("ActivityLifeCycle","onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onStop() {
		Log.d("ActivityLifeCycle","onStop");
		super.onStop();
	}
}
