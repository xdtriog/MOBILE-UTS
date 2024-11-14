package com.example.mobileutskevindinata;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DetailPopupFragment extends DialogFragment {

    private String name;
    private String location;
    private String description;
    private int imageResId;

    public DetailPopupFragment(String name, String location, String description, int imageResId) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.imageResId = imageResId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_popup_detail, container, false);

        // Referensi elemen UI
        ImageView imageView = view.findViewById(R.id.image);
        TextView nameTextView = view.findViewById(R.id.name);
        TextView locationTextView = view.findViewById(R.id.location);
        TextView descriptionTextView = view.findViewById(R.id.description);
        Button closeButton = view.findViewById(R.id.close_button);

        // Set data ke elemen UI
        imageView.setImageResource(imageResId);
        nameTextView.setText(name);
        locationTextView.setText(location);
        descriptionTextView.setText(description);

        // Handle tombol tutup
        closeButton.setOnClickListener(v -> dismiss());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Mengatur ukuran popup dengan margin di kiri dan kanan
        if (getDialog() != null && getDialog().getWindow() != null) {
            DisplayMetrics metrics = new DisplayMetrics();
            requireActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

            int dialogWidth = (int) (metrics.widthPixels * 0.9); // 90% dari lebar layar
            getDialog().getWindow().setLayout(
                    dialogWidth,
                    WindowManager.LayoutParams.WRAP_CONTENT
            );
        }
    }

    @Override
    public int getTheme() {
        return R.style.DialogTheme;
    }
}
