public class MaquinaCafe {
    //atributos
    private double precoCafe = 1.25; // criar uma função que atribuia um valor para o café
    private double acumulaMoedas;
    private int cafesVendidos;
    private double valorFaturado;

    //métodos
    public MaquinaCafe(double preco){
        acumulaMoedas = 0;
        cafesVendidos = 0;
        valorFaturado = 0;
        setPreco(preco); // pode colocar this.precoCafe especifica os atributos, mas nao é obrigatório aqui
    }
    public MaquinaCafe(){// construtor sobrecarregado (overload); um construtor pode chamar outro:
        this(1.25); // ele reconhece o outro construtor através do parâmetro
        /*acumulaMoedas = 0;
        cafesVendidos = 0;
        valorFaturado = 0;
        precoCafe = 1.25;*/ // pode colocar this.precoCafe especifica os atributos, mas nao é obrigatorio aqui
    }
    public void setPreco(double precoCafe){ // set para mudar o valor de um atributo da classe
        if(precoCafe >= 0 && (((int) Math.ceil(precoCafe * 100)) % 5) == 0) // ceil: arredonda para cima
            this.precoCafe = precoCafe; // this resolve a ambiguidade de variáveis e é colocada no atributo da classe
    }
    public double getPreco(){ // get serve para retornar
        return precoCafe;
    }
    public double getAcmMoedas(){
        return acumulaMoedas;
    }
    public int getCafesVendidos(){
        return cafesVendidos;
    }
    public double getValorFaturado(){
        return valorFaturado;
    }
    public void depositar(double moeda){
        if(moedaValida(moeda))
            acumulaMoedas += moeda;
    }
    private boolean moedaValida(double moeda) {
        double moedas[] = {0.05,0.1,0.25,0.5,1};
        for (int i = 0; i < moedas.length; i++)
            if(moeda == moedas[i])
                return true;
        return false;
    }
    public boolean cafeDisponivel(){
        return acumulaMoedas >= precoCafe;
    }
    public double obterTroco(){
        double troco = acumulaMoedas - precoCafe; // essa variavel não é atributo, é local e do método
        registrarVenda();
        return troco;
    }
    private void registrarVenda() { // private quando um outro metodo chamar ele
        cafesVendidos++;
        valorFaturado += precoCafe;
        acumulaMoedas = 0;
    }
}