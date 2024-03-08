package com.example.parcelableassignment_deecruz;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class GroceryItem implements Parcelable {
    private int myImageResource;
    private String myText1;
    private String myText2;

    public GroceryItem(int imageResource, String text1, String text2){
        myImageResource = imageResource;
        myText1 = text1;
        myText2 = text2;
    }

    protected GroceryItem(Parcel in) {
        myImageResource = in.readInt();
        myText1 = in.readString();
        myText2 = in.readString();
    }

    public static final Creator<GroceryItem> CREATOR = new Creator<GroceryItem>() {
        @Override
        public GroceryItem createFromParcel(Parcel in) {
            return new GroceryItem(in);
        }

        @Override
        public GroceryItem[] newArray(int size) {
            return new GroceryItem[size];
        }
    };

    public void changeText1(String text){
        myText1 = text;
    }

    public int getImageResource(){
        return myImageResource;
    }

    public String getText1(){

        return myText1;
    }

    public String getText2(){

        return myText2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(myImageResource);
        parcel.writeString(myText1);
        parcel.writeString(myText2);
    }
}
