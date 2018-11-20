package com.example.elad.test.screens.splash.impl;

import com.example.elad.test.data.model.ContactsList;
import com.example.elad.test.data.remote.Api;
import com.example.elad.test.screens.splash.contracts.SplashContract;

import retrofit2.Call;

public class SplashInteractor implements SplashContract.Interactor {
    private static SplashInteractor splashInteractor;

    private SplashInteractor() {}

    public synchronized static SplashInteractor getSplashInteractor() {
        if(splashInteractor == null) {
            splashInteractor = new SplashInteractor();
        }
        return splashInteractor;
    }

    @Override
    public Call<ContactsList> getJson(Api api) {
        return api.getJson();
    }
}