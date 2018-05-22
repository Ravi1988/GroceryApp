package com.groceryapp.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

	ContextComponent plus(ContextModule contextModule);
}
