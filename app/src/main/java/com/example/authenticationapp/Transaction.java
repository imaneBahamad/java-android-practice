package com.example.authenticationapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaction implements Parcelable {
    private int imageID;
    private String title;
    private String amount;
    private String date_operation;
    private int account_number;
    private int reference;
    private String date_validity;
    private String description;

    public Transaction(int imageID, String title, String amount, String date_operation, int account_number, int reference, String date_validity, String description) {
        this.imageID = imageID;
        this.title = title;
        this.amount = amount;
        this.date_operation = date_operation;
        this.account_number = account_number;
        this.reference = reference;
        this.date_validity = date_validity;
        this.description = description;
    }

    protected Transaction(Parcel in) {
        imageID = in.readInt();
        title = in.readString();
        amount = in.readString();
        date_operation = in.readString();
        account_number = in.readInt();
        reference = in.readInt();
        date_validity = in.readString();
        description = in.readString();
    }

    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate_operation() {
        return date_operation;
    }

    public void setDate_operation(String date_operation) {
        this.date_operation = date_operation;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDate_validity() {
        return date_validity;
    }

    public void setDate_validity(String date_validity) {
        this.date_validity = date_validity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageID);
        dest.writeString(title);
        dest.writeString(amount);
        dest.writeString(date_operation);
        dest.writeInt(account_number);
        dest.writeInt(reference);
        dest.writeString(date_validity);
        dest.writeString(description);
    }
}
