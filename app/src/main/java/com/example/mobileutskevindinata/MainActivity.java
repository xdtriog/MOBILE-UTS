package com.example.mobileutskevindinata;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 sliderView;
    private RecyclerView recyclerView;
    private TouristSpotAdapter adapter;
    private EditText searchBar;
    private Handler sliderHandler = new Handler();

    private List<TouristSpot> allTouristSpots = new ArrayList<>();
    private List<TouristSpot> filteredTouristSpots = new ArrayList<>();

    private int[] sliderImages = {
            R.drawable.borobudur, R.drawable.raja_ampat, R.drawable.tana_toraja,
            R.drawable.danau_toba, R.drawable.bromo, R.drawable.komodo,
            R.drawable.parangtritis, R.drawable.kawah_ijen, R.drawable.wakatobi
    };

    private String[] sliderNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        sliderView = findViewById(R.id.slider_view);
        recyclerView = findViewById(R.id.recycler_view);
        searchBar = findViewById(R.id.search_bar);

        // Load data from resources
        String[] names = getResources().getStringArray(R.array.tourist_spots_names);
        String[] locations = getResources().getStringArray(R.array.tourist_spots_locations);
        String[] descriptions = getResources().getStringArray(R.array.tourist_spots_descriptions);
        sliderNames = getResources().getStringArray(R.array.tourist_spots_names);

        int[] images = {
                R.drawable.borobudur, R.drawable.raja_ampat, R.drawable.tana_toraja,
                R.drawable.danau_toba, R.drawable.bromo, R.drawable.komodo,
                R.drawable.parangtritis, R.drawable.kawah_ijen, R.drawable.wakatobi,
                R.drawable.belitung, R.drawable.bunaken, R.drawable.kepulauan_seribu,
                R.drawable.lombok, R.drawable.tanjung_tinggi, R.drawable.pulau_weh,
                R.drawable.goa_gong, R.drawable.prambanan, R.drawable.kuta,
                R.drawable.labuan_bajo, R.drawable.dieng, R.drawable.tmii,
                R.drawable.pink_beach, R.drawable.rinjani
        };

        // Populate data into the list
        for (int i = 0; i < names.length; i++) {
            allTouristSpots.add(new TouristSpot(names[i], locations[i], images[i], descriptions[i]));
        }

        // Initially, show all data
        filteredTouristSpots.addAll(allTouristSpots);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TouristSpotAdapter(this, filteredTouristSpots);
        recyclerView.setAdapter(adapter);

        // Setup slider
        sliderView.setAdapter(new SliderAdapter(sliderImages, sliderNames));
        sliderView.setPageTransformer(new FadePageTransformer());
        sliderView.setOffscreenPageLimit(1); // Render only 1 page at a time
        autoSlideImages();

        // Setup search bar listener
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterResults(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Handle item click in RecyclerView
        adapter.setOnItemClickListener(touristSpot -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("name", touristSpot.getName());
            intent.putExtra("location", touristSpot.getLocation());
            intent.putExtra("image", touristSpot.getImage());
            intent.putExtra("description", touristSpot.getDescription());
            startActivity(intent);
        });
    }

    private void autoSlideImages() {
        sliderHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentItem = sliderView.getCurrentItem();
                sliderView.setCurrentItem((currentItem + 1) % sliderImages.length, true); // Smooth scroll
                sliderHandler.postDelayed(this, 5000); // Delay of 5 seconds
            }
        }, 5000);
    }

    private void filterResults(String query) {
        filteredTouristSpots.clear();
        for (TouristSpot spot : allTouristSpots) {
            if (spot.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredTouristSpots.add(spot);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sliderHandler.removeCallbacksAndMessages(null);
    }
}
