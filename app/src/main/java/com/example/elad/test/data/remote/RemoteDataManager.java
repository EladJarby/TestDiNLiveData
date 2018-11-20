package com.example.elad.test.data.remote;

import com.example.elad.test.data.local.RetrofitManager;

public class RemoteDataManager {
    private static RemoteDataManager remoteDataManager;
    private Api api;
    private RemoteDataManager() {
        api = RetrofitManager.getApi();
    }

    public synchronized static RemoteDataManager getRemoteDataManager() {
        if(remoteDataManager == null) {
            remoteDataManager = new RemoteDataManager();
        }
        return remoteDataManager;
    }

    public Api getApi() {
        return api;
    }

}
