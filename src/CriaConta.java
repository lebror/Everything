import java.util.Scanner;
public class CriaConta {
	private static Scanner le;

	public static void main(String[] args) {
		Conta conta;
		Banco b = new Banco();
		le = new Scanner(System.in);
		String numero;
		double valor;
		boolean laco = true;
		
		System.out.println("1 - Cadastrar conta\n2 - Creditar conta\n3 - Debitar conta\n4 - Transferência\n5 - Saldo\n6 - Sair");
		int op = le.nextInt();
		do {
			switch (op) {
				case 1:
					System.out.println("Digite numero da conta: ");
					numero = le.next();
					conta = new Conta(numero);
					b.cadastrar(conta);
				break;
				case 2:
					System.out.println("Digite numero da conta: ");
					numero = le.next();
					if (b.procurar(numero)==null) {
						System.out.println("Conta Inexistente!");
						break;
					}
					System.out.println("Valor: ");
					valor = le.nextDouble();
					b.creditar(numero, valor);
				break;
				case 3:
					System.out.println("Digite numero da conta: ");
					numero = le.next();
					if (b.procurar(numero)==null) {
						System.out.println("Conta Inexistente!");
						break;
					}
					System.out.println("Valor: ");
					valor = le.nextDouble();
					b.debitar(numero, valor);
				break;
				case 4:
					System.out.println("Digite numero da sua conta: ");
					numero = le.next();
					if (b.procurar(numero)==null) {
						System.out.println("Conta Inexistente!");
						break;
					}
					System.out.println("Valor a ser trasnferido: ");
					valor = le.nextDouble();
					b.debitar(numero, valor);
					System.out.println("Digite numero da conta de destino: ");
					numero = le.next();
					b.creditar(numero, valor);
				break;
				case 5:
					System.out.println("Digite numero da sua conta: ");
					numero = le.next();
					b.verSaldo(numero);
				break;
				case 6:
					laco = false;
				break;
				default:
					System.out.println("Opção Inválida!");
			}
			System.out.println("1 - Cadastrar conta\n2 - Creditar conta\n3 - Debitar conta\n4 - Transferência\n5 - Saldo\n6 - Sair");
			op = le.nextInt();
		} while (laco);
	}
}
