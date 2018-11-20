package com.example.elad.test.screens.splash.contracts;

import com.example.elad.test.data.model.ContactsList;
import com.example.elad.test.data.remote.Api;
import com.example.elad.test.screens.base.BasePresenter;
import com.example.elad.test.screens.base.BaseView;
import com.example.elad.test.screens.main.contracts.MainContract;

import retrofit2.Call;

public interface SplashContract {
    interface Presenter extends BasePresenter<SplashContract.View> {
        void init();
    }
    interface View extends BaseView {
    }
    interface Interactor {
        Call<ContactsList> getJson(Api api);
    }}
