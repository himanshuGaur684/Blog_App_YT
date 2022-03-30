package com.gaur.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gaur.domain.model.Blog

@Database(entities = [Blog::class, BlogKey::class], version = 1, exportSchema = false)
@TypeConverters(RoomTypeConvertor::class, ListOfStringToStringTypeConvertor::class)
abstract class BlogDataBase : RoomDatabase() {


    companion object {
        fun getInstance(context: Context): BlogDataBase {
            return Room.databaseBuilder(context, BlogDataBase::class.java, "blog").build()
        }
    }

    abstract fun getBlogDAO(): BlogDAO

}