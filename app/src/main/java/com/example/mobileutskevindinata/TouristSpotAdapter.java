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
    private Context context;

    // Interface untuk item click listener
    public interface OnItemClickListener {
        void onItemClick(TouristSpot touristSpot);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public TouristSpotAdapter(Context context, List<TouristSpot> touristSpots) {
        this.context = context;
        this.touristSpots = touristSpots;
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

        // Set OnClickListener untuk item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(touristSpot);
            }
        });
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
