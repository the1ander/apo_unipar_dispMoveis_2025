package com.example.apo_desmobile_2025;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView; // Import necessário
import android.widget.TextView;  // Import necessário

public class ThirdFragment extends Fragment {

    // 1. Declare as variáveis para cada componente do seu layout
    private ImageView imgFotoAluno;
    private TextView tvNomeAluno;
    private TextView tvRaAluno;
    private TextView tvCursoAluno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // A única responsabilidade deste método é inflar e retornar a View.
        // Não mude nada aqui.
        return inflater.inflate(R.layout.fragment_third, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 2. Associe as variáveis aos componentes do XML usando findViewById
        // O 'view' aqui é a raiz do seu layout (o ConstraintLayout)
        imgFotoAluno = view.findViewById(R.id.img_foto_aluno);
        tvNomeAluno = view.findViewById(R.id.tv_nome_aluno);
        tvRaAluno = view.findViewById(R.id.tv_ra_aluno);
        tvCursoAluno = view.findViewById(R.id.tv_curso_aluno);

    }
}
