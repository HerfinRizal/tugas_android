package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textIntent;
    Button btnInten; //
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        // Implementasi Intent untuk Tombol OK (Dashboard)
        btnInten = findViewById(R.id.dashboard);
        btnInten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Berpindah dari MainActivity menuju DashboardActivity
                intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        // (Opsional) Kode untuk Lupa Password sebelumnya
        textIntent = findViewById(R.id.lupaPassword);
        textIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, LupaPasswordActivity.class);
                intent.putExtra("massage", "Ini adalah efek dari ekplisit intent");
                startActivity(intent);
            }
        });
    }
}
