package com.groceryapp.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import com.groceryapp.model.Product;
import com.groceryapp.model.ProductData;
import com.groceryapp.repo.ProductsRepo;

import javax.inject.Inject;

/**
 */

public class ProductListVM extends BaseViewModel {

	private ProductsRepo productListRepo;
	private ObservableField<ProductData> productData;
	private ObservableField<Product> product;
	private ObservableList<Product> productList;

	@Inject
	public ProductListVM(ProductsRepo productListRepo) {
		productData = new ObservableField<>();
		product = new ObservableField<>();
		productList = new ObservableArrayList<>();
		this.productListRepo = productListRepo;
	}


	public void onLoad(){
		showLoader();
		productListRepo.getProductList(0,20).subscribe(data -> {
			productData.set(data);
			productList.clear();
			productList.addAll(data.getProducts());
			hideLoader();},
			error -> {hideLoader();showError();
			},this::hideLoader);
	}

	public ObservableField<ProductData> getProductData() {
		return productData;
	}

	public ObservableField<Product> getProduct() {
		return product;
	}

	public void setProduct(Product value){
		product.set(value);
	}
	public ObservableList<Product> getProductList() {
		return productList;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		productList.clear();
	}
}
