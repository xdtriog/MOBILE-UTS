package com.example.mobileutskevindinata;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    private int[] images; // Array gambar
    private String[] names; // Array nama tempat
    private Context context;

    public SliderAdapter(int[] images, String[] names) {
        this.images = images;
        this.names = names;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.slider_item, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.bind(images[position], names[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.slider_image);
            textView = itemView.findViewById(R.id.slider_text);
        }

        public void bind(int imageRes, String name) {
            // Set image resource
            imageView.setImageResource(imageRes);

            // Apply blur effect (simulate with dark overlay)
            imageView.setColorFilter(Color.argb(150, 0, 0, 0));

            // Set place name text
            textView.setText(name);
        }
    }
}
