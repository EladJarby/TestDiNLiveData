package com.example.elad.test.screens.splash.impl;

import com.example.elad.test.data.DataManager;
import com.example.elad.test.data.model.ContactsItem;
import com.example.elad.test.data.model.ContactsList;
import com.example.elad.test.screens.splash.contracts.SplashContract;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashPresenter implements SplashContract.Presenter {

    private DataManager dataManager;
    private SplashContract.Interactor interactor;
    private SplashContract.View view;

    public SplashPresenter() {
        this.interactor = SplashInteractor.getSplashInteractor();
        this.dataManager = DataManager.getDataManager();
    }

    @Override
    public void onAttach(SplashContract.View view) {
        this.view = view;
        init();
    }

    @Override
    public void init() {
        interactor.getJson(dataManager.getRemoteDataManager().getApi()).enqueue(new Callback<ContactsList>() {
            @Override
            public void onResponse(Call<ContactsList> call, Response<ContactsList> response) {
                if(response.body() != null) {
                    insertContacts(response.body().getContacts());
                }
            }

            @Override
            public void onFailure(Call<ContactsList> call, Throwable t) {

            }
        });
    }

    private void insertContacts(final List<ContactsItem> contacts) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dataManager.getLocalDataManager().getAppDatabase().contactsItemDao().insertContacts(contacts);
            }
        });
    }

    @Override
    public void onDetach() {
        view = null;
    }
}

