package com.example.evc2_yessicafaichin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
                // No se requiere ninguna acción durante los ticks del temporizador
            }

            public void onFinish() {
                // Aquí puedes cerrar la actividad del onboarding y pasar a la siguiente pantalla
                finish(); // Cierra la actividad actual

                // Agrega el código para iniciar la siguiente actividad
                Intent intent = new Intent(OnboardingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}