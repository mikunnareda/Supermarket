package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editSupermarketName, editSupermarketAddress;
    private Button buttonSave, buttonRate;
    //private static final int RATING_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editSupermarketName = findViewById(R.id.editSupermarketName);
        editSupermarketAddress = findViewById(R.id.editSupermarketAddress);
        buttonSave = findViewById(R.id.buttonSave);
        buttonRate = findViewById(R.id.buttonRate);

        buttonSave.setOnClickListener(view -> saveSupermarketInfo());
        buttonRate.setOnClickListener(view -> openRatingActivity());
    }
    private void saveSupermarketInfo(){
    }
    private void openRatingActivity() {
        Intent intent = new Intent(MainActivity.this, Rating.class);
        startActivity(intent);}
}