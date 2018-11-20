package com.example.elad.test.data.local.roomdb;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.support.v4.util.Consumer;

import com.example.elad.test.data.model.ContactsItem;

import java.util.List;

@Dao
public interface ContactsItemDao {
    @Query("SELECT * FROM ContactsItem ORDER BY name ASC")
    List<ContactsItem> getAllContacts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContacts(List<ContactsItem> contactsItems);

    @Delete
    void deleteContact(ContactsItem contactsItem);
}
