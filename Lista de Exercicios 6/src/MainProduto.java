import javax.swing.*;

public class MainProduto {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));

        while(preco < 0) {
            JOptionPane.showMessageDialog(null, "Valor Inválido para o Produto");
            preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));
        }
        if (preco > 0) {
            Produto produto = new Produto(nome, preco);

            double perc = Double.parseDouble(JOptionPane.showInputDialog("Digite o percentual de desconto:"));
            produto.desconto(perc);

            double imposto = produto.imposto();

            String mensagem = String.format("Produto: %s\nPreço com desconto: R$ %.2f\nImposto (10%%): R$ %.2f", produto.getNome(), produto.getPreco(), imposto);
            JOptionPane.showMessageDialog(null, mensagem);
        }
    }
}