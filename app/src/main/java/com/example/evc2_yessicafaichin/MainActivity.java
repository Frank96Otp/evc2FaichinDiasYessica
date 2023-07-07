package com.example.evc2_yessicafaichin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;

import android.widget.Toast;

import com.example.evc2_yessicafaichin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogi.setOnClickListener(view -> {

            String id = binding.tilEmail.getEditText().getText().toString();
            String contra = binding.tilPassword.getEditText().getText().toString();

            if(validation(id,contra)){
                Intent intent = new Intent(this, FloatingActionButtomActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this,"Id o contraseña incorrecta", Toast.LENGTH_LONG).show();
            }

        });

        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                boolean isok= isCredentialsValidate(s.toString(), binding.tilPassword.getEditText().getText().toString());
                binding.btnLogi.setEnabled(isok);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.tilPassword.getEditText().addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                boolean isok = isCredentialsValidate(binding.tilEmail.getEditText().getText().toString(), s.toString());
                binding.btnLogi.setEnabled(isok);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private boolean validation(String id, String contra) {

        if(id.equalsIgnoreCase("ejemplo@idat.com.pe") && contra.equalsIgnoreCase("idat1234")){
            System.out.println("mensaje verdadero");
            return true;
        }else{
            System.out.println("mensaje FASLSSOOO");
            return false;
        }

    }

    private boolean isCredentialsValidate(String email, String password){

        boolean isEmailOk = !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        boolean isPaswwordOk = password.length() <= 8;
        return isEmailOk && isPaswwordOk;
    }
}