import java.util.Scanner;

public class ExercicioV {
    public static int[] geraAposta(int num) {
        int[] aposta = new int[num];
        int i = 0;

        while (i < num) {
            int n = (int) (Math.random() * 60) + 1; // gerando aleatorios entre 1 e 60
            boolean repetido = false;

            for (int j = 0; j < i; j++)
                if (aposta[j] == n) // se o valor aleatorio ja esta no vetor aposta
                    repetido = true;

            if (!repetido) { // se falso
                aposta[i] = n; // posicao i recebe o novo valor aleatorio
                i++;
            }
        }
        return aposta; // devolv o vetor de aposta
    }


    public static int[] geraMegaSena(){
        return geraAposta(6);
    }

    public static int verificaAposta(int aposta[], int megasena[]){
        int acertos = 0;
        for (int n:aposta)
            for (int m:megasena)
                if (n == m)
                    acertos++;

        return acertos;
    }

    public static void MostraMegaSena(int megasena[]){
        System.out.println("=== Mega-Sena ===");
        for (int e:megasena) {
            System.out.print("["+e+"] ");
        }
        System.out.println();
    }

    public static void MostraAposta(int aposta[]){
        for (int e:aposta) {
            System.out.print("["+e+"] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int totalApostas, numeroPorAposta;
        Scanner ler = new Scanner(System.in);

        System.out.println("Quantas apostas você quer fazer?: ");
        totalApostas = ler.nextInt();

        System.out.println("Quantos números por aposta? (6 a 15): ");
        numeroPorAposta = ler.nextInt();

        int[][] apostas = new int[totalApostas][];
        for(int i = 0; i < totalApostas; i++)
            apostas[i] = geraAposta(numeroPorAposta);

        int[] megasena = geraMegaSena();

        System.out.println("Resultado do sorteio:");
        MostraMegaSena(megasena);

        System.out.println("\n======= Apostas =======");
        for (int i = 0; i < totalApostas; i++) {
            System.out.printf("Aposta %d:=============\n", i+1);
            MostraAposta(apostas[i]);
            int acertos = verificaAposta(apostas[i], megasena);
            System.out.printf("Acertos: %d\n", acertos);
        }
    }
}
