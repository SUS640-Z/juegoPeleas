package juego;


import java.util.Scanner;
//eyeyeyeyeyyeyeyeyeye
public class Menu {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int opcionMenu=0;
		Bitacora registroCombate= new Bitacora(); 
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		//Personaje personajes[] = new Personaje(8);
		//personajes[0] = new Espadachin();
		//personajes[1] = new Espadachin();
		//personajes[2] = new Espadachin();		
		//personajes[3] = new Espadachin();				
		//personajes[4] = new Espadachin();
		//personajes[5] = new Espadachin();
		//personajes[6] = new Espadachin();
		//personajes[7] = new Espadachin();
		while(opcionMenu != 4)
		{
			System.out.println(titulo());
			System.out.println();
			System.out.println("1. Jugar ");
			System.out.println("2. Personajes Disponibles ");
			System.out.println("3. Ver reglas ");
			System.out.println("4. Salir ");
			System.out.print("Ingresa una opcion: ");
			opcionMenu=in.nextInt();
			
			
			switch(opcionMenu) {
				case 1:
					jugar(jugador1,jugador2);
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
					System.out.println("Gracias por jugar");
					break;
			}
		}
		
	}
	
	public static String titulo() {
		return " _____ _ _____ _     _     ____   \r\n"
				+ "/__ __Y Y__ __Y \\ /\\/ \\   /  _ \\  \r\n"
				+ "  / \\ | | / \\ | | ||| |   | / \\|  \r\n"
				+ "  | | | | | | | \\_/|| |_/\\| \\_/|  \r\n"
				+ "  \\_/ \\_/ \\_/ \\____/\\____/\\____/  \r\n"
				+ "                                  ";
	}
	
	public static void reglas() {
		System.out.println("\nReglas del juego");
		System.out.println("1. Los jugadores deberan ingresar un nombre por el cual se identifiquen");
		System.out.println("2. El turno de los jugadores será decidido al azar");
		System.out.println("3. El jugador podra decidir si atacar o usar su habilidad cuando sea turno");
		System.out.println("4. Una vez realize su movimiento, el jugador tendra oportunidad de actuar");
		System.out.println("5. Los turnos cambiaran intercaladamente por cada movimiento del jugador");
		System.out.println("6. El combate termina cuando uno de los jugadores tenga todos personaje con vida actual 0");
		in.nextLine();
	}
	
	public static void presionarEnter( ) {
		System.out.println("\nPresiona enter para continuar...");
		in.nextLine();
	}
	
	public static void mostrarPersonajes() {
		
	}
	
	public static void jugar(Jugador jugador1,Jugador jugador2) {
		asignarNombreJugadores(jugador1,jugador2);
	}
	
	public static void asignarNombreJugadores(Jugador jugador1,Jugador jugador2) {
		int seguro=0;
		in.nextLine();
		System.out.print("Ingresa nombre de jugador 1 --> ");
		String nombre1 = in.nextLine(); 
		System.out.print("Ingresa nombre de jugador 2 --> ");
		String nombre2 = in.nextLine();
		jugador1.nombre= nombre1;
		jugador2.nombre= nombre2;
	}
}