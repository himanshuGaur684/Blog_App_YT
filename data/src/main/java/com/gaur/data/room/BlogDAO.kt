package com.gaur.data.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gaur.domain.model.Blog

@Dao
interface BlogDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBlogs(list: List<Blog>)

    @Query("SELECT * FROM Blog")
    fun getAllBlogItems(): PagingSource<Int, Blog>

    @Query("DELETE FROM Blog")
    suspend fun deleteAllItems()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBlogKeys(l: List<BlogKey>)

    @Query("DELETE FROM BlogKey")
    suspend fun deleteAllBlogKey()

    @Query("SELECT * FROM BlogKey WHERE id=:id")
    suspend fun getAllKeys(id: String): BlogKey


}