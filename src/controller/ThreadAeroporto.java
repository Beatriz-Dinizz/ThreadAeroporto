package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {
	private String nomeAviao;
	private String pista;
	private static Semaphore semaforoDecolagem = new Semaphore(2);

	public ThreadAeroporto(String nomeAviao, String pista) {
		this.nomeAviao = nomeAviao;
		this.pista = pista;		
	}
	
	@Override
	public void run() {
		try {
			manobra();
			taxiar();
			
			semaforoDecolagem.acquire();
				decolar();
				
			semaforoDecolagem.release();
				afastamentoArea();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void manobra() throws InterruptedException {
		int tempoMs = new Random().nextInt(300) + 400;
		System.out.println(nomeAviao + " está na pista " + pista + " manobrando por " + tempoMs + " ms.");
		Thread.sleep(tempoMs);
	}
	
	private void taxiar() throws InterruptedException {
		int tempoMs = new Random().nextInt(500) + 500;
		System.out.println(nomeAviao + " está na pista " + pista + " taxiando por " + tempoMs + " ms.");
		Thread.sleep(tempoMs);
	}
	
	private void decolar() throws InterruptedException {
		int tempoMs = new Random().nextInt(600) + 200;
		System.out.println(nomeAviao + " está na pista " + pista + " se preparando para decolar em " + tempoMs + " ms.");
		Thread.sleep(tempoMs);
	}
	
	private void afastamentoArea() throws InterruptedException {
		int tempoMs = new Random().nextInt(300) + 500;
		System.out.println(nomeAviao + " está se afastando por " + tempoMs + " ms.");
		Thread.sleep(tempoMs);
		
		System.out.println(nomeAviao + " completou a decolagem.");
	}
}
