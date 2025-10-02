package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import setting.setting;


public class MainActivity extends AppCompatActivity {

    Button button_overSpeed, button_statistics, button_userGuide, button_settings;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);
        // จัดการ padding ด้านบน (status bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.MainActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });

        // จัดการ marginBottom ของ BottomNavigationView
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bottomNavigationView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.bottomMargin = systemBars.bottom;
            v.setLayoutParams(params);
            return insets;
        });

        // BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_main);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.bottom_main:
                    return true;
                case R.id.bottom_speed:
                    startActivity(new Intent(getApplicationContext(), Overspeed.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    return true;
                case R.id.bottom_statistics:
                    startActivity(new Intent(getApplicationContext(), Statistics.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    return true;
                case R.id.bottom_guide:
                    startActivity(new Intent(getApplicationContext(), User_Guide.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    return true;
                case R.id.bottom_setting:
                    startActivity(new Intent(getApplicationContext(), setting.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    return true;
            }
            return false;
        });

        // ปุ่มใน CardView
        button_overSpeed = findViewById(R.id.button_overSpeed);
        button_overSpeed.setOnClickListener(v -> {
            Intent overSpeeds = new Intent(MainActivity.this, Overspeed.class);
            startActivity(overSpeeds);
        });

        button_statistics = findViewById(R.id.button_statistics);
        button_statistics.setOnClickListener(v -> {
            Intent statistic = new Intent(MainActivity.this, Statistics.class);
            startActivity(statistic);
        });

        button_userGuide = findViewById(R.id.button_userGuide);
        button_userGuide.setOnClickListener(v -> {
            Intent userGuides = new Intent(MainActivity.this, User_Guide.class);
            startActivity(userGuides);
        });

        button_settings = findViewById(R.id.button_settings);
        button_settings.setOnClickListener(v -> {
            Intent settings = new Intent(MainActivity.this, setting.class);
            startActivity(settings);
        });
    }
}
