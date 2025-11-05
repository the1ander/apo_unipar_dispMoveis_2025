package com.example.apo_desmobile_2025;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    // Array com os títulos das abas (serão usados no TabLayout)
    private final String[] tabTitles = new String[]{"Previsão do Tempo", "Sobre o Aluno"};

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Retorna o Fragmento correto baseado na posição da aba
        switch (position) {
            case 0:
                // Fragmento para a Previsão do Tempo (Fragmento 1)
                return new FirstFragment();
            case 1:
                // Fragmento para a tela "Sobre" (Fragmento 2)
                return new SecondFragment();
            default:
                return new FirstFragment();
        }
    }

    @Override
    public int getItemCount() {
        // Número total de abas
        return tabTitles.length;
    }

    // Método auxiliar para obter o título da aba (será usado na MainActivity)
    public String getTabTitle(int position) {
        return tabTitles[position];
    }
}
