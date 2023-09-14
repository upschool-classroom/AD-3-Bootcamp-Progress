package com.canerture.week8.di

import android.content.Context
import androidx.room.Room
import com.canerture.week8.data.source.local.ProductRoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDBModule {

    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ProductRoomDB::class.java, "product_room_db").build()

    @Provides
    @Singleton
    fun provideDao(roomDB: ProductRoomDB) = roomDB.productsDao()
}