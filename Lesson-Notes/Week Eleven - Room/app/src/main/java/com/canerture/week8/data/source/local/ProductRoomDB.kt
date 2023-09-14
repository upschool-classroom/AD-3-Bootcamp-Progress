package com.canerture.week8.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.canerture.week8.data.model.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductRoomDB : RoomDatabase() {

    abstract fun productsDao(): ProductDao
}