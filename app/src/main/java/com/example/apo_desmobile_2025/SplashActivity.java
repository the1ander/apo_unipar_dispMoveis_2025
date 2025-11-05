package com.example.apo_desmobile_2025;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    // Tempo de exibição da Splash Screen em milissegundos (3 segundos )
    private static final int TEMPO_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Usando Handler para iniciar a MainActivity após o tempo definido
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Cria uma Intent para iniciar a MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                // Fecha a SplashActivity para que o usuário não possa voltar a ela
                finish();
            }
        }, TEMPO_SPLASH);
    }
}