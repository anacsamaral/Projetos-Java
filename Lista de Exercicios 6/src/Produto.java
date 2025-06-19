import javax.swing.*;

public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco){
            this.nome = nome;
            this.preco = preco;
    }

    public void desconto(double perc){
        if(perc >= 0 && perc <= 100)
            preco -= preco * (perc / 100.0);
        else
            JOptionPane.showMessageDialog(null, "Percentual de desconto inválido.");
    }

    public double imposto(){
        return preco * 0.10;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {

        return preco;
    }
}
