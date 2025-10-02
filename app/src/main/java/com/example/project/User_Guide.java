package com.example.project;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import setting.setting;

public class User_Guide extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    TextView textViewalert ;
    AlertDialog.Builder alert ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_user_guide);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
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
        bottomNavigationView.setSelectedItemId(R.id.bottom_guide);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.bottom_main:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
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
                    return true;
                case R.id.bottom_setting:
                    startActivity(new Intent(getApplicationContext(), setting.class));
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    finish();
                    return true;
            }
            return false;
        });








        alert = new AlertDialog.Builder(this);
        textViewalert = findViewById(R.id.textView2);
        textViewalert.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                alert.setTitle("What Are You Touch???");
                alert.setMessage("Touch >_<");
                alert.setCancelable(true);
                alert.show();
                return false;
            }
        });

    }
}