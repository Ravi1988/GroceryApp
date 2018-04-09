package groceryapp.view;


import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import groceryapp.BR;
import groceryapp.R;
import groceryapp.TheGroceryApp;
import groceryapp.databinding.ProductDetailViewBinding;
import groceryapp.di.AppComponent;
import groceryapp.di.ContextModule;
import groceryapp.model.Product;
import groceryapp.viewmodel.ProductListVM;
import groceryapp.viewmodel.ProductVM;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */

public class ProductDetailFragment extends DialogFragment {


	@Inject
	ProductListVM productListVM;

	@Inject
	ProductVM productVM;

	private int pos;
	private ProductDetailViewBinding bind;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		resolveDependency();
		pos = getArguments().getInt("position");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		bind = DataBindingUtil.inflate(inflater, R.layout.product_detail_view,container,false);
		productListVM.getProductList().addOnListChangedCallback(itemChangedListener);
		productListVM.load();
		return bind.getRoot();
	}

	private void resolveDependency() {
		AppComponent appComponent = ((TheGroceryApp)getActivity().getApplication()).getAppComponent();
		appComponent.plus(new ContextModule(getActivity()))
				.inject(this);
	}

	private final ObservableList.OnListChangedCallback<ObservableList<Product>> itemChangedListener = new ObservableList.OnListChangedCallback<ObservableList<Product>>() {
		@Override
		public void onChanged(ObservableList<Product> news) {
		}

		@Override
		public void onItemRangeChanged(ObservableList<Product> news, int start, int count) {
		}

		@Override
		public void onItemRangeInserted(ObservableList<Product> news, int start, int count) {
			productVM.setProduct(news.get(pos));
			bind.setVariable(BR.vm,productVM);
			bind.executePendingBindings();
			productVM.openNewsDetail();
		}

		@Override
		public void onItemRangeMoved(ObservableList<Product> news, int i, int i1, int i2) {
		}

		@Override
		public void onItemRangeRemoved(ObservableList<Product> news, int start, int count) {
		}
	};

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

}
