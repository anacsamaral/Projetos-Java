import java.util.Scanner;

public class ExercicioII {
    public static void main(String[] args) {
        int matriz [][];
        matriz = new int [4][4];

        matriz = geraMatrizQuadrada();
        verificaQM(matriz);
        exibeMatriz(matriz);
    }

    private static void exibeMatriz(int [][] matriz) {
        int i, j;
        for(i = 0; i < 4; i++){
            for(j = 0; j < 4; j++)
                System.out.printf("[%d]", matriz[i][j]);
            System.out.println();
        }
    }

    private static void verificaQM(int[][] matriz) {
        int soma_linha = 0, soma_coluna = 0, i, j;

        for(i = 0; i < 4; i++){
            for(j = 0; j < 4; j++)
                System.out.printf("[%d]", matriz[i][j]);
            System.out.println();
        }
    }

    private static int[][] geraMatrizQuadrada() {
        int matriz [][];
        matriz = new int [4][4];
        int i, j;
        Scanner lerMatriz = new Scanner(System.in);
        System.out.println("Digite os valores da matriz 4 x 4:\n");

        for(i = 0; i < 4; i++)
            for(j = 0; j < 4; j++)
                matriz[i][j] = lerMatriz.nextInt();

        System.out.println("Matriz Gerada");
        return matriz;
    }
}
