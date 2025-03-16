import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("///// Conta Bancária /////");
        Conta conta1 = new Conta();
        conta1.setNumeroConta("001");
        conta1.setNumeroAgencia("100");
        conta1.setNomeCliente("José Maria");
        conta1.setDataNascimento(LocalDate.of(1976, 1, 6));
        conta1.setSaldo(0.00);
        conta1.getSaldo();

        conta1.depositar(300.00);
        // conta1.getSaldo();

        conta1.sacar(100);
        // conta1.getSaldo();

        Conta conta2 = new Conta();
        conta2.setNumeroConta("002");
        conta2.setNumeroAgencia("100");
        conta2.setNomeCliente("Maria José");
        conta2.setDataNascimento(LocalDate.of(1982, 9, 5));
        conta2.setSaldo(0.00);

        conta1.transferir(conta1, conta2, 50.00);
        conta2.transferir(conta2, conta1, 10.00);
        conta1.transferir(conta1, conta2, 12.00);

    }
}
