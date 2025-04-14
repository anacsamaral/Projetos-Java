import java.util.*;

public class Bingo {

    public static void main(String[] args) {
        int[][][] cartelas = new int[5][5][5]; // 5 cartelas, 5x5 cada
        List<Integer> numerosSorteados = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            geraCartela(cartelas[i]);
        }

        boolean vencedorEncontrado = false;
        Random random = new Random();

        while (!vencedorEncontrado) {
            sorteiaNumero(numerosSorteados);
            mostraSorteados(numerosSorteados);

            for (int i = 0; i < 5; i++) {
                mostraCartela(cartelas[i]);
                if (verificaDiagonal(cartelas[i], numerosSorteados) ||
                        verificaHorizontal(cartelas[i], numerosSorteados) ||
                        verificaVertical(cartelas[i], numerosSorteados) ||
                        verificaCartelaCheia(cartelas[i], numerosSorteados)) {

                    System.out.println("Cartela " + (i + 1) + " é vencedora!");
                    vencedorEncontrado = true;
                }
            }
            System.out.println("-----------------------------------------------------");
        }
    }

    static void geraCartela(int[][] cartela) {
        Random rand = new Random();
        for (int col = 0; col < 5; col++) {
            Set<Integer> numeros = new HashSet<>();
            while (numeros.size() < 5) {
                int num = rand.nextInt(15) + 1 + 15 * col;
                numeros.add(num);
            }
            Iterator<Integer> it = numeros.iterator();
            for (int row = 0; row < 5; row++) {
                cartela[row][col] = it.next();
            }
        }
        cartela[2][2] = 0; // coringa
    }

    static boolean verificaDiagonal(int[][] cartela, List<Integer> sorteados) {
        boolean d1 = true, d2 = true;
        for (int i = 0; i < 5; i++) {
            if (i != 2) {
                d1 &= sorteados.contains(cartela[i][i]);
                d2 &= sorteados.contains(cartela[i][4 - i]);
            }
        }
        return d1 || d2;
    }

    static boolean verificaHorizontal(int[][] cartela, List<Integer> sorteados) {
        for (int i = 0; i < 5; i++) {
            boolean completa = true;
            for (int j = 0; j < 5; j++) {
                if (!(i == 2 && j == 2)) {
                    completa &= sorteados.contains(cartela[i][j]);
                }
            }
            if (completa) return true;
        }
        return false;
    }

    static boolean verificaVertical(int[][] cartela, List<Integer> sorteados) {
        for (int j = 0; j < 5; j++) {
            boolean completa = true;
            for (int i = 0; i < 5; i++) {
                if (!(i == 2 && j == 2)) {
                    completa &= sorteados.contains(cartela[i][j]);
                }
            }
            if (completa) return true;
        }
        return false;
    }

    static boolean verificaCartelaCheia(int[][] cartela, List<Integer> sorteados) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!(i == 2 && j == 2) && !sorteados.contains(cartela[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    static void sorteiaNumero(List<Integer> sorteados) {
        Random rand = new Random();
        int num;
        do {
            num = rand.nextInt(75) + 1;
        } while (sorteados.contains(num));
        sorteados.add(num);
    }

    static void mostraSorteados(List<Integer> sorteados) {
        System.out.print("Números sorteados: ");
        for (int n : sorteados) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static void mostraCartela(int[][] cartela) {
        System.out.println("Cartela:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    System.out.print(" * ");
                } else {
                    System.out.printf("%2d ", cartela[i][j]);
                }
            }
            System.out.println();
        }
    }
}
