import java.util.Arrays;

public class Aula1404 {
    public static void main(String[] args) {
        /*  os arrays estão na memória de forma sequencial
        *   matrizes que podem ter infinitas dimensões;
        *   nunca se cria um array sem tamanho, podendo atribuir um tamanho após;
        *   pode redimensionar arrays (dica);
        *   pode prever uma exceção utilizando try catch;
        *   TF não é preocupação, mas o TL sim;
        *   array string = tudo null; array int = tudo 0; array boolean = tudo false;
        *
        *   int M[100][200]:
        *       declara uma matriz de inteiros de nome M com 100 lin e 200 col;
        *
        *   === DECLARAÇÃO ===
        *   int[] impares (dá pra declarar mais vetores/matrizes de uma vez só
        *
        *   === INICIALIZAÇÃO ===
        *   impares = new int[10] -> com valor default, ou seja, todas as pos sao 0.
        *   int[] impares = {1,3,5,7,9}
        *
        *   === AMBOS ===
        *   int[] impares = new int[10]
        *
        *   evite utilizar tamanhos fixos nos fors */

        int[] vetor;
        vetor = new int[10];

        // for tradicional
        for (int i = 0; i < vetor.length; i++)
            vetor[i] = i * 2;

        System.out.println();

        //for de varredura: for ... each
        //só para quando chega realmente ao fim do vetor
        //mais usado pra vetor e lista
        for(int e:vetor) /* para todo e contido no vetor, imprima e */
            System.out.print(e+" ");

        //vetor = new int[20]; //perde os valores antigos
        //System.out.println();

        /* para não perder os elementos antigos, faça a cópia dos antigos de forma manual, e redimensione */

        int[] copia = Arrays.copyOf(vetor,20);; // criando uma copia para o vetor
        vetor = new int[20]; // redimensionando o vetor (perde os elementos)
        for (int i = 0; i < vetor.length; i++) // devolvendo os elementos copiados
            vetor[i] = copia[i];

        System.out.println();
        System.out.println(Arrays.toString(vetor));

        /* =============== M A T R I Z =================*/
        int[][] matriz;
        matriz = new int[5][10];
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = (int)(Math.random()*100);
            System.out.println();
        }
        preencherVetor(vetor.clone());
        System.out.println(Arrays.deepToString(matriz).replace("],",",\n"));

        int[] novoVetor = vetor.clone();
        novoVetor[0]=99;
        System.out.println(Arrays.toString(criaPreencheVetor(20)));
    }

    public static int[] criaPreencheVetor(int tam) {
        int[] v = new int [tam];
        preencherVetor(v);
        return v;
    }

    private static void preencherVetor(int[] v) { // arrays e objetos sempre sao passados por referencia
        for(int i = 0; i < v.length; i++)
            v[i] = (int)(Math.random()*100);
    }
}
