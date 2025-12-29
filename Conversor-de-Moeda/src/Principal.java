import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ConsultarMoeda consultarMoeda = new ConsultarMoeda();

        System.out.println("""
            *****************************************************
            *          CONVERSOR DE MOEDAS                     *
            *****************************************************
            """);

        System.out.println("Digite o código da moeda base (ex: USD, EUR, BRL): ");
        String codigoMoeda = input.nextLine().toUpperCase();

        try {
            Moeda novaMoeda = consultarMoeda.buscaMoeda(codigoMoeda);

            if (novaMoeda == null) {
                System.out.println("Moeda não encontrada ou inválida.");
                return;
            }

            System.out.println("\n" + "=".repeat(50));
            System.out.println("RESULTADO DA CONSULTA:");
            System.out.println("=".repeat(50));
            System.out.println("Moeda base: " + novaMoeda.moedaBase());
            System.out.println("Status: " + novaMoeda.resultado());

            System.out.println("\nTaxas de conversão disponíveis:");
            System.out.println("-".repeat(50));

            // Exibir algumas moedas principais
            String[] moedasPrincipais = {"USD", "EUR", "BRL", "GBP", "JPY", "CNY"};

            for (String moeda : moedasPrincipais) {
                Double taxa = novaMoeda.getTaxa(moeda);
                if (taxa != null) {
                    System.out.printf("%s: %.4f%n", moeda, taxa);
                }
            }

            System.out.println("\nTotal de moedas disponíveis: " +
                    (novaMoeda.taxasConversao() != null ?
                            novaMoeda.taxasConversao().size() : 0));

            // Opção para conversão específica
            System.out.println("\nDeseja fazer uma conversão específica? (S/N)");
            String resposta = input.nextLine().trim().toUpperCase();

            if (resposta.equals("S")) {
                realizarConversao(input, novaMoeda);
            }

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Finalizando a aplicação");
        } finally {
            input.close();
        }
    }

    private static void realizarConversao(Scanner input, Moeda moeda) {
        System.out.println("\nDigite o código da moeda de destino (ex: EUR, JPY): ");
        String moedaDestino = input.nextLine().toUpperCase();

        Double taxa = moeda.getTaxa(moedaDestino);

        if (taxa == null) {
            System.out.println("Moeda de destino não encontrada.");
            return;
        }

        System.out.println("Digite o valor para converter: ");
        try {
            double valor = input.nextDouble();
            input.nextLine(); // Limpar buffer

            double valorConvertido = valor * taxa;

            System.out.println("\n" + "=".repeat(50));
            System.out.println("RESULTADO DA CONVERSÃO:");
            System.out.println("=".repeat(50));
            System.out.printf("%.2f %s = %.2f %s%n",
                    valor, moeda.moedaBase(),
                    valorConvertido, moedaDestino);
            System.out.printf("Taxa: 1 %s = %.4f %s%n",
                    moeda.moedaBase(), taxa, moedaDestino);

        } catch (Exception e) {
            System.out.println("Valor inválido. Use números (ex: 100.50)");
        }
    }
}