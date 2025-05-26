import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        double moeda;
        MaquinaCafe mc;
        mc = new MaquinaCafe(1.05);
        //mc.iniciar(); ja foi instanciado entao nao precisa
        //mc.setPreco(1.15); se mandar o preco por parametro
        do{
            do{
                JOptionPane.showMessageDialog(null,"Preço do Café: " + mc.getPreco() + "\n Total Depositado: " + mc.getAcmMoedas());
                moeda = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da moeda: "));
                mc.depositar(moeda);
            }while(!mc.cafeDisponivel());

            JOptionPane.showMessageDialog(null,"Pegue seu café!\n" + "Pegue seu troco: " + mc.obterTroco());
        }while(JOptionPane.showConfirmDialog(null, "Quer um café?") == JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null, "Total Faturado: " + mc.getValorFaturado() + "\nCafés vendidos" + mc.getCafesVendidos());
    }
}
