import java.time.LocalDate;

public class Conta {
    private String numeroConta;
    private String numeroAgencia;
    private String nomeCliente;
    private LocalDate dataNascimento;
    private Double saldo;

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void getDataNascimento() {
        System.out.println(dataNascimento);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getSaldo() {

        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor) {
        if (valor < saldo) {
            saldo = saldo - valor;
            System.out.println(">>>>> Conta de " + nomeCliente);
            System.out.println("Saque de R$ " + valor + ", efetuado com sucesso!");
            System.out.println("Saldo: " + saldo);
            System.out.println("***************************");
        } else {
            System.out.println("*>>>>> Conta de " + nomeCliente);
            System.out.println("Saque não efetuado, saldo insuficiente...");
            System.out.println("Saldo: " + saldo);
            System.out.println("***************************");
        }
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, Double valor) {
        if (valor <= contaOrigem.saldo) {
            contaOrigem.saldo -= valor;
            contaDestino.deposito(valor); // Depositando na conta de destino
            System.out.println("Tranferência de " + contaOrigem.nomeCliente + " para " + contaOrigem.nomeCliente);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
            System.out.println("Novo saldo de " + contaOrigem.nomeCliente + ": R$ " + saldo);
            System.out.println("Novo saldo de " + contaDestino.nomeCliente + ": R$ " + contaDestino.getSaldo());
            System.out.println("***************************");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println(">>>>> Conta de " + nomeCliente);
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
            System.out.println("Novo saldo: R$ " + saldo);
            System.out.println("***************************");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void deposito(Double valor) {
        if (valor > 0) {
            this.saldo = saldo + valor;

        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

}
