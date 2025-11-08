package com.example.apo_desmobile_2025;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.apo_desmobile_2025.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate o layout para este fragmento
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnEntrar = view.findViewById(R.id.btn_entrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Encontra o ViewPager2 na Activity pai (MainActivity)
                ViewPager2 viewPager = getActivity().findViewById(R.id.view_pager);

                // Muda para a próxima página (índice 1, que é o SecondFragment)
                if (viewPager != null) {
                    viewPager.setCurrentItem(1);
                }
            }
        });
    }
}