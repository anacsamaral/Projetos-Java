import java.util.Arrays;
import java.util.Scanner;

public class ExercicioII {
    public static int[][] geraMatrizQuadrada(int TL) { // solicita valores da matriz
        int matriz [][] = new int[TL][TL];

        Scanner lerMatriz = new Scanner(System.in);
        System.out.println("Digite os valores da matriz 4 x 4:\n");

        for(int i = 0; i < matriz.length; i++)
            for(int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = lerMatriz.nextInt();

        System.out.println("Matriz Gerada");
        return matriz;
    }

    public static void exibeMatriz(int[][] matriz) {
        System.out.println(Arrays.deepToString(matriz).replace("],", "],\n"));
    }

    public static boolean verificaQM(int[][] matriz) { // verifica se é quadro mágico
        int soma1 = 0, soma2 = 0, soma3 = 0;

        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++) {
                soma1 += matriz[i][j]; // soma da linha
                soma2 += matriz[j][i]; // soma da coluna
                soma3 += matriz[i][i]; // soma da diagonal
            }

            if (soma1 != soma2 && soma1 != soma3) // se fore diferentes, não é quadro mágico
                return false;

            soma1 = soma2 = soma3 = 0;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o número para colunas e linhas: ");
        int numero = ler.nextInt();

        int[][] matriz  = geraMatrizQuadrada(numero);
        boolean resultado = verificaQM(matriz);

        if(resultado) // se true
            System.out.println("A matriz é um Quadro Mágico");
        else // se false
            System.out.println("A matriz não é um Quadro Mágico");

        exibeMatriz(matriz);
    }
}
