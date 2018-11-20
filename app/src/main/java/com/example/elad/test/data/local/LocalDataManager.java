package com.example.elad.test.data.local;

public class LocalDataManager {
    private static LocalDataManager localDataManager;
    private AppDatabase appDatabase;

    private LocalDataManager() {
        appDatabase = AppDatabase.getMyDb();
    }

    public synchronized static LocalDataManager getLocalDataManager() {
        if(localDataManager == null) {
            localDataManager = new LocalDataManager();
        }
        return localDataManager;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
