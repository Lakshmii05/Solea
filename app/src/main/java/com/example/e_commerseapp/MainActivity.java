package com.example.e_commerseapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText searchEditText;
    Button searchButton;
    Button cartButton;
    LinearLayout sportsShoeCard;
    LinearLayout casualShoeCard;
    LinearLayout runningShoeCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        cartButton = findViewById(R.id.cartButton);
        sportsShoeCard = findViewById(R.id.sportsShoeCard);
        casualShoeCard = findViewById(R.id.casualShoeCard);
        runningShoeCard = findViewById(R.id.runningShoeCard);

        searchButton.setOnClickListener(v -> {

            String searchText = searchEditText.getText().toString();

            if (searchText.isEmpty()) {
                Toast.makeText(this, "Please enter a shoe name", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "You searched for: " + searchText, Toast.LENGTH_SHORT).show();
            }

        });

        sportsShoeCard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
            startActivity(intent);
        });

        casualShoeCard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
            startActivity(intent);
        });

        runningShoeCard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
            startActivity(intent);
        });

        cartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}