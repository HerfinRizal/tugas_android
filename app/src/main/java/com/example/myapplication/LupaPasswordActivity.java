package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LupaPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        // Menerima data dari Intent sebelumnya (jika masih digunakan)
        String pesan = getIntent().getStringExtra("massage");
        if (pesan != null) {
            Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
        }

        // 1. Hubungkan TextView "Tidak bisa mengatur ulang kata sandi anda?"
        TextView aturUlang = findViewById(R.id.aturUlangPassword);

        // 2. Berikan fungsi klik untuk Intent Implisit menuju situs web
        aturUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent Implisit dengan aksi VIEW dan URI situs web
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.its.ac.id"));
                startActivity(intent);
            }
        });
    }
}
