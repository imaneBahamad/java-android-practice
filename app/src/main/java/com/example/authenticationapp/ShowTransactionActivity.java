package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowTransactionActivity extends AppCompatActivity {
    @BindView(R.id.show_account)
    TextView accountView;
    @BindView(R.id.show_reference)
    TextView referenceView;
    @BindView(R.id.show_img)
    ImageView imageView;
    @BindView(R.id.show_title)
    TextView titleView;
    @BindView(R.id.show_description)
    TextView descriptionView;
    @BindView(R.id.show_amount)
    TextView amountView;
    @BindView(R.id.show_date)
    TextView dateOperationView;
    @BindView(R.id.show_date_validity)
    TextView dateValidityView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_transaction);
        ButterKnife.bind(this);
        Transaction myTransaction = getIntent().getParcelableExtra("myTransaction");
        accountView.setText(myTransaction.getAccount_number()+"");
        referenceView.setText(myTransaction.getReference()+"");
        imageView.setBackgroundResource(myTransaction.getImageID());
        titleView.setText(myTransaction.getTitle());
        descriptionView.setText(myTransaction.getDescription());
        amountView.setText(myTransaction.getAmount());
        dateOperationView.setText(myTransaction.getDate_operation());
        dateValidityView.setText(myTransaction.getDate_validity());
    }
}