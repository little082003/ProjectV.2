package setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project.MainActivity;
import com.example.project.Overspeed;
import com.example.project.R;
import com.example.project.Statistics;
import com.example.project.User_Guide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Help_support extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_help_support);
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
        bottomNavigationView.setSelectedItemId(R.id.bottom_main);
        bottomNavigationView.setSelectedItemId(R.id.bottom_speed);
        bottomNavigationView.setSelectedItemId(R.id.bottom_statistics);
        bottomNavigationView.setSelectedItemId(R.id.bottom_main);
        bottomNavigationView.setSelectedItemId(R.id.bottom_speed);
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
    }
}