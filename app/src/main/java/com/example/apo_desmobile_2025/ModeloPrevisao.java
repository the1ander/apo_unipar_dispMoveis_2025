package com.example.apo_desmobile_2025;

public class ModeloPrevisao {
    private String cidade;
    private String condicao;
    private String tempMin;
    private String tempMax;

    // Construtor
    public ModeloPrevisao(String cidade, String condicao, String tempMin, String tempMax) {
        this.cidade = cidade;
        this.condicao = condicao;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    // Getters (Setters não são necessários para este exemplo)
    public String getCidade() {
        return cidade;
    }

    public String getCondicao() {
        return condicao;
    }

    public String getTempMin() {
        return tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }
}
