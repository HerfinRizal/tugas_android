package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class DuaFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dua, container, false);
        Button btnOkRelative = rootView.findViewById(R.id.btnOkRelative);
        Button btnCancelRelative = rootView.findViewById(R.id.btnCancelRelative);

        if (btnOkRelative != null) {
            btnOkRelative.setOnClickListener(v -> Toast.makeText(getContext(), "OK Relative clicked", Toast.LENGTH_SHORT).show());
        }
        if (btnCancelRelative != null) {
            btnCancelRelative.setOnClickListener(v -> Toast.makeText(getContext(), "Cancel Relative clicked", Toast.LENGTH_SHORT).show());
        }
        return rootView;
    }
}
