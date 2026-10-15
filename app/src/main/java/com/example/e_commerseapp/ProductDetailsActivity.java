
package com.example.e_commerseapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        ImageView productImage = findViewById(R.id.productImage);
        TextView productName = findViewById(R.id.productName);
        TextView productPrice = findViewById(R.id.productPrice);
        Button addToCartButton = findViewById(R.id.addToCartButton);

        String name = getIntent().getStringExtra("productName");
        String price = getIntent().getStringExtra("productPrice");
        int image = getIntent().getIntExtra(
                "productImage", R.drawable.mens_sports_shoe);

        if (name != null) {
            productName.setText(name);
        }

        if (price != null) {
            productPrice.setText(price);
        }

        productImage.setImageResource(image);


        addToCartButton.setOnClickListener(v -> {
            CartActivity.addToCart(name, price, image);

            Intent intent = new Intent(
                    ProductDetailsActivity.this,
                    CartActivity.class
            );

            startActivity(intent);
        });
    }
}
