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
        // 1. O layout principal deve ser carregado primeiro
        setContentView(R.layout.activity_main);

        // 2. Os componentes devem ser encontrados DEPOIS do setContentView
        setSupportActionBar(findViewById(R.id.toolbar));

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        // 3. O resto da lógica...
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getTabTitle(position))
        ).attach();
    }
}