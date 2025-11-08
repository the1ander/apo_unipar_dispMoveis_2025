package com.example.apo_desmobile_2025;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONObject;

public class SecondFragment extends Fragment {

    // Chave de API - O USUÁRIO DEVE SUBSTITUIR POR SUA CHAVE REAL
    private static final String API_KEY = "SUA-CHAVE";
    private static final String API_URL = "https://api.hgbrasil.com/weather?key=" + API_KEY + "&city_name=";

    private RecyclerView rvPrevisoes;
    private PrevisaoAdapter adapter;
    private List<ModeloPrevisao> listaPrevisoes;
    private EditText etCityName;
    private Button btnSearch;

    // Executor para rodar a requisição de rede em uma thread separada
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

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
        etCityName = view.findViewById(R.id.et_city_name);
        btnSearch = view.findViewById(R.id.btn_search);

        // 1. Inicializa a lista de dados
        listaPrevisoes = new ArrayList<>();

        // 2. Configura o Adapter
        adapter = new PrevisaoAdapter(listaPrevisoes);

        // 3. Configura o RecyclerView
        rvPrevisoes.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPrevisoes.setAdapter(adapter);

        // 4. Configura o listener do botão de busca
        btnSearch.setOnClickListener(v -> {
            String cityName = etCityName.getText().toString().trim();
            if (!cityName.isEmpty()) {
                fetchWeatherData(cityName);
            } else {
                Toast.makeText(getContext(), "Por favor, digite o nome da cidade.", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void fetchWeatherData(String cityName) {
        // Exibe uma mensagem de carregamento
        Toast.makeText(getContext(), "Buscando dados de " + cityName + "...", Toast.LENGTH_SHORT).show();

        executorService.execute(() -> {
            try {
                // Codifica o nome da cidade para URL
                String encodedCityName = URLEncoder.encode(cityName, "UTF-8");
                String fullUrl = API_URL + encodedCityName;

                URL url = new URL(fullUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // Processa o JSON na thread principal (UI Thread)
                    getActivity().runOnUiThread(() -> parseJsonAndUpdateUI(response.toString()));
                } else {
                    // Trata erro de conexão na thread principal
                    getActivity().runOnUiThread(() -> Toast.makeText(getContext(), "Erro na requisição: " + responseCode, Toast.LENGTH_LONG).show());
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Trata exceção na thread principal
                getActivity().runOnUiThread(() -> Toast.makeText(getContext(), "Erro ao buscar dados: " + e.getMessage(), Toast.LENGTH_LONG).show());
            }
        });
    }

    private void parseJsonAndUpdateUI(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);

            // Verifica se a chave é válida e se há resultados
            if (!jsonObject.optBoolean("valid_key", false)) {
                Toast.makeText(getContext(), "Chave de API inválida ou não fornecida. Por favor, substitua 'SUA-CHAVE' pela sua chave real.", Toast.LENGTH_LONG).show();
                return;
            }

            JSONObject results = jsonObject.getJSONObject("results");

            // Extrai os dados da previsão atual
            String cityName = results.getString("city_name");
            String description = results.getString("description");

            // A API fornece a previsão para os próximos dias em um array "forecast"
            JSONArray forecastArray = results.getJSONArray("forecast");

            // Limpa a lista anterior
            listaPrevisoes.clear();

            // Adiciona a previsão atual como o primeiro item (usando a primeira previsão do forecast para min/max)
            if (forecastArray.length() > 0) {
                JSONObject todayForecast = forecastArray.getJSONObject(0);
                String minTemp = String.valueOf(todayForecast.getInt("min"));
                String maxTemp = String.valueOf(todayForecast.getInt("max"));

                // Adiciona a previsão de hoje (ou a primeira disponível)
                listaPrevisoes.add(new ModeloPrevisao(cityName, description, minTemp, maxTemp));
            }

            // Adiciona as previsões futuras (opcional, mas mantém a estrutura de lista)
            for (int i = 1; i < forecastArray.length(); i++) {
                JSONObject forecast = forecastArray.getJSONObject(i);
                String date = forecast.getString("date");
                String dayDescription = forecast.getString("description");
                String minTemp = String.valueOf(forecast.getInt("min"));
                String maxTemp = String.valueOf(forecast.getInt("max"));

                // Usamos a data como "nome da cidade" para a lista de previsões futuras
                listaPrevisoes.add(new ModeloPrevisao(date + " - " + cityName, dayDescription, minTemp, maxTemp));
            }

            // Notifica o adapter que os dados mudaram
            adapter.notifyDataSetChanged();

            // Exibe mensagem de sucesso
            Toast.makeText(getContext(), "Dados de " + cityName + " carregados com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Erro ao processar dados: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}