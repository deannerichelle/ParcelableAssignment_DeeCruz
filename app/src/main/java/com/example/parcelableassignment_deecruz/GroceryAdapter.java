package com.example.parcelableassignment_deecruz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {
    private ArrayList<GroceryItem> myExampleList;

   private OnItemClickListener myListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        myListener = listener;
    }
    public static class GroceryViewHolder extends RecyclerView.ViewHolder{
        public ImageView myImageView;
        public TextView myTextView1;
        public TextView myTextView2;

        public GroceryViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            myImageView = itemView.findViewById(R.id.imageView);
            myTextView1 = itemView.findViewById(R.id.textView);
            myTextView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public GroceryAdapter(ArrayList<GroceryItem> exampleList){
        myExampleList = exampleList;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        GroceryViewHolder myEvh = new GroceryViewHolder(view, myListener);
        return myEvh;
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        GroceryItem currentItem = myExampleList.get(position);

        holder.myImageView.setImageResource(currentItem.getImageResource());
        holder.myTextView1.setText(currentItem.getText1());
        holder.myTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return myExampleList.size();
    }
}
