package com.example.mobileutskevindinata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TouristSpotAdapter extends RecyclerView.Adapter<TouristSpotAdapter.ViewHolder> {

    private List<TouristSpot> touristSpots;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(TouristSpot touristSpot);
    }

    public TouristSpotAdapter(List<TouristSpot> touristSpots, OnItemClickListener listener) {
        this.touristSpots = touristSpots;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tourist_spot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TouristSpot touristSpot = touristSpots.get(position);
        holder.nameTextView.setText(touristSpot.getName());
        holder.locationTextView.setText(touristSpot.getLocation());
        holder.imageView.setImageResource(touristSpot.getImage());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(touristSpot));
    }

    @Override
    public int getItemCount() {
        return touristSpots.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView locationTextView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            locationTextView = itemView.findViewById(R.id.location);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
