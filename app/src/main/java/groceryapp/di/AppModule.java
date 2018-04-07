package groceryapp.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import groceryapp.network.MobileApi;
import groceryapp.repo.ProductListRepo;
import groceryapp.repo.ProductListRepoImpl;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */
@Module (includes = NetworkModule.class)
public class AppModule {

	@Provides
	@Singleton
	ProductListRepo providesNewsItemRepoImpl(MobileApi apiService) {
		return new ProductListRepoImpl(apiService);
	}
}
