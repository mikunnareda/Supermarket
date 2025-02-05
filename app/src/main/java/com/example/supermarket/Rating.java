package com.example.supermarket;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Rating extends AppCompatActivity {
    private RatingBar ratingLiquor, ratingProduce, ratingMeat, ratingCheese, ratingCheckout;
    private Button buttonSaveRating, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rating);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ratingLiquor = findViewById(R.id.ratingLiquor);
        ratingProduce = findViewById(R.id.ratingProduce);
        ratingMeat = findViewById(R.id.ratingMeat);
        ratingCheese = findViewById(R.id.ratingCheese);
        ratingCheckout = findViewById(R.id.ratingCheckout);

        buttonSaveRating = findViewById(R.id.buttonSaveRating);
        buttonBack = findViewById(R.id.buttonBack);

        buttonSaveRating.setOnClickListener(view -> saveRatings());
        buttonBack.setOnClickListener(view -> finish());
    }

    private void saveRatings() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putFloat("LiquorRating", ratingLiquor.getRating());
        editor.putFloat("ProduceRating", ratingProduce.getRating());
        editor.putFloat("MeatRating", ratingMeat.getRating());
        editor.putFloat("CheeseRating", ratingCheese.getRating());
        editor.putFloat("CheckoutRating", ratingCheckout.getRating());

        editor.apply();
    }
}