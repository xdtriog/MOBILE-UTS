package com.example.mobileutskevindinata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class DetailActivity extends AppCompatActivity {

    private TextView nameTextView, locationTextView, descriptionTextView;
    private ImageView imageView;
    private Button backButton; // Tambahkan variabel untuk Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> onBackPressed());

        nameTextView = findViewById(R.id.name);
        locationTextView = findViewById(R.id.location);
        descriptionTextView = findViewById(R.id.description);
        imageView = findViewById(R.id.image);

        // Menerima data dari Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String location = intent.getStringExtra("location");
        String description = intent.getStringExtra("description");
        int image = intent.getIntExtra("image", -1);

        // Menampilkan data
        nameTextView.setText(name);
        locationTextView.setText(location);
        descriptionTextView.setText(description);
        imageView.setImageResource(image);
    }
}
