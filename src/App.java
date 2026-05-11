import java.util.Scanner;
import java.util.Locale;

public class App {
    
    // Custos Fixos Mensais informados
    private static final double ALUGUEL_MENSAL = 2260.45;
    private static final double PLANO_DADOS_MENSAL = 94.99;
    private static final int DIAS_NO_MES = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        // Cálculo do custo fixo diário
        double custoFixoDiario = (ALUGUEL_MENSAL + PLANO_DADOS_MENSAL) / DIAS_NO_MES;

        System.out.println("--- Calculadora de Lucro Real (Veiculo Alugado) ---");
        System.out.println("Custo Fixo Diario (Aluguel + Internet): R$ " + String.format("%.2f", custoFixoDiario));
        System.out.println("--------------------------------------------------");

        // Entrada de dados do dia
        System.out.print("Digite o ganho bruto total do dia (R$): ");
        double ganhoBruto = scanner.nextDouble();

        System.out.print("Digite o gasto com combustivel hoje (R$): ");
        double gastoCombustivel = scanner.nextDouble();

        System.out.print("Digite o gasto com limpeza/outros (R$): ");
        double gastoLimpeza = scanner.nextDouble();

        System.out.print("Digite a quilometragem total rodada hoje (km): ");
        double kmRodado = scanner.nextDouble();

        // Processamento
        double custoTotalDia = gastoCombustivel + gastoLimpeza + custoFixoDiario;
        double lucroLiquido = ganhoBruto - custoTotalDia;
        
        // Saída de Resultados
        System.out.println("\n--- RESUMO DO DIA ---");
        System.out.println("Faturamento Bruto: R$ " + String.format("%.2f", ganhoBruto));
        System.out.println("Custos Totais: R$ " + String.format("%.2f", custoTotalDia));
        System.out.println("Lucro Liquido Real: R$ " + String.format("%.2f", lucroLiquido));

        if (ganhoBruto > 0) {
            double margemLucro = (lucroLiquido / ganhoBruto) * 100;
            System.out.println("Margem de Lucro: " + String.format("%.2f", margemLucro) + "%");
        }

        if (lucroLiquido < 0) {
            System.out.println("ALERTA: Hoje voce operou no PREJUIZO!");
        } else if (lucroLiquido < 50) {
            System.out.println("AVISO: Lucro baixo. Considere revisar sua rota.");
        } else {
            System.out.println("PARABENS: Meta batida com sucesso!");
        }

        scanner.close();
    }
}
