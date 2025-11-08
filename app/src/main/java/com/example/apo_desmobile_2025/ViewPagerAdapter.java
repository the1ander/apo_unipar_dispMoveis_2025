package com.example.apo_desmobile_2025 ;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    // Array com os títulos das abas
    private final String[] tabTitles = new String[]{"Boas-vindas", "Previsão do Tempo", "Sobre o Aluno"};

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Retorna o Fragmento correto baseado na posição da aba
        switch (position) {
            case 0:
                // Aba 0: Tela de Boas-vindas/Login
                return new FirstFragment();
            case 1:
                // Aba 1: Tela de Previsão do Tempo
                return new SecondFragment();
            case 2:
                // Aba 2: Tela Sobre o Aluno
                return new FirstFragment(); // AGORA USANDO O FRAGMENTO CORRETO
            default:
                return new FirstFragment();
        }
    }

    @Override
    public int getItemCount() {
        // Número total de abas: 3
        return tabTitles.length;
    }

    // Método auxiliar para obter o título da aba
    public String getTabTitle(int position) {
        return tabTitles[position];
    }
}
