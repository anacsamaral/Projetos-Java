public class ContaCorrente {
    private String numero;
    private double saldo;
    private boolean especial;
    private double limite;

    public ContaCorrente(String numero, double saldo, boolean especial, double limite) {
        this.numero = numero;
        this.saldo = saldo;
        this.especial = especial;
        this.limite = limite;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    // sacar
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return false;
        }

        if (especial) {
            if (saldo + limite >= valor) {
                saldo -= valor;
                return true;
            }
        } else {
            if (saldo >= valor) {
                saldo -= valor;
                return true;
            }
        }
        System.out.println("Saldo insuficiente para saque.");
        return false;
    }

    // depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // consultar saldo
    public double consultarSaldo() {
        return saldo;
    }

    // cheque especial
    public boolean verificarEspecial() {
        return especial && saldo < 0;
    }

    public String toString() {
        return "ContaCorrente {" + "numero='" + numero + '\'' + ", saldo=" + saldo + ", especial=" + especial + ", limite=" + limite + '}';
    }
}