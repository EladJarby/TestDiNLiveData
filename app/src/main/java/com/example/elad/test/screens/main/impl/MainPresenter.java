package com.example.elad.test.screens.main.impl;

import com.example.elad.test.data.DataManager;
import com.example.elad.test.screens.main.contracts.MainContract;

public class MainPresenter implements MainContract.Presenter {

    DataManager dataManager;
    MainContract.View view;

    public MainPresenter() {
        this.dataManager = DataManager.getDataManager();
    }

    @Override
    public void onAttach(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
