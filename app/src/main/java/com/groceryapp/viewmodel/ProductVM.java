package com.groceryapp.viewmodel;

import android.databinding.Bindable;

import com.groceryapp.BR;
import com.groceryapp.model.Product;
import com.groceryapp.util.Navigator;

import javax.inject.Inject;

/**
 */

public class ProductVM extends BaseViewModel {

	private Navigator navigator;
	private Product product;

	@Inject
	public ProductVM(Navigator navigator) {
		this.navigator = navigator;
	}
	@Bindable
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		notifyPropertyChanged(BR.product);
	}

	public void openProductDetail() {
		if (product != null) {
			navigator.openProductDetailPage(product.getId());
		}
	}


}
