package com.groceryapp.viewmodel;

import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.groceryapp.BR;
import com.groceryapp.model.Product;
import com.groceryapp.repo.ProductsRepo;

import javax.inject.Inject;

/**
 */

public class ProductDetailVM extends BaseViewModel{
	private final ProductsRepo productsRepo;
	private long id;
	private ObservableField<Product> product;
	@Inject
	public ProductDetailVM(ProductsRepo productsRepo){
		this.productsRepo = productsRepo;
		product = new ObservableField<>();
	}

	@Override
	public void onLoad() {
		super.onLoad();
		showLoader();
		productsRepo.getProductById(getId()).subscribe(productDetailModel -> setProduct(productDetailModel.getProduct()),
				error-> {showError();hideLoader();},
				this::hideLoader);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Bindable
	public Product getProduct() {
		return product.get();
	}

	public void setProduct(Product product) {
		this.product.set(product);
		notifyPropertyChanged(BR.product);
	}
}
