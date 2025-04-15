import java.util.Arrays;

public class ExercicioI {
    public static void main(String[] args) {
        decompor(1300);
    }

    public static void decompor(long numero){
        int i, TL = 0; long aux = numero;

        for(i = 0; aux > 0; i++){ // quantidade de dígitos
            aux /= 10;
            TL++;
        }

        long[] vetor = new long[TL]; // atribui um tamanho para o vetor (nº de digitos)

        for(i = TL - 1; i >= 0; i--){ // passa os valores de tras pra frente no vetor
            vetor[i] = numero % 10;
            numero /= 10;
        }

        for(long e:vetor)
            System.out.print(e+" ");
    }
}
