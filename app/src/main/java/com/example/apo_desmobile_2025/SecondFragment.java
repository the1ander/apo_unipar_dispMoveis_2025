package com.example.apo_desmobile_2025;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;



public class SecondFragment extends Fragment {

    private RecyclerView rvPrevisoes;
    private PrevisaoAdapter adapter;
    private List<ModeloPrevisao> listaPrevisoes;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate o layout para este fragmento
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPrevisoes = view.findViewById(R.id.rv_previsoes);

        // 1. Inicializa a lista de dados (Dados de Teste)
        listaPrevisoes = new ArrayList<>();
        // Estes dados serão substituídos pela chamada da API na Etapa 5
        listaPrevisoes.add(new ModeloPrevisao("São Paulo", "Ensolarado", "15", "28"));
        listaPrevisoes.add(new ModeloPrevisao("Rio de Janeiro", "Chuva Forte", "22", "30"));
        listaPrevisoes.add(new ModeloPrevisao("Curitiba", "Nublado", "10", "18"));

        // 2. Configura o Adapter
        adapter = new PrevisaoAdapter(listaPrevisoes);

        // 3. Configura o RecyclerView
        rvPrevisoes.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPrevisoes.setAdapter(adapter);
    }
}
