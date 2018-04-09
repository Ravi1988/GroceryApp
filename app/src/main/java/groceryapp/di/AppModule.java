package groceryapp.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import groceryapp.network.MobileApi;
import groceryapp.repo.ProductsRepo;
import groceryapp.repo.ProductsRepoImpl;

/**
 * Created by ravi.sharma01 on 2/23/18.
 */
@Module (includes = NetworkModule.class)
public class AppModule {

	@Provides
	@Singleton
	ProductsRepo providesNewsItemRepoImpl(MobileApi apiService) {
		return new ProductsRepoImpl(apiService);
	}
}
