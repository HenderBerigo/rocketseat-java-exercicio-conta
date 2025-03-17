import java.time.LocalDate;

/**
 * A classe Conta representa uma conta bancária, permitindo realizar operações
 * como saque, depósito, transferência e desativação.
 * A conta pode ser desativada por um motivo especificado e pode verificar o
 * saldo.
 * 
 * @author Seu Nome
 * @version 1.0
 */
public class Conta {

    private String numeroConta;
    private String numeroAgencia;
    private String nomeCliente;
    private LocalDate dataNascimento;
    private Double saldo;
    private boolean ativa = true;
    private String justificativa;

    /**
     * Retorna o número da conta.
     * 
     * @return O número da conta.
     */
    public String getNumeroConta() {
        return numeroConta;
    }

    /**
     * Define o número da conta.
     * 
     * @param numeroConta O número da conta a ser definido.
     */
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    /**
     * Retorna o número da agência.
     * 
     * @return O número da agência.
     */
    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    /**
     * Define o número da agência.
     * 
     * @param numeroAgencia O número da agência a ser definido.
     */
    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    /**
     * Retorna o nome do cliente associado à conta.
     * 
     * @return O nome do cliente.
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Define o nome do cliente.
     * 
     * @param nomeCliente O nome do cliente a ser definido.
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * Exibe a data de nascimento do cliente.
     */
    public void getDataNascimento() {
        System.out.println(dataNascimento);
    }

    /**
     * Define a data de nascimento do cliente.
     * 
     * @param dataNascimento A data de nascimento a ser definida.
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna o saldo da conta.
     * 
     * @return O saldo atual da conta.
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * Define o saldo da conta.
     * 
     * @param saldo O valor a ser atribuído ao saldo da conta.
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    /**
     * Realiza um saque da conta, se o saldo for suficiente.
     * 
     * @param valor O valor a ser sacado.
     */
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

    /**
     * Realiza uma transferência entre duas contas.
     * 
     * @param contaOrigem  A conta de origem da transferência.
     * @param contaDestino A conta de destino da transferência.
     * @param valor        O valor a ser transferido.
     */
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

    /**
     * Realiza um depósito na conta.
     * 
     * @param valor O valor a ser depositado.
     */
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

    /**
     * Realiza um depósito diretamente na conta.
     * 
     * @param valor O valor a ser depositado.
     */
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

    /**
     * Desativa a conta, se a conta tiver saldo zero.
     * 
     * @param conta         A conta a ser desativada.
     * @param justificativa A justificativa para a desativação da conta.
     */
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
