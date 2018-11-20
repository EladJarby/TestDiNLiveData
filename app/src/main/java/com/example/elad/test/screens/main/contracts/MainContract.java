package com.example.elad.test.screens.main.contracts;

import com.example.elad.test.data.model.ContactsList;
import com.example.elad.test.data.remote.Api;
import com.example.elad.test.screens.base.BasePresenter;
import com.example.elad.test.screens.base.BaseView;

import retrofit2.Call;

public interface MainContract {
    interface Presenter extends BasePresenter<View> {
    }
    interface View extends BaseView {
    }
    interface Interactor {
    }
}
