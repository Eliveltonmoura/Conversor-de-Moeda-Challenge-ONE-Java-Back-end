import java.util.Map;

public record Moeda(
        String resultado,
        String moedaBase,
        Map<String, Double> taxasConversao
) {

    public Double getTaxa(String moeda) {
        if (taxasConversao == null || moeda == null) {
            return null;
        }
        return taxasConversao.get(moeda.toUpperCase());
    }
}