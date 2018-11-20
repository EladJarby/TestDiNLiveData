package com.example.elad.test.screens.main.fragments.contactslist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elad.test.R;
import com.example.elad.test.data.model.ContactsItem;
import com.example.elad.test.screens.base.BaseFragment;
import com.example.elad.test.screens.main.fragments.contactslist.adapters.ContactsListAdapter;
import com.example.elad.test.screens.main.fragments.contactslist.contracts.ContactsListContract;
import com.example.elad.test.screens.main.fragments.contactslist.impl.ContactsListPresenter;

import java.util.List;

public class ContactsListFragment extends BaseFragment implements ContactsListContract.View {

    ContactsListContract.Presenter presenter;
    private AsyncTask async;

    RecyclerView recyclerView;
    ContactsListAdapter contactsListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ContactsListPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contacts_list,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onAttach(this);
        getContacts();
        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        contactsListAdapter = new ContactsListAdapter(new ContactsListCallback());
        recyclerView.setAdapter(contactsListAdapter);
    }

    private void getContacts() {
        async = new DownloadContactsTask().execute();
    }

    private class DownloadContactsTask extends AsyncTask<Void,Void,List<ContactsItem>> {

        @Override
        protected List<ContactsItem> doInBackground(Void... voids) {
            return presenter.getContacts();
        }

        @Override
        protected void onPostExecute(List<ContactsItem> contactsItems) {
            contactsListAdapter.submitList(contactsItems);
        }
    }


    @Override
    public void onDestroyView() {
        async.cancel(true);
        presenter.onDetach();
        super.onDestroyView();
    }
}
