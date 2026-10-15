
package com.example.e_commerseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    public static ArrayList<CartItem> cartItems = new ArrayList<>();

    LinearLayout cartItemsContainer;
    TextView totalPriceTextView;
    Button checkoutButton;

    public static class CartItem {
        String name;
        String price;
        int image;

        public CartItem(String name, String price, int image) {
            this.name = name;
            this.price = price;
            this.image = image;
        }
    }

    public static void addToCart(String name, String price, int image) {
        cartItems.add(new CartItem(name, price, image));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItemsContainer = findViewById(R.id.cartItemsContainer);
        totalPriceTextView = findViewById(R.id.totalPriceTextView);
        checkoutButton = findViewById(R.id.checkoutButton);

        displayCart();

        checkoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    CartActivity.this,
                    CheckoutActivity.class
            );
            startActivity(intent);
        });
    }

    private void displayCart() {
        cartItemsContainer.removeAllViews();
        int total = 0;

        for (int i = 0; i < cartItems.size(); i++) {
            CartItem item = cartItems.get(i);

            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.VERTICAL);
            row.setPadding(12, 12, 12, 12);

            ImageView imageView = new ImageView(this);
            imageView.setImageResource(item.image);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            row.addView(imageView, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 180));

            TextView nameView = new TextView(this);
            nameView.setText(item.name);
            nameView.setTextSize(18);
            nameView.setTextColor(0xFF000000);
            row.addView(nameView);

            TextView priceView = new TextView(this);
            priceView.setText(item.price);
            priceView.setTextSize(16);
            priceView.setTextColor(0xFFFF9800);
            row.addView(priceView);

            Button removeButton = new Button(this);
            removeButton.setText("Remove");
            row.addView(removeButton);

            removeButton.setOnClickListener(v -> {
                cartItems.remove(item);
                displayCart();
            });

            cartItemsContainer.addView(row);

            String numbers = item.price.replaceAll("[^0-9]", "");
            total += Integer.parseInt(numbers);
        }

        totalPriceTextView.setText("Total: ₹" + total);

        if (cartItems.isEmpty()) {
            TextView emptyMessage = new TextView(this);
            emptyMessage.setText("Your cart is empty");
            emptyMessage.setTextSize(18);
            emptyMessage.setGravity(Gravity.CENTER);
            cartItemsContainer.addView(emptyMessage);
        }
    }
}
