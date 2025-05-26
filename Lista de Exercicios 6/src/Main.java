import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("12345-6", 1000.0, true, 500.0);

        String opcao;
        do {
            opcao = JOptionPane.showInputDialog("Saldo atual: R$" + conta.consultarSaldo() + "\nLimite: R$" + conta.getLimite() + "\nConta especial: " + (conta.isEspecial() ? "Sim" : "Não") + "\nUsando cheque especial? " + (conta.verificarEspecial() ? "Sim" : "Não") + "\n\nEscolha uma opção:" + "\n1 - sacar" + "\n2 - depositar" + "\n3 - consultar saldo" + "\n4 - sair");

            if (opcao == null || opcao.equals("4")) {
                break;
            }

            switch (opcao) {
                case "1": /* saque */
                    String valorSaqueStr = JOptionPane.showInputDialog("Digite o valor para saque:");
                    try {
                        double valorSaque = Double.parseDouble(valorSaqueStr);
                        if (conta.sacar(valorSaque)) {
                            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível realizar o saque. Saldo insuficiente.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número.");
                    }
                    break;

                case "2": /* deposito */
                    String valorDepositoStr = JOptionPane.showInputDialog("Digite o valor para depósito:");
                    try {
                        double valorDeposito = Double.parseDouble(valorDepositoStr);
                        conta.depositar(valorDeposito);
                        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número.");
                    }
                    break;

                case "3": /* saldo */
                    JOptionPane.showMessageDialog(null, "Saldo atual: R$" + conta.consultarSaldo() + "\nLimite disponível: R$" + (conta.isEspecial() ? conta.getLimite() : "0.00") + "\nSaldo + limite: R$" + (conta.consultarSaldo() + (conta.isEspecial() ? conta.getLimite() : 0)));
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (!opcao.equals("4"));

        JOptionPane.showMessageDialog(null, "obrigado pela preferencia :)");
    }
}