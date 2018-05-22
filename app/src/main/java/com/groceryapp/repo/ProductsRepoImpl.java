package com.groceryapp.repo;

import com.groceryapp.model.Product;
import com.groceryapp.model.ProductData;
import com.groceryapp.model.ProductDetailModel;
import com.groceryapp.network.MobileApi;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 */

public class ProductsRepoImpl implements ProductsRepo {

	private final MobileApi apiService;

	public ProductsRepoImpl(MobileApi apiService){
		this.apiService = apiService;
	}

	@Override
	public Observable<ProductData> getProductList(int page, int pageSize) {
		return apiService.getProductList(page,pageSize).
		subscribeOn(Schedulers.io())
		.observeOn(AndroidSchedulers.mainThread());
	}

	@Override
	public Observable<ProductDetailModel> getProductById(long id) {
		return apiService.getProduct(id).subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread());
	}

}
