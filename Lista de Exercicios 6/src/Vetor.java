public class Vetor {

    private String[] vetor;
    private int qtde;

    public Vetor(int tamanho){
        vetor = new String[tamanho];
        qtde = 0;
    }

    private void novoTamanho() {
        String[] nt = new String[vetor.length + 1];
        for (int i = 0; i < vetor.length; i++) {
            nt[i] = vetor[i];
        }
        vetor = nt;
    }

    public void inserir(String al){
        if(qtde == vetor.length) {
            novoTamanho();
        }
        vetor[qtde] = al;
        qtde++;
    }

    public String getPosicao(int posi){
        if (posi > qtde || vetor[posi] == null) {
            return null;
        }
        return vetor[posi];
    }
    public String getUltimo(){
        if (qtde == 0) {
            return null;
        }
        return vetor[qtde -1];
    }
    public int getTamanho(){
        return qtde;
    }
}
