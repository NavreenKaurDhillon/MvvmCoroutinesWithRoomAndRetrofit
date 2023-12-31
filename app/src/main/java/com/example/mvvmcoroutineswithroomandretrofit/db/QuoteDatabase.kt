package com.example.mvvmcoroutineswithroomandretrofit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmcoroutineswithroomandretrofit.model.QuoteItem


@Database(entities = [QuoteItem::class], version = 1)
abstract class QuoteDatabase() : RoomDatabase(){

    abstract fun getQuoteDao() : QuoteDao

    companion object{
        private var INSTANCE : QuoteDatabase?= null
        fun getDbInstance( context: Context) : QuoteDatabase
        {
            if(INSTANCE==null){
                INSTANCE = Room.databaseBuilder(context  ,QuoteDatabase::class.java
                , "quote_db").build()

            }
            return INSTANCE!!
        }

    }


}