package com.canerture.week8.di

import com.canerture.week8.data.repository.ProductsRepository
import com.canerture.week8.data.source.remote.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(productService: ProductService): ProductsRepository =
        ProductsRepository(productService)
}