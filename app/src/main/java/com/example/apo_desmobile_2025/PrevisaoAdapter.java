package com.example.apo_desmobile_2025;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PrevisaoAdapter extends RecyclerView.Adapter<PrevisaoAdapter.ViewHolder> {

    private final List<ModeloPrevisao> listaPrevisoes;

    // Construtor que recebe a lista de dados
    public PrevisaoAdapter(List<ModeloPrevisao> listaPrevisoes) {
        this.listaPrevisoes = listaPrevisoes;
    }

    // ViewHolder: Mapeia os componentes do layout do item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCidade;
        public TextView tvCondicao;
        public TextView tvTempMin;
        public TextView tvTempMax;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCidade = itemView.findViewById(R.id.tv_cidade);
            tvCondicao = itemView.findViewById(R.id.tv_condicao);
            tvTempMin = itemView.findViewById(R.id.tv_temp_min);
            tvTempMax = itemView.findViewById(R.id.tv_temp_max);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout do item (CardView)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_previsao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Preenche os componentes do layout com os dados do modelo
        ModeloPrevisao previsao = listaPrevisoes.get(position);
        holder.tvCidade.setText(previsao.getCidade());
        holder.tvCondicao.setText(previsao.getCondicao());
        holder.tvTempMin.setText("Min: " + previsao.getTempMin() + "°C");
        holder.tvTempMax.setText("Max: " + previsao.getTempMax() + "°C");
    }

    @Override
    public int getItemCount() {
        // Retorna o número total de itens na lista
        return listaPrevisoes.size();
    }
}
