import java.util.Arrays;
import java.util.Scanner;

public class ExercicioIII {
    public static int[][] geraMatriz(int linhas, int colunas){
        int[][] matriz = new int[linhas][colunas];

        System.out.println("Matriz Gerada!");
        return matriz;
    }

    public static int[][] completaMatriz(int[][] matriz) {
        for(int i = 0; i < matriz.length; i++)
            for(int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = (int) (Math.random() * 100) + 1;

        System.out.println("Matriz Completa!");
        return matriz;
    }

    public static void imparesPares(int[][] matriz){
        int contP, contI, i, j;
        double total, percP, percI;
        for(i = 0; i < matriz.length; i++)
        {
            contP = 0; contI = 0;
            for(j = 0; j < matriz[i].length; j++)
            {
                if(matriz[i][j] % 2 == 0)
                    contP++;
                else
                    contI++;
            }
            total = contI + contP;
            percP = (double) (contP/total) * 100;
            percI = (double) (contI/total) * 100;
            System.out.printf("Linha [%d]: %.0f%% são pares e %.0f%% são ímpares\n",i, percP, percI);
        }
    }

    public static void exibeMatriz(int[][] matriz) {
        System.out.println(Arrays.deepToString(matriz).replace("],", "],\n"));
    }

    public static void main(String[] args) {
        int linhas, colunas;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o número de linhas da matriz: ");
        linhas = ler.nextInt();
        System.out.println("Digite o número de colunas da matriz: ");
        colunas = ler.nextInt();

        int[][] matriz = geraMatriz(linhas, colunas);
        completaMatriz(matriz);
        exibeMatriz(matriz);
        imparesPares(matriz);
    }
}
