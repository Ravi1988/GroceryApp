package groceryapp.repo;

import groceryapp.model.ProductData;
import groceryapp.network.MobileApi;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public class ProductListRepoImpl implements ProductListRepo {

	private final MobileApi apiService;

	public ProductListRepoImpl(MobileApi apiService){
		this.apiService = apiService;
	}

	@Override
	public Observable<ProductData> getTopStories() {
		return apiService.getTopStories("950a93ff3c884c77a7b84a79fa6dfaa3").
		subscribeOn(Schedulers.io())
		.observeOn(AndroidSchedulers.mainThread())
		.doOnNext(new Consumer<ProductData>() {
			@Override
			public void accept(ProductData news) throws Exception {
				//add caching
			}
		});
	}

}
