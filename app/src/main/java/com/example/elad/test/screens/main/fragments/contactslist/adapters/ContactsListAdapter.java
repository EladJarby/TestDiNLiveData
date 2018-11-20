package com.example.elad.test.screens.main.fragments.contactslist.adapters;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elad.test.R;
import com.example.elad.test.data.model.ContactsItem;
import com.example.elad.test.screens.main.fragments.contactslist.ContactsListCallback;

public class ContactsListAdapter extends ListAdapter<ContactsItem,ContactsListAdapter.ViewHolder> {

    public ContactsListAdapter(@NonNull DiffUtil.ItemCallback<ContactsItem> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(inflater.inflate(R.layout.contacts_list_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ContactsItem item = getItem(i);
        viewHolder.phone.setText(item.getPhone().getMobile());
        viewHolder.name.setText(item.getName());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView phone;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phone = itemView.findViewById(R.id.contact_phone);
            name = itemView.findViewById(R.id.contact_name);
        }
    }
}
