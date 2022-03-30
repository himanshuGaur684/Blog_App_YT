package com.gaur.data.room

import androidx.room.TypeConverter
import com.gaur.domain.model.Owner
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomTypeConvertor {

    @TypeConverter
    fun ownerToString(owner: Owner): String {
        return Gson().toJson(owner)
    }


    @TypeConverter
    fun stringToOwner(str: String): Owner {
        return Gson().fromJson(str, Owner::class.java)
    }

}


class ListOfStringToStringTypeConvertor {


    @TypeConverter
    fun listOfStringToString(str: List<String>): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun strToListString(str: String): List<String> {
        return Gson().fromJson(str, object : TypeToken<List<String>>() {}.type)
    }

}