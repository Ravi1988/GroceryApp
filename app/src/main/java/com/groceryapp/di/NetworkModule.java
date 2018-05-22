package com.groceryapp.di;

import com.groceryapp.network.MobileApi;
import com.groceryapp.util.Contants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 */

@Module
public class NetworkModule {


	public NetworkModule(){}


	@Provides
	public RxJava2CallAdapterFactory providesRxAdapterFactory(){
		return RxJava2CallAdapterFactory.create();
	}

	@Provides
	public JacksonConverterFactory providesJacksonFactory(){
		return JacksonConverterFactory.create();
	}

	@Provides
	@Singleton
	public Retrofit providesRetrofit(JacksonConverterFactory factory, RxJava2CallAdapterFactory adapterFactory){
		return new Retrofit.Builder()
				   .baseUrl(Contants.BASE_URL)
				   .addConverterFactory(factory)
				   .addCallAdapterFactory(adapterFactory)
				   .build();
	}

	@Provides
	@Singleton
	public MobileApi proivdeMobileApi(Retrofit retrofit){
		return retrofit.create(MobileApi.class);
	}
}
