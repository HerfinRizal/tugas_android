package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// Import package fragment kamu
import com.example.myapplication.fragment.SatuFragment;
import com.example.myapplication.fragment.DuaFragment;

public class DashboardActivity extends AppCompatActivity {

    Button btnFrg1, btnFrg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // 1. Hubungkan tombol dengan ID di XML
        btnFrg1 = findViewById(R.id.btn_frg1);
        btnFrg2 = findViewById(R.id.btn_frg2);

        // 2. WAJIB ADA: Menampilkan Fragment 1 secara default saat halaman pertama kali dibuka
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frl_dashboard, new SatuFragment())
                    .commit();
        }

        // 3. Aksi ketika Tombol Fragment 1 diklik
        btnFrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frl_dashboard, new SatuFragment())
                        .commit();
            }
        });

        // 4. Aksi ketika Tombol Fragment 2 diklik
        btnFrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frl_dashboard, new DuaFragment())
                        .commit();
            }
        });
    }
}