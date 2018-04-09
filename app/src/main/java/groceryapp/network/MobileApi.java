package groceryapp.network;

import groceryapp.model.Product;
import groceryapp.model.ProductData;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public interface MobileApi {
	@GET("v2/top-headlines?")
	Observable<ProductData> getProductList(@Query("page") int page,@Query("pageSize") int pageSize);
	Observable<Product> getProduct(@Query("id") long id);
}
