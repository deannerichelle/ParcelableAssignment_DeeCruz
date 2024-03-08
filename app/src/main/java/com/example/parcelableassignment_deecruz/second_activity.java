package com.example.parcelableassignment_deecruz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class second_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        GroceryItem groceryItem = intent.getParcelableExtra("Grocery Item");

        int imgRes = groceryItem.getImageResource();
        String item1 = groceryItem.getText1();
        String item2 = groceryItem.getText2();

        ImageView imageView = findViewById(R.id.imgView_act2);
        imageView.setImageResource(imgRes);

        TextView tv1 = findViewById(R.id.tv1_act2);
        tv1.setText(item1);

        TextView tv2 = findViewById(R.id.tv2_act2);
        tv2.setText(item2);
    }
}