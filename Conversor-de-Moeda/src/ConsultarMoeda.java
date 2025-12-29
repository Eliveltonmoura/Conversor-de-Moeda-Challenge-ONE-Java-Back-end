import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

public class ConsultarMoeda {

    private static final String API_KEY = "**************";
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    private static final Gson gson = new Gson();

    public Moeda buscaMoeda(String moedaBase) {
        if (moedaBase == null || moedaBase.trim().isEmpty()) {
            throw new IllegalArgumentException("Código da moeda não pode ser vazio");
        }

        String url = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s",
                API_KEY, moedaBase.toUpperCase());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(15))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            System.out.println("Status Code: " + response.statusCode());

            if (response.statusCode() == 200) {
                // Parse manual para melhor controle
                JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

                String resultado = jsonResponse.get("result").getAsString();

                // Verificar se a consulta foi bem-sucedida
                if (!"success".equals(resultado)) {
                    String errorType = jsonResponse.has("error-type") ?
                            jsonResponse.get("error-type").getAsString() : "unknown";
                    throw new RuntimeException("Erro na API: " + errorType);
                }

                String baseCode = jsonResponse.get("base_code").getAsString();
                JsonObject ratesJson = jsonResponse.get("conversion_rates").getAsJsonObject();

                // Converter para Map
                Map<String, Double> taxas = gson.fromJson(ratesJson,
                        new com.google.gson.reflect.TypeToken<Map<String, Double>>(){}.getType());

                return new Moeda(resultado, baseCode, taxas);

            } else {
                throw new RuntimeException("Erro HTTP: " + response.statusCode());
            }

        } catch (Exception e) {
            throw new RuntimeException("Não consegui buscar as taxas: " + e.getMessage(), e);
        }
    }
}