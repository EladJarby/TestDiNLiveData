package com.example.elad.test.screens.main.fragments.contactslist.impl;

import com.example.elad.test.data.DataManager;
import com.example.elad.test.data.model.ContactsItem;
import com.example.elad.test.screens.main.fragments.contactslist.contracts.ContactsListContract;

import java.util.List;

public class ContactsListPresenter implements ContactsListContract.Presenter {

    private DataManager dataManager;
    private ContactsListContract.View view;

    public ContactsListPresenter() {
        this.dataManager = DataManager.getDataManager();
    }

    @Override
    public void onAttach(ContactsListContract.View view) {
        this.view = view;
    }

    @Override
    public List<ContactsItem> getContacts() {
        return dataManager.getLocalDataManager().getAppDatabase().contactsItemDao().getAllContacts();
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
