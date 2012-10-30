
public class Banco {
	private Conta[] contas;
	private int index=0;
	
	public Banco () {
		contas = new Conta[100];
	}
	
	public void cadastrar (Conta conta) {
		contas[index] = conta;
		index++;
	}
	
	public Conta procurar (String numero) {
		int i=0;
		boolean achou = false;
		
		while((!achou)&& (i<index)) {
			if (contas[i].numero().equals(numero)) {
				achou = true;
			} else {
				i++;
			}
		}
		if (achou) {
			return contas[i];
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unused")
	public void debitar (String numero, double valor) {
		Conta conta = procurar(numero);
		if (conta.saldo() < valor) {
			if (conta != null)
				conta.debitar(valor);
			else
				System.out.println("Conta Inexistente!");
		} else
			System.out.println("Saldo Insuficiente!");
		
	}
	
	public void creditar (String numero, double valor) {
		Conta conta = procurar(numero);
		if (conta != null) {
			conta.creditar(valor);
		} else 
			System.out.println("Conta Inexistente!");
	}

	public void transferir (String numero, String numero2, double valor) {
		Conta conta = procurar (numero);
		Conta conta2 = procurar (numero2);
		if (conta.saldo() < valor) {
			if (conta != null && conta2 != null) {
				conta.debitar(valor);
				conta2.creditar(valor);
			} else
				System.out.println("Contas Inexistentes!");
		} else
			System.out.println("Saldo Insuficiente!");
	}
	
	public void verSaldo (String numero) {
		Conta conta = procurar(numero);
		if (conta != null) {
			System.out.println("Seu saldo é: " + conta.saldo());
		} else
			System.out.println("Conta Inexistente!");
	}
}
