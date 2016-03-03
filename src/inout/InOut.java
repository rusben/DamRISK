package inout;

import java.util.Scanner;
import risk.DamRISK;


public class InOut {
	
	public static int demanarNumeroJugadors() {

		// Java.util.Scanner ens permet llegir de consola les dades dels usuaris
		Scanner scanner = new Scanner(System.in);
		int nJugadors = 0;

		System.out.println("Indica el número de jugadors (mínim " + DamRISK.minJugadors + " i màxim " + DamRISK.maxJugadors + ")?");
		do {
			// Si a l'scanner hi ha un enter
			if (scanner.hasNextInt()) {
				// Llegim l'enter
				nJugadors = scanner.nextInt();
			} else // Avancem la posició de l'scanner per descatar la línia
				scanner.next();
		} while (nJugadors < DamRISK.minJugadors || nJugadors > DamRISK.maxJugadors);
		// Si aquest enter està entre minJugadors i maxJugadors ja tenim
		// un número vàlid de jugadors
		return nJugadors;
	}
	
	public static String demanarNomJugador(int jugador) {
		Scanner scanner = new Scanner(System.in);

		String nom = "";
		System.out.println("Indica el nom del jugador " + (jugador + 1) + ".");

		do {
			nom = (scanner.hasNext() ? scanner.next() : "");
		} while (nom.length() <= 0);

		return nom;
	}
	
	public static void printObjectiuJugador(int jugador, int[][] infoJugadors) {
		System.out.println("L'objectiu és " + DamRISK.objectius[infoJugadors[jugador][0]]);
	}

	public static void printTauler(int[][] tauler, String[] nomsJugadors) {
		for (int i = 0; i < tauler.length; i++) {
			System.out.println(DamRISK.territoris[i] + "-" + nomsJugadors[tauler[i][0]] + "-" + tauler[i][1]);
		}
	}
	
	public static void printTerritorisJugador(int[][] tauler, int jugador, String[] nomsJugadors) {

		System.out.println("Aquests són els teus territoris...");

		for (int i = 0; i < tauler.length; i++) {
			if (tauler[i][0] == jugador) {
				System.out.println(DamRISK.territoris[i] + " - " + nomsJugadors[jugador] + " - " + tauler[i][1]);
			}
		}
		System.out.println();
	}
	
	public static int demanarExercitsPosicio(int[][] tauler, int i, int maxExercits) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Actualment tens " + tauler[i][1] + " exèrcits en el territori " + DamRISK.territoris[i]);
		System.out.println("Indica quants exèrcits vols afegir més (mínim 0 i màxim " + maxExercits + ")");

		int nExercits = 0;
		do {
			nExercits = (scanner.hasNextInt() ? scanner.nextInt() : 0);
		} while (nExercits < 0 || nExercits > maxExercits);

		return nExercits;
	}

	public static void printTerritorisAtacables(int[][] tauler, int torn) {
		// TODO
		
	}
	
	public static int demanarOrigenAtac(int tauler, int jugador) {
		// Muestra los territorios que tienen más de dos tropas
		return -1;
	}
	
	public static int demanarDestiAtac(int tauler, int jugador) {
		
		return -1;
	}

	public static int printGuanyador(int[][] tauler) {
		// TODO
		return 0;
	} 
	


}
