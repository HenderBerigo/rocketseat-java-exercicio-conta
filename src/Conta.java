import java.time.LocalDate;

public class Conta {
    private String numeroConta;
    private String numeroAgencia;
    private String nomeCliente;
    private LocalDate dataNascimento;
    private Double saldo;
    private boolean ativa = true;
    private String justificativa;

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
        if (ativa) {
            if (valor <= saldo) {
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
        } else {
            System.out.println("Conta desativada...");
        }
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, Double valor) {
        if (ativa) {
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
        } else {
            System.out.println("Conta desativada...");
        }
    }

    public void depositar(Double valor) {
        if (ativa) {
            if (valor > 0) {
                saldo = saldo + valor;
                System.out.println(">>>>> Conta de " + nomeCliente);
                System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
                System.out.println("Novo saldo: R$ " + saldo);
                System.out.println("***************************");
            } else {
                System.out.println("Valor de depósito inválido.");
            }
        } else {
            System.out.println("Conta desativada...");
        }
    }

    public void deposito(Double valor) {
        if (ativa) {
            if (valor > 0) {
                this.saldo = saldo + valor;

            } else {
                System.out.println("Valor de depósito inválido.");
            }
        } else {
            System.out.println("Conta desativada...");
        }
    }

    public void desativarConta(Conta conta, String justificativa) {
        if (this == conta) {
            System.out.println(conta.nomeCliente);
            if (ativa && saldo == 0) {
                ativa = false;
                this.justificativa = justificativa;
                System.out.println(conta.nomeCliente + ", sua Conta foi desativada por: " + justificativa);
            } else if (!ativa) {
                System.out.println(conta.nomeCliente + ", sua conta já está desativada, por " + justificativa);

            } else {
                System.out.println("Conta de " + conta.nomeCliente);
                System.out.println("Para desativar, a Conta precisa estar sem saldo...");
            }

        } else {
            System.out.println(this.nomeCliente + ", não é possível desativar uma conta que não é sua...");

        }
    }

}
