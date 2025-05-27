import javax.swing.*;

public class MainVetor {
    public static void main(String[] args) {
        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tamanho:"));
        Vetor e = new Vetor(valor);
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Inserir\n" + "2 - Ver posicao\n" + "3 - Ultimo elemento\n" + "4 - Tamanho\n" + "0 - Sair\n" + "Escolha uma opção:"));

            switch (op) {
                case 1:
                    String vl = JOptionPane.showInputDialog(null, "Digite o algo:");
                    e.inserir(vl);
                    JOptionPane.showMessageDialog(null, vl + " Foi inserido");
                    break;

                case 2:
                    int pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o local:"));
                    String aux = e.getPosicao(pos);
                    JOptionPane.showMessageDialog(null, "Item da posicao: " + aux);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "ultimo item: "+ e.getUltimo());
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Tamanho do vetor é : "+ e.getTamanho());

                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (op != 0);
    }
}
