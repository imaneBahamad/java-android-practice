package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.transaction_list)
    ListView list;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("imane","Start");
        List<Transaction> transactionList = new ArrayList<Transaction>();

        transactionList.add(new Transaction(R.drawable.ic_launcher_background,"My first transaction","100 DHS", "16/11/2020",
                123456,111111,"21/11/2020","My first transaction description :D"));
        transactionList.add(new Transaction(R.drawable.ic_launcher_background,"My second transaction","1000 DHS", "16/11/2020"
                , 123456,222222,"21/11/2020","My second transaction description :D"));
        transactionList.add(new Transaction(R.drawable.ic_launcher_background,"My third transaction","250 DHS", "16/11/2020"
                , 123456,333333,"21/11/2020","My third transaction description :D"));

        TransactionAdapter transactionAdapter = new TransactionAdapter(getApplicationContext(),R.layout.activity_list_content,transactionList);

        list.setAdapter(transactionAdapter);
        Log.d("imane","End");
    }

    @OnItemClick(R.id.transaction_list)
    public void showTransactionDetails(int position){
        intent = new Intent().setClass(this,ShowTransactionActivity.class);
        intent.putExtra("myTransaction",(Transaction) list.getAdapter().getItem(position));
        startActivity(intent);
    }
}