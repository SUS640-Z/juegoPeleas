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
	static Bitacora registroCombate = new Bitacora();
	public static void main(String[] args) {
		int opcionMenu = 0;
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Personaje[] personajes = new Personaje[8];

		
		// Paladines
		personajes[0] = new Paladin("Cremo", new Arma("Escalibur",1,70));
		personajes[1] = new Paladin("Geremias",  new Arma("Escalibur",1,70));
		// Tanques
		personajes[2] = new Tanque("Juan Carlos de la Mancha", new Arma("Escalibur",1,70));
		personajes[3] = new Tanque("Leto",  new Arma("Escalibur",1,70));
		
		// Vampiros
		personajes[4] = new Vampiro("Señor Atomico", new Arma("Escalibur",1,70));
		personajes[5] = new Vampiro("Señor Lagarto", new Arma("Escalibur",1,70));

		// Mago
		personajes[6] = new Mago("Mango Amarrillo", new Arma("Escalibur",1,70));
		personajes[7] = new Mago("Mango Verde", new Arma("Escalibur",1,70));
		

		while(opcionMenu != 4) {
			System.out.println(titulo());
			System.out.println("| 1. Jugar");
			System.out.println("| 2. Personajes Disponibles");
			System.out.println("| 3. Ver Reglas");
			System.out.println("| 4. Salir");
			System.out.print("[ Ingresa una opcion ]: ");
			opcionMenu = in.nextInt();

			switch(opcionMenu) {
				case 1:
					jugar(jugador1, jugador2, personajes);
					in.nextLine();
					presionarEnter();
					break;
				case 2:
					mostrarPersonajes(personajes);
					in.nextLine();
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
	
	/**
	 * Devuelve el titulo del juego
	 * @retur titulo del juego
	 */	
	public static String titulo() {
		return "  ___              _             ___ ___  ___   ___ _           _      _             ___ __ ___ ___               __ _   __    ___      _        \r\n"
	    		+ " | _ \\_  _ _ _  __| |_  ___ ___ | _ \\ _ \\/ __| / __(_)_ __ _  _| |__ _| |_ ___ _ _  |_  )  \\_  ) __|  ___   __ __/ // | /  \\  | _ ) ___| |_ __ _ \r\n"
	    		+ " |  _/ || | ' \\(_-< ' \\/ -_|_-< |   /  _/ (_ | \\__ \\ | '  \\ || | / _` |  _/ _ \\ '_|  / / () / /|__ \\ |___|  \\ V / _ \\ || () | | _ \\/ -_)  _/ _` |\r\n"
	    		+ " |_|  \\_,_|_||_/__/_||_\\___/__/ |_|_\\_|  \\___| |___/_|_|_|_\\_,_|_\\__,_|\\__\\___/_|   /___\\__/___|___/         \\_/\\___/_(_)__/  |___/\\___|\\__\\__,_|\r\n"
	    		+ "                                                                                                                                                 ";
    }
	
	/**
	 * Imprime las reglas del juego
	 */	
	public static void reglas() {
		System.out.println("\n[ Reglas del juego ]");
		System.out.println("| 1. Los jugadores deberan ingresar un nombre por el cual se identifiquen.");
        System.out.println("| 2. El turno de los jugadores será decidido al azar.");
        System.out.println("| 3. El jugador podra decidir si atacar o usar su habilidad cuando sea turno.");
        System.out.println("| 4. Una vez realize su movimiento, el jugador tendra oportunidad de actuar.");
        System.out.println("| 5. Los turnos cambiaran intercaladamente por cada movimiento del jugador.");
        System.out.println("| 6. El combate termina cuando uno de los jugadores tenga todos personaje con vida actual 0.");
        in.nextLine();
	}
	
	
	/**
	 * Manejar mejor la informacion presentada en pantalla
	 */	
	public static void presionarEnter() {
		System.out.println("\n[ Presione ENTER para continuar... ]");
		in.nextLine();
		for(int i=0; i<1000; i++) {
			System.out.println("\n");
		}
	}

	/**
	 * Imprime los personajes del juego
	 */	
	public static void mostrarPersonajes(Personaje[] personajes) {
		for(int i = 0; i < personajes.length; i++) {
			if(personajes[i] != null) {
				System.out.println((i+1) + ". " + personajes[i].nombre +" - "+ personajes[i].mostrarClase());
			}
		}
	}	
	
	/**
	 * Logica y funcionamiento del juego
	 */	
	public static void jugar(Jugador jugador1,Jugador jugador2,Personaje[] personajes) {
		asignarNombreJugadores(jugador1,jugador2);
		int turno = (int) (Math.random() * 2)+1;
		escogerPersonajes(jugador1,personajes);
		escogerPersonajes(jugador2,personajes);

		System.out.println(jugador1.nombre);
		mostrarPersonajes(jugador1.personajesSelecionados);
		System.out.println(jugador2.nombre);
		mostrarPersonajes(jugador2.personajesSelecionados);
		
		batalla(jugador1,jugador2);
		
		
	}
	
	/**
	 * Asignar nombre a los jugadores
	 * @param jugador1
	 * @param jugador2
	 */		
	public static void asignarNombreJugadores(Jugador jugador1,Jugador jugador2) {
		in.nextLine();
		System.out.print("Ingresa nombre de jugador 1 --> ");
		String nombre1 = in.nextLine(); 
		System.out.print("Ingresa nombre de jugador 2 --> ");
		String nombre2 = in.nextLine();
		jugador1.nombre= nombre1;
		jugador2.nombre= nombre2;
	}
	
	/**
	 * El jugador seleccionan 3 personajes a su eleccion(sin repeticiones)
	 * @param jugador usuario que escogue sus personajes
	 * @param personajes personajes disponible
	 */	
	public static void escogerPersonajes(Jugador jugador, Personaje[] personajes) {
		int iPersonaje;
		
		while(jugador.contPersonajes < 3) {
			System.out.println("\n"+jugador.nombre+" es turno de escoger un personaje");
			for(int i = 0; i < personajes.length; i++) {
				if(personajes[i] != null && personajes[i].disponible) {
					System.out.println((i+1) + ". " + personajes[i].nombre +" - "+ personajes[i].mostrarClase());
				}
			}
			
			System.out.print("Escribe el indice del personaje --> ");
			iPersonaje = in.nextInt();
			iPersonaje--;
			
			if(iPersonaje >= 0 && iPersonaje < personajes.length && personajes[iPersonaje] != null && personajes[iPersonaje].disponible) {
				for(int i = 0; i < jugador.personajesSelecionados.length; i++) {
					if(jugador.personajesSelecionados[i] == null) {
						jugador.personajesSelecionados[jugador.contPersonajes] = personajes[iPersonaje];
						personajes[iPersonaje].disponible = false;
						jugador.contPersonajes++;
						break;
					}
				}
			}
			else {
				System.out.println("Ese inidce no existe, intenta con otro");
			}
		}
	}
	/**
	 * Muestra las opciones disponibles por el jugador
	 * @param jugador el que debera realizar la accion
	 * @return devuelve la accion realizada por el jugador
	 */	
	public static int interfaz(Jugador jugador) {
		System.out.println("===== TURNO DEL JUGADOR "+jugador.nombre+" =====");
		System.out.println("Personaje activo: "+jugador.personajesSelecionados[jugador.contPersonajes].nombre +"("+jugador.personajesSelecionados[jugador.contPersonajes].mostrarClase()+")");
		System.out.println("Vida: "+jugador.personajesSelecionados[jugador.contPersonajes].vidaActual+" / "+jugador.personajesSelecionados[jugador.contPersonajes].vidaMaxima);
		System.out.println("Nivel: "+jugador.personajesSelecionados[jugador.contPersonajes].nivel);
		System.out.println("");
		System.out.println("1) Atacar");
		System.out.println("2) Usar habilidad");
		System.out.println("3) Ver registro de combate");
		int opcion=0;
		do {
			System.out.print("Introduce el indice --> ");
			opcion = in.nextInt();
			if(opcion < 1 || opcion > 3) {
				System.out.println("No disponible");
			}
		}while(opcion < 1 || opcion > 3);
		return opcion;
		
	}
	
	/**
	 * Sistema de batalla
	 * @param jugador1 usuario que se enfrentara a jugador 2
	 * @param jugador2 usuario que se enfrentara a jugador 1
	 */	
	public static void batalla(Jugador jugador1,Jugador jugador2) {
		jugador1.contPersonajes=0;
		jugador2.contPersonajes=0;
		int turno = (int) (Math.random() * 2)+1;
		while(jugador1.contPersonajes !=3 && jugador2.contPersonajes != 3) {
			if(turno == 1) {
				accionesBatalla(jugador1,jugador2);
				turno=2;
			}else{
				accionesBatalla(jugador2,jugador1);
				turno=1;
			}
		}
	}
	/**
	 * Acciones que puede hacer el jugador principal contra el jugador secundario
	 * @param principal jugador que realiza las acciones
	 * @param secundario jugador que sufre las acciones
	 */	
	public static void accionesBatalla(Jugador principal,Jugador secundario) {
		int movimiento=interfaz(principal);
		switch(movimiento) {
			case 1:
				principal.personajesSelecionados[principal.contPersonajes].atacar(secundario, secundario.contPersonajes);
				break;
				
			case 2:
				principal.personajesSelecionados[principal.contPersonajes].habilidad(secundario, secundario.contPersonajes);
				break;
				
			case 3:
				registroCombate.mostrarBitacora();
				break;
		}
	}
	
}