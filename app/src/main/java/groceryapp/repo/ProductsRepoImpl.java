package groceryapp.repo;

import groceryapp.model.Product;
import groceryapp.model.ProductData;
import groceryapp.network.MobileApi;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ravi.sharma01 on 2/20/18.
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
		.observeOn(AndroidSchedulers.mainThread())
		.doOnNext(new Consumer<ProductData>() {
			@Override
			public void accept(ProductData news) throws Exception {
				//add caching
			}
		});
	}

	@Override
	public Observable<Product> getProductById(long id) {
		return apiService.getProduct(id);
	}

}
