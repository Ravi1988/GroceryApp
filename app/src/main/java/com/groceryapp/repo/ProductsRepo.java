package com.groceryapp.repo;


import com.groceryapp.model.ProductData;
import com.groceryapp.model.ProductDetailModel;

import io.reactivex.Observable;

/**
 */

public interface ProductsRepo {

	Observable<ProductData> getProductList(int page, int pageSize);
	Observable<ProductDetailModel> getProductById(long id);
}
