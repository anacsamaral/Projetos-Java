import java.util.Random;

public class Bingo {
    private int maximo;
    private int[] numeros;
    private int totalRestante;
    private Random random;

    // construtor
    public Bingo(int maximo) {
        if (maximo < 30)
            maximo = 75;

        this.maximo = maximo;
        this.numeros = new int[maximo];
        this.totalRestante = maximo;
        this.random = new Random();

        for (int i = 0; i < maximo; i++)
            numeros[i] = i + 1;
    }
    // sem repetir
    public int sortear() {
        if (totalRestante == 0) {
            return -1;
        }

        int indice = random.nextInt(totalRestante);
        int numeroSorteado = numeros[indice];

        numeros[indice] = numeros[totalRestante - 1];
        totalRestante--;

        return numeroSorteado;
    }

    public int getMaximo() {
        return maximo;
    }

    public int getTotalRestante() {
        return totalRestante;
    }

    public boolean temNumerosRestantes() {
        return totalRestante > 0;
    }
}
