import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class ExercicioIII {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] jogoUsuario = new int[6];
        int[] contagem = new int[61];

        System.out.println("Digite seus 6 números (entre 1 e 60):");
        for (int i = 0; i < 6; i++) {
            jogoUsuario[i] = leitor.nextInt();
        }

        Arrays.sort(jogoUsuario); //ordena
        try {
            RandomAccessFile arq = new RandomAccessFile("\\C:\\Users\\anaca\\Downloads\\megasena.csv", "r");
            arq.readLine(); // para pular o cabeçalho
            boolean encontrado = false;

            while (arq.getFilePointer() < arq.length())
            {
                String linha = arq.readLine();
                String[] partes = linha.split(";");

                int[] numerosSorteio = new int[6];

                for (int i = 0; i < 6; i++)
                {
                    int numero = Integer.parseInt(partes[i + 1]); // pular a data
                    numerosSorteio[i] = numero;
                    contagem[numero]++;
                }

                Arrays.sort(numerosSorteio);
                if (Arrays.equals(jogoUsuario, numerosSorteio))
                {
                    System.out.println("Este jogo já foi sorteado na data: " + partes[0]);
                    encontrado = true;
                }

            }
            if (!encontrado)
                System.out.println("Este jogo nunca foi sorteado.");

            System.out.println("\nContagem de frequência dos números:");
            for (int i = 1; i <= 60; i++)
            {
                if (contagem[i] > 0)
                    System.out.println("Número " + i + " apareceu " + contagem[i] + " vez(es)");
            }
            arq.close();
        }
        catch (Exception e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }
}