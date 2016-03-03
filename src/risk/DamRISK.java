package risk;

import java.util.Scanner;

import inout.InOut;
import judge.Judge;
import utils.Utils;

public class DamRISK {
	/**
	 * DEFINICIÓ DE CONSTANTS
	 */

	/**
	 * Véctor (array) amb els noms dels continents. La posició del continent
	 * dins del vector l'identifica en les diferents matrius o arrays on es
	 * relaciona. Seria la seva clau primària.
	 */
	public static final String[] continents = { "Amèrica Nord", "Amèrica Sud", "Àfrica", "Europa", "Àsia", "Oceania" };

	/**
	 * Vector (array) amb els noms dels territoris. Es relacionen amb el seu
	 * continent ja que el nombre de fila correspon a la posició del array
	 * continents.
	 *
	 * territoris[0] -> Correspondrà als territoris del continent[0] Amèrica del
	 * Nord territoris[1] -> Correspondrà als territoris del continent[1]
	 * Amèrica Sud
	 */
	public static final String[] territoris = { "Alaska", "Territorio del nor-oeste", "Groenlandia", "Alberta",
			"Ontario", "Labrador", "Territorio del oeste", "Territorio del este", "America central", "Venezuela",
			"Perú", "Argentina", "Brasil", "África del norte", "Egipto", "Africa Oriental", "Congo", "África del sur",
			"Magadascar", "Europa Occidental", "Gran Bretaña", "Islandia", "Escandinavia", "Europa del norte",
			"Europa del sur", "Ucrania", "Ural", "Afganistan", "Oriente Medio", "Siberia", "Yakutia", "Chita",
			"Kamchatka", "Mongolia", "Japon", "China", "Siam", "India", "Indonesia", "Nueva Guinea",
			"Australia Occidental", "Australia Oriental" };

	/**
	 * Matriu (array de dues dimensions) que ens permet identificar els païssos
	 * veïns i així poder moure exèrcits entre ells o atacar. Segons moment de
	 * la partida.
	 *
	 * veins[0] ens llista els territoris fronteres amb Alaska.
	 */
	public static final int[][] veins = { { 1, 3, 32 }, { 0, 2, 3, 4 }, { 1, 4, 5, 21 }, { 0, 1, 4, 6 },
			{ 1, 2, 3, 5, 6, 7 }, { 2, 4, 7 }, { 3, 4, 5, 7, 8 }, { 6, 4, 5, 8 }, { 6, 7, 9 }, { 8, 10, 12 },
			{ 9, 11, 12 }, { 10, 12 }, { 9, 10, 11, 13 }, { 12, 14, 15, 16, 19 }, { 13, 15, 24, 28 },
			{ 13, 14, 16, 17, 18 }, { 13, 15, 18 }, { 15, 17 }, { 20, 13, 23, 24 }, { 19, 21, 23, 22 }, { 20, 23, 2 },
			{ 21, 25, 23, 20 }, { 19, 20, 22, 24, 25 }, { 19, 20, 22, 24, 25 }, { 13, 14, 19, 23, 25 },
			{ 22, 23, 24, 26, 27, 28 }, { 25, 27, 28, 29 }, { 25, 26, 28, 37, 35 }, { 27, 37, 14 },
			{ 28, 31, 33, 34, 35 }, { 29, 31, 32 }, { 30, 31, 32, 33, 34, 0 }, { 29, 30, 32, 33 },
			{ 29, 31, 32, 34, 35 }, { 32, 33 }, { 29, 28, 27, 37, 36, 35 }, { 35, 37, 38 }, { 35, 36, 27, 28 },
			{ 40, 39, 36 }, { 38, 40, 41 }, { 38, 39, 41 }, { 40, 39 } };

	/**
	 * Véctor (array) amb els objectius del joc. La posició de l'objectiu dins
	 * del vector l'identifica en les diferents matrius o arrays on es
	 * relaciona. Seria la seva clau primària.
	 */
	public static final String[] objectius = { "Amèrica sur i Àfrica", "Amèrica del nord i Oceania", "Àfrica i Àsia" };

	/**
	 * Véctor (array) amb la quantitat d'exèrcits inicials. En la posició 0
	 * correspon a 3 jugadors i la posició 3 a 6 jugadors.
	 */
	public static final int[] exercitsInicials = { 35, 30, 25, 20 };

	/**
	 * Véctor (array) amb la quantitat d'exèrcits que guanyes per continent
	 * conquistat. En la posició 0 correspon a Amèrica del Nord i la 5 a
	 * Oceania.
	 */
	public static final int[] continentsComplets = { 5, 2, 3, 5, 7, 2 };

	/**
	 * Nombre que divideix els païssos conquerits per saber les unitats de
	 * reforç.
	 */
	public static final int divisioTerritori = 3;
	/**
	 * Nombre màxims de jugadors que poden jugar al DamRISK.
	 */
	public static final int maxJugadors = 6;
	/**
	 * Nombre mínim de jugadors que poden jugar al DamRISK.
	 */
	public static final int minJugadors = 3;

