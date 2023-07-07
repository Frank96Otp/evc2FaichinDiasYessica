package com.example.evc2_yessicafaichin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.evc2_yessicafaichin.databinding.ActivityFloatingActionButtomBinding;
import com.example.evc2_yessicafaichin.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class FloatingActionButtomActivity extends AppCompatActivity {

    private ActivityFloatingActionButtomBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFloatingActionButtomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fabBar.setOnClickListener(view -> {

            Snackbar.make(binding.getRoot(),"Evc2 19",Snackbar.LENGTH_SHORT).show();
        });
    }
}