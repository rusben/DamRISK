package judge;

import inout.InOut;
import risk.DamRISK;
import utils.Utils;

public class Judge {

	public static int iniciaTorn(String[] nomsJugadors) {
		int torn = Utils.rnd(nomsJugadors.length);
		System.out.println("Comença el jugador " + nomsJugadors[torn]);

		return torn;
	}

	public static void repartirTerritorisJugador(int[][] tauler, int nJugadors, int jugador, String[] nomsJugadors) {

		int nTerritoris = DamRISK.territoris.length / nJugadors;
		int restaTerritoris = DamRISK.territoris.length % nJugadors;

		int t = 0;
		for (int i = 0; i < nTerritoris; i++) {

			t = Utils.trobaPosicioLliure(tauler);
			// Jugador per defecte
			tauler[t][0] = jugador;
			// Exèrcit per defecte
			tauler[t][1] = 1;
		}

		// Mirem si resten territoris per repartir en funció del número de
		// jugadors

		if (restaTerritoris > 0 && jugador < restaTerritoris) {
			t = Utils.trobaPosicioLliure(tauler);
			tauler[t][0] = jugador;
			tauler[t][1] = 1;
		}

		InOut.printTerritorisJugador(tauler, jugador, nomsJugadors);
	}

	public static void assignarTropesJugador(int[][] tauler, int jugador, int nExercits) {

		int exercitsPosicio = 0;
		while (nExercits != 0) {
			for (int i = 0; i < tauler.length; i++) {
				// Assignem un exèrcit per defecte
				if (tauler[i][0] == jugador) {

					exercitsPosicio = InOut.demanarExercitsPosicio(tauler, i, nExercits);

					// Afegim exercits al territori
					tauler[i][1] += exercitsPosicio;
					// Eliminem exercits de les tropes disponibles
					nExercits -= exercitsPosicio;

					if (nExercits == 0) {
						System.out.println("Ja no et queden exèrcits per assignar.");
						break;
					}
				}
			}
		}
	}

	public static void inicialitzaTauler(int[][] tauler) {
		/**
		 * Inicialitzem el tauler sense jugadors, valor -1. Doncs el jugador 0
		 * existeix
		 */
		for (int i = 0; i < tauler.length; i++) {
			tauler[i][0] = -1;
			tauler[i][1] = -1;
		}

	}

	public static int calcularTropesAfegides(int[][] tauler, int torn) {
		// TODO

		/*
		 * - El número de territorios que ocupas: Al principio de cada turno el
		 * jugador cuenta el número de territorios que ocupa, lo divídirá entre
		 * tres (descarta la fracción) y el resultado es el número de ejércitos
		 * que recibe, siendo el 3 el número mínimo de ejércitos que debe
		 * recibir. Coloca los nuevos ejércitos en cualesquiera de los
		 * territorios que sean tuyos.
		 * 
		 * - El valor de los continentes que controlas: El control de un
		 * continente es la ocupación, por un jugador, de todos los territorios
		 * que componen al mismo. Al inicio del turno se recibirán ejércitos por
		 * cada continente bajo control de un jugador. Continente nº de tropas
		 * extra África 3 Oceanía 2 Asia 7 Europa 5 América del Norte 5 América
		 * del Sur 2
		 */
		
		return 3;

	}

	public static void atacar(int[][] tauler, int torn) {
		// TODO
		
		
	}
	
	
	public static void lluitaDaus(int[][] tauler, int nTropes, int territoriAtacant, int territoriDesti) {
		// Comprovar que territoriAtacant i territoriDesti siguin diferents
		
	}

	public static void redistribuirTropes(int[][] tauler, int torn) {
		// TODO
		
	}

	public static boolean hiHaGuanyador(int[][] tauler, int[][] infoJugadors) {
		// TODO
		return false;
	}

	public static int seguentTorn(int torn, int nJugadors) {
		
		// TODO 
		// Comprovar que el jugador següent té alguna tropa en algun territori 
		return (torn + 1) % nJugadors;
		
	}
}
