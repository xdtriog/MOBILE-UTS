package com.example.mobileutskevindinata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TouristSpotAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Mengambil data dari strings.xml
        String[] names = getResources().getStringArray(R.array.tourist_spots_names);
        String[] locations = getResources().getStringArray(R.array.tourist_spots_locations);
        String[] descriptions = getResources().getStringArray(R.array.tourist_spots_descriptions);
        // Ambil data gambar dari drawablee
        int[] images = new int[] {
                R.drawable.borobudur,R.drawable.raja_ampat, R.drawable.tana_toraja,
                R.drawable.danau_toba, R.drawable.bromo, R.drawable.komodo, R.drawable.parangtritis,
                R.drawable.kawah_ijen, R.drawable.wakatobi, R.drawable.belitung, R.drawable.bunaken,
                R.drawable.kepulauan_seribu, R.drawable.lombok, R.drawable.tanjung_tinggi, R.drawable.pulau_weh,
                R.drawable.goa_gong, R.drawable.prambanan, R.drawable.kuta, R.drawable.labuan_bajo,
                R.drawable.dieng, R.drawable.tmii, R.drawable.pink_beach, R.drawable.rinjani
        };

        // Membuat list dari data yang ada
        List<TouristSpot> touristSpots = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            touristSpots.add(new TouristSpot(names[i], locations[i], images[i], descriptions[i]));
        }

        // Set adapter untuk RecyclerView
        adapter = new TouristSpotAdapter(touristSpots, touristSpot -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("name", touristSpot.getName());
            intent.putExtra("location", touristSpot.getLocation());
            intent.putExtra("image", touristSpot.getImage());
            intent.putExtra("description", touristSpot.getDescription());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }
}
