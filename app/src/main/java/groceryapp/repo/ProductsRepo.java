package groceryapp.repo;


import groceryapp.model.Product;
import groceryapp.model.ProductData;
import io.reactivex.Observable;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public interface ProductsRepo {

	Observable<ProductData> getProductList(int page, int pageSize);
	Observable<Product> getProductById(long id);
}
