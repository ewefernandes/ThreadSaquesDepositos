package controller;
import java.util.concurrent.Semaphore;

public class OperacoesConta extends Thread {
	
	private int codConta;
	private float saldo;
	private float movimentacao;
	private int opc;
	private Semaphore s1;
	private Semaphore s2;
	
	public OperacoesConta(int codConta, float saldo, float  movimentacao, int opc, Semaphore s1, Semaphore s2) {
		this.codConta = codConta;
		this.saldo = saldo;
		this.movimentacao = movimentacao;
		this.opc = opc;
		this.s1 = s1;
		this.s2 = s2;
	}

	public void run() {
		if (opc == 0) {
			try {
				s1.acquire();
				Depositar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s1.release();
		} else {
			try {
				s2.acquire();
				Sacar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s2.release();
		}
	}
	
	private void Depositar() {
		System.out.println("Conta #" +codConta+ " - Valor inicial = " +saldo);
		saldo = saldo + movimentacao;
		System.out.println("Conta #" +codConta+ " - Operacao = " +opc+ " - Novo valor = " +saldo);
	}
	
	private void Sacar() {
		System.out.println("Conta #" +codConta+ " - Operacao = " +opc+ " - Valor inicial = " +saldo);
		saldo = saldo - movimentacao;
		System.out.println("Conta #" +codConta+ " - Novo valor = " +saldo);
	}
	
}
