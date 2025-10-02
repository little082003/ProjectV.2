package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import setting.setting;

public class Statistics extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView speedText,motionText,freqercyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_statistics);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,0);
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
        bottomNavigationView.setSelectedItemId(R.id.bottom_statistics);
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

        speedText = findViewById(R.id.speed);
        motionText = findViewById(R.id.motion);
        freqercyText = findViewById(R.id.frequency);
        showAllHB100Data();








    }
    public void showAllHB100Data(){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("HB100");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Double speed = snapshot.child("Speed_kmh").getValue(Double.class);
                    Double frequency = snapshot.child("Frequency").getValue(Double.class);
                    Boolean motionDetected = snapshot.child("MotionDetected").getValue(Boolean.class);


                    // แสดงผลใน TextView
                    speedText.setText(speed + " km/h");
                    freqercyText.setText(frequency + " Hz");
                    motionText.setText(motionDetected != null && motionDetected ? "Detected" : "No Detected!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                speedText.setText("Error");
                motionText.setText("Error");
                freqercyText.setText("Error");
            }
        });



    }

}
