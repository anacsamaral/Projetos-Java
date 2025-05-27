import javax.swing.JOptionPane;

public class MainBingo {
    public static void main(String[] args) {
        Bingo bingo = null;
        int opcao = 0;
        do {
            String opcao1 = JOptionPane.showInputDialog(null, "=== MENU DO BINGO ===\n" + "1 - Criar novo bingo\n" + "2 - Sortear número\n" + "3 - Ver total restante\n" + "0 - Sair\n\n" + "Escolha uma opção:");

            if (opcao1 == null)
                break;

            try {
                opcao = Integer.parseInt(opcao1);
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    String tamBingo = JOptionPane.showInputDialog("Informe o valor máximo (ex: 75):");
                    if (tamBingo == null) break;

                    try {
                        int max = Integer.parseInt(tamBingo);
                        bingo = new Bingo(max);
                        JOptionPane.showMessageDialog(null, "Bingo criado com " + bingo.getMaximo() + " números.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número inválido!");
                    }
                    break;

                case 2:
                    if (bingo == null)
                        JOptionPane.showMessageDialog(null, "Você precisa criar o bingo primeiro (opção 1).");
                    else {
                        int numero = bingo.sortear();
                        if (numero == -1)
                            JOptionPane.showMessageDialog(null, "Todos os números já foram sorteados.");
                        else
                            JOptionPane.showMessageDialog(null, "Número sorteado: " + numero);
                    }
                    break;

                case 3:
                    if (bingo == null)
                        JOptionPane.showMessageDialog(null, "Bingo ainda não foi criado.");
                    else
                        JOptionPane.showMessageDialog(null, "Números restantes: " + bingo.getTotalRestante());
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "programa encerrado");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }while(opcao != 0);
    }
}
