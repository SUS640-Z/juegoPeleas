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
	public static void jugar(Jugador jugador1, Jugador jugador2, Personaje[] personajes) {
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
			
			if(iPersonaje < 0 || iPersonaje >= personajes.length || personajes[iPersonaje] == null ){
				System.out.println("Ese indice no existe, intenta con otro");
			} else if(!personajes[iPersonaje].disponible){
				System.out.println("Ese personaje ya no esta disponible, intenta con otro");
			} else {
				for(int i = 0; i < jugador.personajesSelecionados.length; i++) {
					if(jugador.personajesSelecionados[i] == null) {
						jugador.personajesSelecionados[jugador.contPersonajes] = personajes[iPersonaje];
						personajes[iPersonaje].disponible = false;
						jugador.contPersonajes++;
						break;
					}
				}
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
	public static void batalla(Jugador jugador1, Jugador jugador2) {
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
	 * Esta funcion verifica si el personaje tiene algun efecto, y en caso de tenerlo aplica las restricciones correspondientes
	 * @param jugador jugador que sera verificado
	 */	
	public static int efectoActuando(Jugador jugador) {
		if(!jugador.personajesSelecionados[jugador.contPersonajes].tieneEfecto){
			return 0;
		}
		
		if(jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto.equals("Stuneado")) {
			System.out.println("[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" esta stuneado y no puede actuar este turno ]");
			jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto--;
			if(jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto == 0) {
				jugador.personajesSelecionados[jugador.contPersonajes].tieneEfecto = false;
				jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto = "";
				System.out.println("[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" ya no esta stuneado ]");
			}
			return 2;
		}

		if(jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto.equals("Congelado")) {
			System.out.println("[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" esta congelado y su precision esta reducida a la mitad ]");
			jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto--;
			if(jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto == 0) {
				jugador.personajesSelecionados[jugador.contPersonajes].tieneEfecto = false;
				jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto = "";
				System.out.println("[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" ya no esta congelado ]");
			}
			return 0;
		}

		return 0;
	}

	/**
	 * Acciones que puede hacer el jugador principal contra el jugador secundario
	 * @param principal jugador que realiza las acciones
	 * @param secundario jugador que sufre las acciones
	 */	
	public static void accionesBatalla(Jugador principal, Jugador secundario) {
		int movimiento = interfaz(principal);
		
		if(efectoActuando(principal) == 2) {
			return;
		}

		switch(movimiento) {
			case 1:
				principal.personajesSelecionados[principal.contPersonajes].atacar(secundario, secundario.contPersonajes);
				if(secundario.personajesSelecionados[secundario.contPersonajes].vidaActual <= 0) {
					secundario.personajesSelecionados[secundario.contPersonajes].vidaActual = 0;
					secundario.personajesSelecionados[secundario.contPersonajes].disponible = true;
					System.out.println("[ ¡"+secundario.personajesSelecionados[secundario.contPersonajes].nombre+" ha sido derrotado! ]");
					secundario.contPersonajes++;
					ganador(principal, secundario);
				}
				break;
				
			case 2:
				principal.personajesSelecionados[principal.contPersonajes].habilidad(secundario, secundario.contPersonajes);
				if(secundario.personajesSelecionados[secundario.contPersonajes].vidaActual <= 0) {
					secundario.personajesSelecionados[secundario.contPersonajes].vidaActual = 0;
					secundario.personajesSelecionados[secundario.contPersonajes].disponible = true;
					System.out.println("[ ¡"+secundario.personajesSelecionados[secundario.contPersonajes].nombre+" ha sido derrotado! ]");
					secundario.contPersonajes++;
					ganador(principal, secundario);
				}
				break;
				
			case 3:
				registroCombate.mostrarBitacora();
				break;
		}
	}
	
	/**
	 * Verifica si existe un ganador en el combate y termina el juego
	 * @param jugador1 Jugador de la ronda actual
	 * @param jugador2 Jugador de la siguiente ronda
	 */	
	public static boolean ganador(Jugador jugador1, Jugador jugador2) {
		if(jugador1.contPersonajes == 4){
			System.out.println("¡Felicidades " + jugador2.nombre + " has ganado el combate!");
			return true;
		} else if(jugador2.contPersonajes == 4) {
			System.out.println("¡Felicidades " + jugador1.nombre + " has ganado el combate!");
			return true;
		} else if(jugador1.contPersonajes == 4 && jugador2.contPersonajes == 4) {
			System.out.println("¡El combate acabo en empate!");
			return true;
		} else {
			return false;
		}
	}
}