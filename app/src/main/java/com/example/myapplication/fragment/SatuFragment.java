package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class SatuFragment extends Fragment {

    private EditText etNamaUsaha;
    private CheckBox cbSoto, cbPecel, cbRames;
    private ToggleButton statusUsaha;
    private Switch statusPromo;
    private RadioGroup kategoriUsaha;
    private TimePicker waktuBuka;
    private DatePicker waktuPromoUtama;
    private Button btnOk;
    private TextView tvReview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_satu, container, false);

        // Inisialisasi komponen berdasarkan ID di fragment_satu.xml
        etNamaUsaha = view.findViewById(R.id.etNamaUsaha);
        cbSoto = view.findViewById(R.id.cbSoto);
        cbPecel = view.findViewById(R.id.cbPecel);
        cbRames = view.findViewById(R.id.cbRames);
        statusUsaha = view.findViewById(R.id.status_usaha);
        statusPromo = view.findViewById(R.id.status_promo);
        kategoriUsaha = view.findViewById(R.id.kategori_usaha);
        waktuBuka = view.findViewById(R.id.waktu_buka);
        waktuPromoUtama = view.findViewById(R.id.waktu_promo_utama);
        btnOk = view.findViewById(R.id.btnOk);
        tvReview = view.findViewById(R.id.tvReview);

        // Aksi ketika tombol OK diklik untuk menampilkan hasil ke tvReview
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Ambil Nama Usaha
                String namaUsaha = etNamaUsaha.getText().toString().trim();

                // 2. Ambil Menu Makanan yang dicentang
                StringBuilder menuMakanan = new StringBuilder();
                if (cbSoto.isChecked()) menuMakanan.append("Soto Ayam, ");
                if (cbPecel.isChecked()) menuMakanan.append("Nasi Pecel, ");
                if (cbRames.isChecked()) menuMakanan.append("Nasi Rames, ");

                String menuStr = menuMakanan.length() > 0 ? menuMakanan.substring(0, menuMakanan.length() - 2) : "-";

                // 3. Ambil Status Usaha
                String statusU = statusUsaha.isChecked() ? "AKTIF" : "TIDAK AKTIF";

                // 4. Ambil Status Promo
                String statusP = statusPromo.isChecked() ? "Promo" : "Tidak Ada Promo";

                // 5. Ambil Kategori Usaha yang dipilih
                String kategori = "Belum dipilih";
                int selectedId = kategoriUsaha.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton rbSelected = view.findViewById(selectedId);
                    kategori = rbSelected.getText().toString();
                }

                // 6. Ambil Waktu Buka dari TimePicker
                int jam = waktuBuka.getHour();
                int menit = waktuBuka.getMinute();
                String waktuBukaStr = String.format("%02d:%02d", jam, menit);

                // 7. Ambil Tanggal dari DatePicker
                int tahun = waktuPromoUtama.getYear();
                int bulan = waktuPromoUtama.getMonth() + 1;
                int hari = waktuPromoUtama.getDayOfMonth();
                String tanggalPromoStr = hari + "/" + bulan + "/" + tahun;

                // 8. Tampilkan semua data ke TextView Review
                String hasilReview = "Nama Usaha Anda : " + (namaUsaha.isEmpty() ? "-" : namaUsaha) + "\n" +
                        "Menu Masakan : " + menuStr + "\n" +
                        "Status Usaha : " + statusU + "\n" +
                        "Status Promo : " + statusP + "\n" +
                        "Kategori Usaha : " + kategori + "\n" +
                        "Waktu Buka : " + waktuBukaStr + "\n" +
                        "Waktu Promo Utama : " + tanggalPromoStr;

                tvReview.setText(hasilReview);
            }
        });

        return view;
    }
}