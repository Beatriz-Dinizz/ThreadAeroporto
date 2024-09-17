package view;

import java.util.Random;

import controller.ThreadAeroporto;

public class Principal {

	public static void main(String[] args) {
		for(int i = 1; i <= 12; i++) {
			String pista = escolherPista();
			
			ThreadAeroporto aviao = new ThreadAeroporto("Aeronave " + i, pista);
			
			aviao.start();
		}
	}
	
	private static String escolherPista() {
		Random random = new Random();
		
		return random.nextBoolean() ? "Norte" : "Sul";
	}
}
