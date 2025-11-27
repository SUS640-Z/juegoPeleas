package juego;
import java.util.Scanner;

/**
 * La clase menu muestra la intefaz del juego
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 1.1
 */
public class Menu {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int opcionMenu = 0;
		Bitacora registroCombate = new Bitacora();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Personaje[] personajes = new Personaje[8];

		// Espadachineses
		personajes[0] = new Espadachin("Memo", new Arma("Escalibur",1,70));
		personajes[1] = new Espadachin("Geremias",  new Arma("Escalibur",1,70));
		// Tanques
		personajes[2] = new Tanque("Juan Carlos de la Mancha", new Arma("Escalibur",1,70));
		personajes[3] = new Tanque("Leto",  new Arma("Escalibur",1,70));
		
		// Pistoleros
		personajes[4] = new Pistolero("Niño Tierra", new Arma("Escalibur",1,70));
		personajes[5] = new Pistolero("Mango Wizard", new Arma("Escalibur",1,70));

		while(opcionMenu != 4) {
			System.out.println(titulo());
			System.out.println("| 1. Jugar.");
			System.out.println("| 2. Personajes Disponibles.");
			System.out.println("| 3. Ver Reglas.");
			System.out.println("| 4. (Salir).");
			System.out.println("[ Ingresa una opcion ]: ");
			opcionMenu = in.nextInt();

			switch(opcionMenu) {
				case 1:
					//jugar(jugador1, jugador2, personajes);
					presionarEnter();
					break;
				case 2:
					presionarEnter();
					break;
				case 3:
					reglas();
					presionarEnter();
					break;
				case 4:
					System.out.println("[ ¡Gracias por jugar! ]");
					break;
			}
		}
	}

	public static String titulo() {
    return "  ___              _             ___ ___  ___   ___ _           _      _             ___ __ ___ ___               __ _   __    ___      _        \r\n"
    		+ " | _ \\_  _ _ _  __| |_  ___ ___ | _ \\ _ \\/ __| / __(_)_ __ _  _| |__ _| |_ ___ _ _  |_  )  \\_  ) __|  ___   __ __/ // | /  \\  | _ ) ___| |_ __ _ \r\n"
    		+ " |  _/ || | ' \\(_-< ' \\/ -_|_-< |   /  _/ (_ | \\__ \\ | '  \\ || | / _` |  _/ _ \\ '_|  / / () / /|__ \\ |___|  \\ V / _ \\ || () | | _ \\/ -_)  _/ _` |\r\n"
    		+ " |_|  \\_,_|_||_/__/_||_\\___/__/ |_|_\\_|  \\___| |___/_|_|_|_\\_,_|_\\__,_|\\__\\___/_|   /___\\__/___|___/         \\_/\\___/_(_)__/  |___/\\___|\\__\\__,_|\r\n"
    		+ "                                                                                                                                                 ";
    }

	public static void reglas() {
		System.out.println("[ \nReglas del juego ]");
		System.out.println("| 1. Los jugadores deberan ingresar un nombre por el cual se identifiquen.");
        System.out.println("| 2. El turno de los jugadores será decidido al azar.");
        System.out.println("| 3. El jugador podra decidir si atacar o usar su habilidad cuando sea turno.");
        System.out.println("| 4. Una vez realize su movimiento, el jugador tendra oportunidad de actuar.");
        System.out.println("| 5. Los turnos cambiaran intercaladamente por cada movimiento del jugador.");
        System.out.println("| 6. El combate termina cuando uno de los jugadores tenga todos personaje con vida actual 0.");
        in.nextLine();
	}

	public static void presionarEnter() {
		System.out.println("[ \nPresione ENTER para continuar... ]");
		in.nextLine();
	}

	public static void mostrarPersonajes(Personaje[] personajes) {
		for(int i = 0; i < personajes.length; i++) {
			/*
			if(personajes[i] != null && personajes[i].disponible) {
				System.out.println((i+1) + "." + personajes[i].nombre);
			}
			*/
		}
	}	
}
