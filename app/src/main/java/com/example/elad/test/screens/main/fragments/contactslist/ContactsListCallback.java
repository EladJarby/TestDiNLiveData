package com.example.elad.test.screens.main.fragments.contactslist;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.example.elad.test.data.model.ContactsItem;

public class ContactsListCallback extends DiffUtil.ItemCallback<ContactsItem> {
    @Override
    public boolean areItemsTheSame(@NonNull ContactsItem contactsItem, @NonNull ContactsItem t1) {
        return contactsItem.getId().equals(t1.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull ContactsItem contactsItem, @NonNull ContactsItem t1) {
        return contactsItem == t1;
    }
}
