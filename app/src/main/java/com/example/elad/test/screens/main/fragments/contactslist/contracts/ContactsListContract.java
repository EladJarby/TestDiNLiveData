package com.example.elad.test.screens.main.fragments.contactslist.contracts;

import android.arch.lifecycle.LiveData;

import com.example.elad.test.data.model.ContactsItem;
import com.example.elad.test.screens.base.BasePresenter;
import com.example.elad.test.screens.base.BaseView;

import java.util.List;

public interface ContactsListContract {
    interface Presenter extends BasePresenter<View> {
        List<ContactsItem> getContacts();
    }
    interface View extends BaseView {
    }
}
