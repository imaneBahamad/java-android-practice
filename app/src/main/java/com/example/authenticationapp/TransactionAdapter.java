package com.example.authenticationapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TransactionAdapter extends ArrayAdapter <Transaction> {
    private List<Transaction> transactions;
    public TransactionAdapter(Context context, int resource, List<Transaction> transactions) {
        super(context, resource,transactions);
        this.transactions=transactions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("imane","pos ="+position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_list_content,parent,false);
        View intermediateView = inflater.inflate(R.layout.activity_show_transaction,parent,false);

        TextView accountView = (TextView) intermediateView.findViewById(R.id.show_account);
        TextView referenceView = (TextView) intermediateView.findViewById(R.id.show_reference);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.list_content_img);
        TextView titleView = (TextView) convertView.findViewById(R.id.list_content_text);
        TextView descriptionView = (TextView) intermediateView.findViewById(R.id.show_description);
        TextView amountView = (TextView) convertView.findViewById(R.id.list_content_amount);
        TextView dateOperationView = (TextView) convertView.findViewById(R.id.list_content_date);
        TextView dateValidityView = (TextView) intermediateView.findViewById(R.id.show_date_validity);

        accountView.setText(transactions.get(position).getAccount_number()+"");
        referenceView.setText(transactions.get(position).getReference()+"");
        imageView.setBackgroundResource(transactions.get(position).getImageID());
        titleView.setText(transactions.get(position).getTitle());
        descriptionView.setText(transactions.get(position).getDescription());
        amountView.setText(transactions.get(position).getAmount());
        dateOperationView.setText(transactions.get(position).getDate_operation());
        dateValidityView.setText(transactions.get(position).getDate_validity());

        return convertView;    }
}