	/**
	 * Matriu (array de dues dimensions) que ens permet identificar a quin
	 * continent pertany cada païs. Com sempre juguem amb la posició dels arrays
	 * com a clau primària
	 *
	 * paissosContinent[0] són els païssos d'Amèrica del Nord
	 *
	 * paissosContinent[0][0] -> hi ha el territoris[0]
	 */
	public static final int[][] paissosContinent = { { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, { 9, 10, 11, 12 },
			{ 13, 14, 15, 16, 17, 18 }, { 19, 20, 21, 22, 23, 24, 25 },
			{ 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37 }, { 38, 39, 40, 41 } };

	// paissosContinent[0][0] = territoris[0];
	// paissosContinent[1][0] = territoris[9];
	// paissosContinent[2][0] = territoris[13];
	// paissosContinent[3][0] = territoris[19];
	// paissosContinent[4][0] = territoris[26];
	// paissosContinent[5][0] = territoris[38];

	public static void main(String[] args) {
		/**
		 * Matriu que representa el tauler de joc. Cada posició té un array on
		 * es guarda la informació següent {Id jugador, Número exercits} Cada
		 * posició és un territori.
		 */
		int[][] tauler = new int[territoris.length][2];

		Judge.inicialitzaTauler(tauler);

		/**
		 * Vector per guardar els noms dels jugadors. La posició dins del vector
		 * és l'identificador de jugador.
		 */
		String[] nomsJugadors = null;
		/**
		 * Matriu on guardem la informació del joc per a cada jugador. On
		 * guardem la informació del jugador. Per a cada jugador guardem
		 * nomsJugadors[0] li correspon la infoJugadors {objectiu, cavalleria,
		 * artilleria, cano, comodi }
		 */
		int[][] infoJugadors = null;

		/**
		 * Enter que indicarà el nombre de jugador que li toca tirar.
		 */
		int torn = 0;

		// Codi per demanar el nombre de jugadors
		int nJugadors = InOut.demanarNumeroJugadors();

		// Dimensionar els vectors nomsJugadors i infoJugadors
		nomsJugadors = new String[nJugadors];
		infoJugadors = new int[nJugadors][maxJugadors - 1];

		// Calcular nombre d'exèrcits inicials
		int nExercits = exercitsInicials[nJugadors - 3];
		
		// Tropes jugador
		int nTropes = 0;

		// Demanar les dades als jugadors i preparar-los per poder iniciar el
		// joc.
		for (int i = 0; i < nJugadors; i++) {

			// Demanar el nom i guardar-ho en el vector
			nomsJugadors[i] = InOut.demanarNomJugador(i);

			// Assignar objetiu
			infoJugadors[i][0] = Utils.rnd(objectius.length);

			InOut.printObjectiuJugador(i, infoJugadors);

			// Repartir territoris
			Judge.repartirTerritorisJugador(tauler, nJugadors, i, nomsJugadors);

			nTropes = Utils.calcularTropesJugador(tauler, i);
			
			// Assignar tropes
			Judge.assignarTropesJugador(tauler, i, nExercits - nTropes);

		}
		// Decidir qui comença a jugar i dir-ho per pantalla
		torn = Judge.iniciaTorn(nomsJugadors);
		InOut.printTauler(tauler, nomsJugadors);
		
		boolean guanyador = false;
		int tropesAfegides = 0;
		
		while (!guanyador) {
			
			// Fase de refuerzo
			tropesAfegides = Judge.calcularTropesAfegides(tauler, torn);
			Judge.assignarTropesJugador(tauler, torn, tropesAfegides);
			
			// Fase de ataque
			InOut.printTerritorisAtacables(tauler, torn);

			// Ataque
			Judge.atacar(tauler, torn);

			// Redistribución
			Judge.redistribuirTropes(tauler, torn);
			
			// Calcular si hay ganador
			guanyador = Judge.hiHaGuanyador(tauler, infoJugadors); 
			
			Judge.seguentTorn(torn, nJugadors);
		}

		InOut.printGuanyador(tauler);
		
		/**********************************************************************
		 * https://es.wikipedia.org/wiki/Risk
		 * 
		 * 
		 * ++ Refuerzo y ubicación de nuevos ejércitos
		 * 
		 * Al principio de cada turno, calcula cuantos nuevos ejércitos
		 * agregaras a tus territorios basado en:
		 * 
		 * - El número de territorios que ocupas: Al principio de cada turno el
		 * jugador cuenta el número de territorios que ocupa, lo divídirá entre
		 * tres (descarta la fracción) y el resultado es el número de ejércitos
		 * que recibe, siendo el 3 el número mínimo de ejércitos que debe
		 * recibir. Coloca los nuevos ejércitos en cualesquiera de los
		 * territorios que sean tuyos. Territorios Ocupados Número de Ejércitos
		 * < 9 3 9-11 3 12-14 4 15-17 5 18-20 6 21-23 7 24-26 8 27-29 9 30-32 10
		 * 33-35 11 36-38 12 39-41 13
		 * 
		 * - El valor de los continentes que controlas: El control de un
		 * continente es la ocupación, por un jugador, de todos los territorios
		 * que componen al mismo. Al inicio del turno se recibirán ejércitos por
		 * cada continente bajo control de un jugador. Continente nº de tropas
		 * extra África 3 Oceanía 2 Asia 7 Europa 5 América del Norte 5 América
		 * del Sur 2
		 * 
		 * ++ Ataque a los enemigos
		 * 
		 * Ejemplo de dados del atacante (rojos) y el defensor (blancos).
		 * Después de colocar los ejércitos al principio del turno, se decide si
		 * se desea atacar. El objeto del ataque es capturar un territorio al
		 * eliminar a los ejércitos del enemigo en ese territorio. Las batallas
		 * se dan por medio de los dados.
		 * 
		 * Si se decide no atacar, se pasa los dados al jugador a tu izquierda.
		 * Se pueden fortificar territorios, si así se desea. Si se decide
		 * atacar, se deben seguir estas reglas:
		 * 
		 * Solo se puede atacar a un territorio que esta adyacente (tocando) a
		 * un territorio propio, o bien conectado por una línea punteada.
		 * Ejemplos: Groenlandia puede atacar a los Territorios del Noroeste,
		 * Ontario, Quebec e Islandia. África del Norte puede atacar a Egipto,
		 * Europa del Oeste y Brasil. En las orillas este y oeste del tablero,
		 * se ve que Alaska está conectada (por lo tanto puede atacar) a
		 * Kamchatka. Se debe tener al menos 2 ejércitos en el territorio desde
		 * el cual se atacara. Se puede continuar atacando un territorio hasta
		 * que hayan sido eliminados todas las armadas enemigas en él, o se
		 * puede cambiar el territorio al que se ataca por otro. Se pueden
		 * realizar todos los ataques que se deseen durante el turno. Para
		 * atacar, primero se indica con cual territorio ataca, y cual es
		 * atacado, después los jugadores tiran los dados, avisando previamente
		 * cuantos dados van a tirar y lanzándolos al mismo tiempo. El atacante
		 * podrá tirar 1, 2 ó 3 dados, teniendo en cuenta que debe tener al
		 * menos un ejército más que el número de dados que desea tirar. Por
		 * otro lado, el defensor tirará 1 ó 2 dados, aunque para poder tirar
		 * dos dados deberá tener al menos 2 ejércitos en su territorio. En
		 * ambos casos, mientras más dados lancen, más posibilidades tienen de
		 * ganar pero, a la vez, más armadas pueden perder.
		 * 
		 * Para decidir el resultado de una batalla, se compara el dado más
		 * grande de cada jugador, si el número del dado del atacante es mayor,
		 * el defensor pierde una armada del territorio atacado. Pero si el dado
		 * del defensor es más grande, el atacante pierde una armada. Si ambos
		 * tiraron más de un dado, comparen ahora el segundo dado de cada uno, y
		 * repitan el proceso. En caso de empate, el defensor se ve favorecido
		 * y, por último, ningún jugador puede perder más de dos armadas por
		 * cada tirada de dados.
		 * 
		 * Tan pronto como se elimina a la última armada enemiga en un
		 * territorio, se considera capturado ese territorio y será ocuparlo
		 * inmediatamente. Para hacer esto se debe mover tantas o más armadas
		 * como dados usados durante la última batalla menos el número de
		 * armadas perdidas en el último combate. En la mayoría de los casos
		 * mover tantas armadas como se pueda es lo más ventajoso, porque las
		 * armadas dejadas atrás no pueden ayudar en un nuevo ataque.
		 * Finalmente, durante el juego todos los territorios deben estar
		 * ocupados al menos por una armada.
		 * 
		 * Se puede terminar el ataque de un jugador en cualquier momento, si
		 * así lo desea. Si se capturó al menos un territorio, el jugador tomará
		 * una carta Risk de la baraja (Sin importar cuantos territorios hayas
		 * capturado, siempre tomarás sólo una carta). Después se fortificarán
		 * las posiciones y, finalmente, se pasaran los dados al siguiente
		 * jugador.
		 * 
		 * 
		 * ++ Fortificación de posiciones
		 * 
		 * Antes de terminar su turno, un jugador puede fortificar sus
		 * posiciones sobre el campo de batalla, moviendo tantas armadas como
		 * desee desde un territorio de origen hacia un territorio adyacente
		 * (colindante). Una vez hecho esto, este jugador le entregará los dados
		 * (y el turno) al jugador que está a su derecha.
		 * 
		 * Al no haber territorios ocupados hay dos opciones: 1) se recorren
		 * ejércitos adyacentes de algún territorio colindante, perdiendo el
		 * turno de ataque. 2) se reconquistan los territorios no ocupados con
		 * soldados externos al juego, "caídos en combate", o por cambio de
		 * tarjetas. Perdiendo el turno de ataque.
		 * 
		 **********************************************************************/

	}
}