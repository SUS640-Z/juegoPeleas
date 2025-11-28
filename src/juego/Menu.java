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

		// Espadachineses
		personajes[0] = new Espadachin("Cremo", new Arma("Escalibur",1,70));
		personajes[1] = new Espadachin("Geremias",  new Arma("Escalibur",1,70));
		// Tanques
		personajes[2] = new Tanque("Juan Carlos de la Mancha", new Arma("Escalibur",1,70));
		personajes[3] = new Tanque("Leto",  new Arma("Escalibur",1,70));
		
		// Pistoleros
		personajes[4] = new Pistolero("Señor Atomico", new Arma("Escalibur",1,70));
		personajes[5] = new Pistolero("Señor Lagarto", new Arma("Escalibur",1,70));

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

	public static String titulo() {
    return "  ___              _             ___ ___  ___   ___ _           _      _             ___ __ ___ ___               __ _   __    ___      _        \r\n"
    		+ " | _ \\_  _ _ _  __| |_  ___ ___ | _ \\ _ \\/ __| / __(_)_ __ _  _| |__ _| |_ ___ _ _  |_  )  \\_  ) __|  ___   __ __/ // | /  \\  | _ ) ___| |_ __ _ \r\n"
    		+ " |  _/ || | ' \\(_-< ' \\/ -_|_-< |   /  _/ (_ | \\__ \\ | '  \\ || | / _` |  _/ _ \\ '_|  / / () / /|__ \\ |___|  \\ V / _ \\ || () | | _ \\/ -_)  _/ _` |\r\n"
    		+ " |_|  \\_,_|_||_/__/_||_\\___/__/ |_|_\\_|  \\___| |___/_|_|_|_\\_,_|_\\__,_|\\__\\___/_|   /___\\__/___|___/         \\_/\\___/_(_)__/  |___/\\___|\\__\\__,_|\r\n"
    		+ "                                                                                                                                                 ";
    }

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

	public static void presionarEnter() {
		System.out.println("\n[ Presione ENTER para continuar... ]");
		in.nextLine();
		for(int i=0; i<1500; i++) {
			System.out.println("\n");
		}
	}


	public static void mostrarPersonajes(Personaje[] personajes) {
		for(int i = 0; i < personajes.length; i++) {
			if(personajes[i] != null) {
				System.out.println((i+1) + ". " + personajes[i].nombre +" - "+ personajes[i].mostrarClase());
			}
		}
	}	
	
	
	public static void jugar(Jugador jugador1,Jugador jugador2,Personaje[] personajes) {
		asignarNombreJugadores(jugador1,jugador2);
		int turno = (int) (Math.random() * 2)+1;
		while(jugador1.contPersonajes !=3 || jugador2.contPersonajes != 3) {
			if(turno == 1) {
				escoguerPersonajes(jugador1,personajes);
				turno=2;
			}else{
				escoguerPersonajes(jugador2,personajes);
				turno=1;
			}
		}
		
		batalla(jugador1,jugador2);
		
		
	}
		
	public static void asignarNombreJugadores(Jugador jugador1,Jugador jugador2) {
		in.nextLine();
		System.out.print("Ingresa nombre de jugador 1 --> ");
		String nombre1 = in.nextLine(); 
		System.out.print("Ingresa nombre de jugador 2 --> ");
		String nombre2 = in.nextLine();
		jugador1.nombre= nombre1;
		jugador2.nombre= nombre2;
	}
	
	public static void escoguerPersonajes(Jugador jugador,Personaje[] personajes) {
		int iPersonaje;
		do {
			System.out.println("\n"+jugador.nombre+" es turno de escoguer un personaje");
			mostrarPersonajes(personajes);
			System.out.print("Escribe el indice del personaje --> ");
			iPersonaje = in.nextInt();
			iPersonaje--;
			if(iPersonaje < 0 || iPersonaje > personajes.length) {
				System.out.println("No hay personaje en este indice\n");
		
			}
			/*
			if(personajes[iPersonaje] != null && !personajes[iPersonaje].disponible){
				System.out.println("Este personaje no esta disponible\n");
			}*/
		}while(iPersonaje < 0 || iPersonaje > personajes.length || !personajes[iPersonaje].disponible);
		System.out.println( personajes[iPersonaje].nombre+" se ha unido a tu equipo\n");
		jugador.personajesSelecionados[jugador.contPersonajes] = personajes[iPersonaje];
		personajes[iPersonaje].disponible=false;
		jugador.contPersonajes++;
		
		
	}
	
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
	
	public static void batalla(Jugador jugador1,Jugador jugador2) {
		jugador1.contPersonajes=0;
		jugador2.contPersonajes=0;
		int turno = (int) (Math.random() * 2)+1;
		while(jugador1.contPersonajes !=3 && jugador2.contPersonajes != 3) {
			if(turno == 1) {
				int movimiento=interfaz(jugador1);
				switch(movimiento) {
					case 1:
						jugador1.personajesSelecionados[jugador1.contPersonajes].atacar(jugador2, jugador2.contPersonajes);
						break;
						
					case 2:
						jugador1.personajesSelecionados[jugador1.contPersonajes].habilidad(jugador2, jugador2.contPersonajes);
						break;
						
					case 3:
						registroCombate.mostrarBitacora();
						break;
				}
				turno=2;
			}else{
				int movimiento=interfaz(jugador2);
				switch(movimiento) {
					case 1:
						jugador2.personajesSelecionados[jugador2.contPersonajes].atacar(jugador1, jugador1.contPersonajes);
						break;
						
					case 2:
						jugador2.personajesSelecionados[jugador2.contPersonajes].habilidad(jugador1, jugador1.contPersonajes);
						break;
						
					case 3:
						registroCombate.mostrarBitacora();
						break;
				}
				turno=1;
			}
		}
	}
	

	/*
	NOVATO
	*/
}