package view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import controller.OperacoesConta;

public class Main {
	
	public static void main(String[] args) {
		int permissao = 1;
		Semaphore s1 = new Semaphore(permissao);
		Semaphore s2 = new Semaphore (permissao);
		float saldo;
		float movimentacao;
		int opc;
		Random r = new Random();
		
		for (int codConta = 0; codConta < 20; codConta++) {
			opc = r.nextInt(2);
			saldo = r.nextFloat(3000);
			movimentacao = r.nextFloat(3000);
			Thread tConta = new OperacoesConta(codConta, saldo, movimentacao, opc, s1, s2);
			tConta.start();
		}
	}

}
