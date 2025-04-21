import java.util.Arrays;
import java.util.Scanner;

public class ExercicioIV {
    public static int[][] geraMatriz(int linhas, int colunas) { // solicita valores da matriz
        int matriz [][] = new int[linhas][colunas];

        for(int i = 0; i < matriz.length; i++)
            for(int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = matriz[i][j] = (int) (Math.random() * 100) + 1;

        System.out.println("Matriz Gerada");
        return matriz;
    }

    public static void exibeMatriz(int[][] matriz) {
        System.out.println(Arrays.deepToString(matriz).replace("],", "],\n"));
    }

    public static int[] vetorElementos(int[][] matriz){
        int[] vetor = new int[matriz.length * matriz.length];
        int i, j, k = 0;

        for(i = 0; i < matriz.length; i++) // insere os pares
            for(j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] % 2 == 0)
                    vetor[k++] = matriz[i][j];
            }

        for(i = 0; i < matriz.length; i++) // insere os ímpares
            for(j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] % 2 == 1)
                    vetor[k++] = matriz[i][j];
            }

        return vetor;
    }

    public static void main(String[] args) {
        int linhas, colunas;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o número de linhas da matriz: ");
        linhas = ler.nextInt();
        System.out.println("Digite o número de colunas da matriz: ");
        colunas = ler.nextInt();

        int[][] matriz = geraMatriz(linhas, colunas);
        System.out.println("=== Matriz ===");
        exibeMatriz(matriz);
        int[] vetor = vetorElementos(matriz);

        System.out.println("=== Vetor de Pares e Ímpares ===");
        for(int e:vetor)
            System.out.print("["+e+"] ");

    }
}
