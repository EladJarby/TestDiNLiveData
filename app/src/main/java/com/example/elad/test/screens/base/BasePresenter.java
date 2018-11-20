package com.example.elad.test.screens.base;

public interface BasePresenter<T> {
    void onAttach(T view);
    void onDetach();
}
