
package com.example.e_commerseapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button placeOrderButton = findViewById(R.id.placeOrderButton);

        placeOrderButton.setOnClickListener(v -> {
            Toast.makeText(
                    CheckoutActivity.this,
                    "Order placed successfully",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}
