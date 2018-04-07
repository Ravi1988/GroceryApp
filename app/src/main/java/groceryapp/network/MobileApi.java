package groceryapp.network;

import groceryapp.model.ProductData;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ravi.sharma01 on 2/20/18.
 */

public interface MobileApi {
	@GET("v2/top-headlines?sources=the-hindu")
	Observable<ProductData> getTopStories(@Query("apiKey") String apiKey);
}
