package com.groceryapp.di;

import com.groceryapp.network.MobileApi;
import com.groceryapp.repo.ProductsRepo;
import com.groceryapp.repo.ProductsRepoImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 */
@Module (includes = NetworkModule.class)
public class AppModule {

	@Provides
	@Singleton
	ProductsRepo providesNewsItemRepoImpl(MobileApi apiService) {
		return new ProductsRepoImpl(apiService);
	}
}
