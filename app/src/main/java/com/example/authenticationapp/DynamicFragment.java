package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class DynamicFragment extends Fragment {
    @BindView(R.id.transaction_list)
    ListView list;

    Intent intent;

    public DynamicFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DynamicFragment newInstance(String param1, String param2) {
        DynamicFragment fragment = new DynamicFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_dynamic, container, false);
        ButterKnife.bind(this,myView);

        Log.d("imane","Start");
        List<Transaction> transactionList = new ArrayList<Transaction>();

        transactionList.add(new Transaction(R.drawable.ic_launcher_background,"My first transaction","100 DHS", "16/11/2020",
                123456,111111,"21/11/2020","My first transaction description :D"));
        transactionList.add(new Transaction(R.drawable.ic_launcher_background,"My second transaction","1000 DHS", "16/11/2020"
                , 123456,222222,"21/11/2020","My second transaction description :D"));
        transactionList.add(new Transaction(R.drawable.ic_launcher_background,"My third transaction","250 DHS", "16/11/2020"
                , 123456,333333,"21/11/2020","My third transaction description :D"));

        TransactionAdapter transactionAdapter = new TransactionAdapter(container.getContext(),R.layout.activity_list_content,transactionList);
        list.setAdapter(transactionAdapter);
        Log.d("imane","End");

        return myView;
    }

    @OnItemClick(R.id.transaction_list)
    public void showTransactionDetails(int position){
        intent = new Intent().setClass(this.getContext(),ShowTransactionActivity.class);
        intent.putExtra("myTransaction",(Transaction) list.getAdapter().getItem(position));
        startActivity(intent);
    }
}