package com.example.elad.test.data.local.roomdb;

import android.arch.persistence.room.TypeConverter;

import com.example.elad.test.data.model.Phone;
import com.google.gson.Gson;

public class DataTypeConverters {
    @TypeConverter
    public static Phone toPhone(String phone) {
        return new Gson().fromJson(phone,Phone.class);
    }

    @TypeConverter
    public static String ToString(Phone phone) {
        return new Gson().toJson(phone);
    }
}
