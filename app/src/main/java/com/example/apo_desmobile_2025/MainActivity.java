package com.example.apo_desmobile_2025;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager2.widget.ViewPager2;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define o layout principal que agora contém o TabLayout e ViewPager2
        setContentView(R.layout.activity_main);

        // Configura a Toolbar (Barra de Ação)
        setSupportActionBar(findViewById(R.id.toolbar));

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        // 1. Cria o Adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // 2. Vincula o TabLayout ao ViewPager2
        // Isso garante que ao deslizar o ViewPager, a aba correta seja selecionada, e vice-versa.
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getTabTitle(position))
        ).attach();

        // O FAB (Floating Action Button) será configurado na Etapa 6
    }

    // O metodo onCreateOptionsMenu e onOptionsItemSelected (para o menu)
    // será configurado na Etapa 4, quando implementarmos o menu de informações pessoais.
}