import java.util.Scanner;

public class ContaBancaria {
  private String nome;
  private int numeroConta;
  private double saldo;

  public ContaBancaria(String nome, int numeroConta, double saldoInicial) {
    this.nome = nome;
    this.numeroConta = numeroConta;
    this.saldo = saldoInicial;
  }

  public String getNome() {
    return nome;
  }

  public int getNumeroConta() {
    return numeroConta;
  }

  public double getSaldo() {
    return saldo;
  }

  public void depositar(double valor) {
    if (valor > 0) {
      saldo += valor;
      System.out.println("Depósito de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
    } else {
      System.out.println("Valor de depósito inválido.");
    }
  }

  public void sacar(double valor) {
    if (valor > 5000) {
      System.out.println("Valor do saque acima do permitido.");
    } else if (valor > saldo) {
      System.out.println("Saldo insuficiente para realizar a operação.");
    } else if (valor <= 0) {
      System.out.println("Valor de saque inválido.");
    } else {
      saldo -= valor;
      System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
    }
  }

  public void exibirSaldo() {
    System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Informe o nome do titular:");
    String nome = scanner.nextLine();

    System.out.println("Informe o número da conta:");
    int numeroConta = scanner.nextInt();

    System.out.println("Informe o saldo inicial:");
    double saldoInicial = scanner.nextDouble();

    ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);

    System.out.println("\nConta bancária criada com sucesso.\n");

    int opcao;
    do {
      System.out.println("Escolha uma opção:");
      System.out.println("1 - Depositar");
      System.out.println("2 - Sacar");
      System.out.println("3 - Ver saldo");
      System.out.println("0 - Sair");
      System.out.print("Opção: ");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.print("Informe o valor do depósito: ");
          double valorDeposito = scanner.nextDouble();
          conta.depositar(valorDeposito);
          break;
        case 2:
          System.out.print("Informe o valor do saque: ");
          double valorSaque = scanner.nextDouble();
          conta.sacar(valorSaque);
          break;
        case 3:
          conta.exibirSaldo();
          break;
        case 0:
          System.out.println("Encerrando o programa.");
          break;
        default:
          System.out.println("Opção inválida.");
      }

      System.out.println();

    } while (opcao != 0);

    scanner.close();
  }
}