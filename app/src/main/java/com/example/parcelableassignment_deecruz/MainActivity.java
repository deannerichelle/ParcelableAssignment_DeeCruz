package com.example.parcelableassignment_deecruz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<GroceryItem> myGroceryList;
    private RecyclerView myRecyclerView;
    private GroceryAdapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGroceryList();
        buildRecyclerView();
    }

    public void createGroceryList(){
        myGroceryList = new ArrayList<>();
        myGroceryList.add(new GroceryItem(R.drawable.handsoap, "Item 1", "Item 2"));
        myGroceryList.add(new GroceryItem(R.drawable.food, "Item 3", "Item 4"));
        myGroceryList.add(new GroceryItem(R.drawable.baby_toy, "Item 5", "Item 6"));
    }

    public void buildRecyclerView(){
        myRecyclerView = findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true); //this increases the performance of our app
        myLayoutManager = new LinearLayoutManager(this);
        myAdapter = new GroceryAdapter(myGroceryList);

        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new GroceryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, second_activity.class);
                intent.putExtra("Grocery Item", myGroceryList.get(position));

                startActivity(intent);
            }
        });
    }
}