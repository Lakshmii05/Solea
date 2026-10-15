package com.example.e_commerseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.e_commerseapp.CartActivity;
import com.example.e_commerseapp.ProductDetailsActivity;

public class MainActivity extends AppCompatActivity {

    EditText searchEditText;
    Button searchButton;
    ImageButton cartButton;

    LinearLayout sportsShoeCard;
    LinearLayout casualShoeCard;
    LinearLayout runningShoeCard;

    LinearLayout womenSportsShoeCard;
    LinearLayout womenCasualShoeCard;
    LinearLayout womenRunningShoeCard;
    LinearLayout horizontalMenShoe;
    LinearLayout horizontalWomenShoe;
    LinearLayout horizontalCasualShoe;

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

        womenSportsShoeCard = findViewById(R.id.sportShoeCard);
        womenCasualShoeCard = findViewById(R.id.casual_ShoeCard);
        womenRunningShoeCard = findViewById(R.id.running_ShoeCard);

        horizontalMenShoe = findViewById(R.id.horizontalMenShoe);
        horizontalWomenShoe = findViewById(R.id.horizontalWomenShoe);
        horizontalCasualShoe = findViewById(R.id.horizontalCasualShoe);

        // Men's shoes
        sportsShoeCard.setOnClickListener(v ->
                openProduct("Men's Sports Shoe", "₹1,499",
                        R.drawable.mens_sports_shoe));

        casualShoeCard.setOnClickListener(v ->
                openProduct("Men's Casual Shoe", "₹1,299",
                        R.drawable.mens_casual_shoe));

        runningShoeCard.setOnClickListener(v ->
                openProduct("Men's Running Shoe", "₹1,799",
                        R.drawable.mens_running_shoe));

        // Women's shoes
        womenSportsShoeCard.setOnClickListener(v ->
                openProduct("Women's Sports Shoe", "₹1,499",
                        R.drawable.womens_sports_shoe));

        womenCasualShoeCard.setOnClickListener(v ->
                openProduct("Women's Casual Shoe", "₹1,299",
                        R.drawable.womens_casuals));

        womenRunningShoeCard.setOnClickListener(v ->
                openProduct("Women's Running Shoe", "₹1,799",
                        R.drawable.womens_running));

        horizontalMenShoe.setOnClickListener(v ->
                openProduct("Men's Sports Shoe", "₹1,499",
                        R.drawable.mens_sports_shoe));

        horizontalWomenShoe.setOnClickListener(v ->
                openProduct("Women's Sports Shoe", "₹1,499",
                        R.drawable.womens_sports_shoe));

        horizontalCasualShoe.setOnClickListener(v ->
                openProduct("Men's Casual Shoe", "₹1,299",
                        R.drawable.mens_casual_shoe));

        // Search shoes
        searchButton.setOnClickListener(v -> {
            String searchText = searchEditText.getText()
                    .toString().trim().toLowerCase();

            if (searchText.isEmpty()) {
                Toast.makeText(this, "Please enter a shoe name",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            boolean men = searchText.contains("men")
                    || searchText.equals("mens");

            boolean women = searchText.contains("women")
                    || searchText.equals("womens");

            boolean sports = searchText.contains("sports")
                    || searchText.contains("sport");

            boolean casual = searchText.contains("casual");

            boolean running = searchText.contains("running");

            boolean allTypes = !sports && !casual && !running;
            boolean allGenders = !men && !women;

            sportsShoeCard.setVisibility(
                    (allGenders || men) && (allTypes || sports)
                            ? View.VISIBLE : View.GONE);

            casualShoeCard.setVisibility(
                    (allGenders || men) && (allTypes || casual)
                            ? View.VISIBLE : View.GONE);

            runningShoeCard.setVisibility(
                    (allGenders || men) && (allTypes || running)
                            ? View.VISIBLE : View.GONE);

            womenSportsShoeCard.setVisibility(
                    (allGenders || women) && (allTypes || sports)
                            ? View.VISIBLE : View.GONE);

            womenCasualShoeCard.setVisibility(
                    (allGenders || women) && (allTypes || casual)
                            ? View.VISIBLE : View.GONE);

            womenRunningShoeCard.setVisibility(
                    (allGenders || women) && (allTypes || running)
                            ? View.VISIBLE : View.GONE);

            if (!men && !women && !sports && !casual && !running) {
                sportsShoeCard.setVisibility(View.GONE);
                casualShoeCard.setVisibility(View.GONE);
                runningShoeCard.setVisibility(View.GONE);
                womenSportsShoeCard.setVisibility(View.GONE);
                womenCasualShoeCard.setVisibility(View.GONE);
                womenRunningShoeCard.setVisibility(View.GONE);

                Toast.makeText(this, "No matching shoe found",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Open cart
        cartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,
                    CartActivity.class);
            startActivity(intent);
        });
    }

    private void openProduct(String name, String price, int image) {
        Intent intent = new Intent(MainActivity.this,
                ProductDetailsActivity.class);

        intent.putExtra("productName", name);
        intent.putExtra("productPrice", price);
        intent.putExtra("productImage", image);

        startActivity(intent);
    }
}
