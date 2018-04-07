package groceryapp.repo;


import groceryapp.model.ProductData;
import io.reactivex.Observable;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public interface ProductListRepo {

	Observable<ProductData> getTopStories();
}
