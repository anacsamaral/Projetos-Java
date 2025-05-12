import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ExercicioII {
    public static void main(String[] args) {
        String arquivo = "mensagens.txt";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mensagens anteriores:");

        // se o arquivo existe e se tem algo nele
        try {
                if (Files.exists(Paths.get(arquivo))) {
                    BufferedReader reader = Files.newBufferedReader(Paths.get(arquivo));
                    String linha;
                    while ((linha = reader.readLine()) != null)
                        System.out.println(linha);
                }
                else
                    System.out.println("Nenhuma mensagem armazenada anteriormente.");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        LocalDateTime hora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraAtual = hora.format(formatter);

        System.out.print("\nDigite uma nova mensagem: ");
        String mensagem = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write("[" + dataHoraAtual + "] " + mensagem);
            writer.newLine(); // Adiciona uma nova linha após a mensagem
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }
}
