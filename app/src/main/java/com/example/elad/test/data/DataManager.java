package com.example.elad.test.data;

import com.example.elad.test.data.local.LocalDataManager;
import com.example.elad.test.data.remote.RemoteDataManager;

public class DataManager {
    private static DataManager dataManager;
    private LocalDataManager localDataManager;
    private RemoteDataManager remoteDataManager;

    private DataManager(){
        this.localDataManager = LocalDataManager.getLocalDataManager();
        this.remoteDataManager = RemoteDataManager.getRemoteDataManager();
    }

    public synchronized static DataManager getDataManager() {
        if(dataManager == null) {
            dataManager = new DataManager();
        }
        return dataManager;
    }

    public LocalDataManager getLocalDataManager() {
        return localDataManager;
    }

    public RemoteDataManager getRemoteDataManager() {
        return remoteDataManager;
    }
}
