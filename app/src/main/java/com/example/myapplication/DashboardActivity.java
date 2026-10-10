package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.fragment.DuaFragment;
import com.example.myapplication.fragment.EmpatFragment;
import com.example.myapplication.fragment.SatuFragment;
import com.example.myapplication.fragment.TigaFragment;

public class DashboardActivity extends AppCompatActivity {

    Button btnFrg1, btnFrg2, btnFrg3, btnFrg4;
    FrameLayout frlDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        frlDashboard = findViewById(R.id.frl_dashboard);
        btnFrg1 = findViewById(R.id.btn_frg1);
        btnFrg2 = findViewById(R.id.btn_frg2);
        btnFrg3 = findViewById(R.id.btn_frg3);
        btnFrg4 = findViewById(R.id.btn_frg4);

        // Default tampilkan SatuFragment saat pertama buka
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frl_dashboard, new SatuFragment())
                    .commit();
        }

        btnFrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frl_dashboard, new SatuFragment())
                        .commit();
            }
        });

        btnFrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frl_dashboard, new DuaFragment())
                        .commit();
            }
        });

        btnFrg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frl_dashboard, new TigaFragment())
                        .commit();
            }
        });

        btnFrg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frl_dashboard, new EmpatFragment())
                        .commit();
            }
        });
    }
}
