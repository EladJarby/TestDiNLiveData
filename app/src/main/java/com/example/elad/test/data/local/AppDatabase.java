package com.example.elad.test.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.elad.test.App;
import com.example.elad.test.data.local.roomdb.ContactsItemDao;
import com.example.elad.test.data.local.roomdb.DataTypeConverters;
import com.example.elad.test.data.model.ContactsItem;

@Database(entities = {ContactsItem.class}, version = 1)
@TypeConverters({DataTypeConverters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase db;

    public abstract ContactsItemDao contactsItemDao();

    public synchronized static AppDatabase getMyDb() {
        if(db == null) {
            db = Room.databaseBuilder(App.getMyContext(),
                    AppDatabase.class,"db").build();
        }
        return db;
    }
}
