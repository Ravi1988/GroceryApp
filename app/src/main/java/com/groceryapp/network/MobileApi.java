package com.groceryapp.network;

import com.groceryapp.model.ProductData;
import com.groceryapp.model.ProductDetailModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 */

public interface MobileApi {
	@GET("v1.6.0/catalog/search?")
	Observable<ProductData> getProductList(@Query("page") int page,@Query("pageSize") int pageSize);
	@GET("v1.6.0/catalog/products/{id}")
	Observable<ProductDetailModel> getProduct(@Path("id")long id);
}
