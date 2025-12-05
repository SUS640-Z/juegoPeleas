package juego;
import java.util.Scanner;

/**
 * La clase menu muestra la intefaz del juego
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 1.1
 * 
 */
public class Menu {
	static Scanner in = new Scanner(System.in);
	static Bitacora registroCombate = new Bitacora();
	static String ordenMuerte[] = new String[6];
	static int contadorMuerte = 0;
	public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";

	public static void main(String[] args) {
		int opcionMenu = 0;
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Personaje[] personajes = new Personaje[10];

		
		// Paladines
		personajes[0] = new Chango("Cremo", new Arma("Latigo mutilante",1,35));
		personajes[1] = new Chango("Geremias",  new Arma("Piedra dolorosa",3,15));
		// Tanques
		personajes[2] = new Tanque("Juan Carlos de la Mancha", new Arma("Mazo estruendoso",1,40));
		personajes[3] = new Tanque("Leto",  new Arma("Martillo antihigienico",3,25));
		
		// Vampiros
		personajes[4] = new Vampiro("Señor Atomico", new Arma("Colmillos filudos",2,25));
		personajes[5] = new Vampiro("Señor Lagarto", new Arma("Colmillos mordisqueantes",3,20));

		// Mago
		personajes[6] = new Mago("Mango Amarrillo", new Arma("Vara de la verdad",2,5));
		personajes[7] = new Mago("Mango Verde", new Arma("Baston de la falacia",1,10));
		personajes[8] = new Mago("Mago Sensacion", new Arma("Baston de la falacia",9999,9999));

		while(opcionMenu != 5) {
			restauracionPersonajes(personajes);
			System.out.println(tituloH());
			System.out.println(ANSI_CYAN+"[1]"+ANSI_RESET+" Jugar");
			System.out.println(ANSI_CYAN+"[2]"+ANSI_RESET+" Personajes Disponibles");
			System.out.println(ANSI_CYAN+"[3]"+ANSI_RESET+" Ver Reglas");
			System.out.println(ANSI_CYAN+"[4]"+ANSI_RESET+" Ver combate anterior");
			System.out.println(ANSI_CYAN+"[5]"+ANSI_RESET+" Salir");
			System.out.print("[ Ingresa una opcion ]: ");
			opcionMenu = in.nextInt();

			switch(opcionMenu) {
				case 1:
					jugar(jugador1, jugador2, personajes);
					presionarContinuar2();
					break;
				case 2:
					mostrarPersonajes2(personajes);
					break;
				case 3:
					reglas();
					presionarEnter();
					break;
				case 4:
					in.nextLine();
					registroCombate.mostrarBitacora();
					presionarEnter();
					break;
				case 5:
					System.out.println(ANSI_YELLOW+"[ ¡Gracias por jugar! ]");
					break;
				default:
					System.out.println(ANSI_YELLOW+"[ No existe esta opcion ]"+ANSI_RESET);
					in.nextLine();
					presionarEnter();
					break;
					
			}
		}
	}
	
	/**
	 * Devuelve el titulo del juego
	 * @return titulo del juego
	 */	
	
	public static String tituloG() {
		return ANSI_RED+"                                                                     \r\n"
				+ "                                                                     \r\n"
				+ "█████▄ ▄▄ ▄▄ ▄▄  ▄▄  ▄▄▄▄ ▄▄ ▄▄ ▄▄▄▄▄  ▄▄▄▄   █████▄  █████▄  ▄████  \r\n"
				+ "██▄▄█▀ ██ ██ ███▄██ ██▀▀▀ ██▄██ ██▄▄  ███▄▄   ██▄▄██▄ ██▄▄█▀ ██  ▄▄▄ \r\n"
				+ "██     ▀███▀ ██ ▀██ ▀████ ██ ██ ██▄▄▄ ▄▄██▀   ██   ██ ██      ▀███▀  \r\n"
				+ "                                                                     "+ANSI_RESET;
	}
	
	public static String tituloH() {
		return ANSI_RED+"                                                                              \r\n"
				+ "▄▄▄▄▄▄▄                     ▄▄                  ▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄    ▄▄▄▄▄▄▄  \r\n"
				+ "███▀▀███▄                   ██                  ███▀▀███▄ ███▀▀███▄ ███▀▀▀▀▀  \r\n"
				+ "███▄▄███▀ ██ ██ ████▄ ▄████ ████▄ ▄█▀█▄ ▄█▀▀▀   ███▄▄███▀ ███▄▄███▀ ███       \r\n"
				+ "███▀▀▀▀   ██ ██ ██ ██ ██    ██ ██ ██▄█▀ ▀███▄   ███▀▀██▄  ███▀▀▀▀   ███  ███▀ \r\n"
				+ "███       ▀██▀█ ██ ██ ▀████ ██ ██ ▀█▄▄▄ ▄▄▄█▀   ███  ▀███ ███       ▀██████▀  \r\n"
				+ "                                                                              \r\n"
				+ "                                                                              "+ANSI_RESET;
	}
	

	
	/**
	 * Imprime las reglas del juego
	 */	
	public static void reglas() {
		System.out.println(ANSI_YELLOW+"\n[ Reglas del juego ]"+ANSI_RESET);
		System.out.println(ANSI_YELLOW+"| "+ANSI_RESET+"1. Los jugadores deberan ingresar un nombre por el cual se identifiquen.");
        System.out.println(ANSI_YELLOW+"| "+ANSI_RESET+"2. El turno de los jugadores será decidido al azar.");
        System.out.println(ANSI_YELLOW+"| "+ANSI_RESET+"3. El jugador podra decidir si atacar o usar su habilidad cuando sea turno.");
        System.out.println(ANSI_YELLOW+"| "+ANSI_RESET+"4. Una vez realize su movimiento, el jugador tendra oportunidad de actuar.");
        System.out.println(ANSI_YELLOW+"| "+ANSI_RESET+"5. Los turnos cambiaran intercaladamente por cada movimiento del jugador.");
        System.out.println(ANSI_YELLOW+"| "+ANSI_RESET+"6. El combate termina cuando uno de los jugadores tenga todos personaje con vida actual 0.");
        in.nextLine();
	}
	
	/**
	 * Manejar mejor la informacion presentada en pantalla
	 */	
	public static void presionarEnter() {
		
		System.out.println(ANSI_YELLOW+"[ Presione ENTER para continuar... ]"+ANSI_RESET);
		in.nextLine();
		for(int i=0; i<1000; i++) {
			System.out.println("\n");
		}
	}

	/**
	 * Imprime los personajes del juego
	 * @param personajes arreglo con todos los personajes
	 */	
	public static void mostrarPersonajes(Personaje[] personajes) {
		for(int i = 0; i < personajes.length; i++) {
			if(personajes[i] != null) {
				System.out.println(ANSI_YELLOW+"["+(i+1) + "] "+ANSI_RESET + personajes[i].nombre +" - "+ personajes[i].mostrarClase());
			}
		}
	}	
	
	public static void mostrarPersonajes2(Personaje[] personajes) {
		in.nextLine();
		for(int i = 0; i < personajes.length; i++) {
			if(personajes[i] != null && personajes[i].disponible) {
				System.out.println(personajes[i].mostrarPresentacion());
				presionarContinuar2();
			}
		}
	}	
	
	/**
	 * Logica y funcionamiento del juego
	 * @param jugador1 es el jugador 1
	 * @param jugador2 es el jugador 2
	 * @parama personajes es el arreglo con todos los personajes
	 */	
	public static void jugar(Jugador jugador1, Jugador jugador2, Personaje[] personajes) {
		registroCombate.vaciarBitacora();
		in.nextLine();
		do {
			System.out.println();
			asignarNombreJugador(jugador1,1);
			asignarNombreJugador(jugador2,2);
			if(jugador1.nombre.equalsIgnoreCase(jugador2.nombre)){
				System.out.println(ANSI_YELLOW+"Los jugadores no se pueden llamar igual"+ANSI_RESET);
			}
		}while(jugador1.nombre.equalsIgnoreCase(jugador2.nombre));
		int confirmar=0;
		do {
			int turno = (int) (Math.random() * 2)+1;
			reseteoEquipo(jugador1);
			reseteoEquipo(jugador2);
			escogerPersonajes(jugador1, jugador2, personajes, turno);
			mostrarEquipo(jugador1);
			System.out.println();
			mostrarEquipo(jugador2);
			do {
			System.out.print("¿Confirmar equipos? "+ANSI_GREEN+"[1.Si]"+ANSI_RED +"[2.No]"+ANSI_RESET +"--> ");
			confirmar=in.nextInt();
			if(confirmar < 1 || confirmar > 2) {
				System.out.println(ANSI_YELLOW+"\nEsta opcion no coincide con ninguna de las disponibles"+ANSI_RESET);
			}
			}while(confirmar < 1 || confirmar > 2);
		}while(confirmar != 1);

		presionarContinuar();
		
		batalla(jugador1, jugador2, personajes);
	}
	
	/**
	 * Asigna un nombre a un jugador 
	 * @param jugador jugador que recive el nombre
	 * @param num numero del jugador
	 */	
	public static void asignarNombreJugador(Jugador jugador,int num) {
		String nombre;
		do {
		System.out.print(ANSI_CYAN+"Ingresa nombre de jugador "+num+" --> "+ANSI_RESET);
		nombre = in.nextLine(); 
		if(nombre.trim().isEmpty()) {
			System.out.println(ANSI_YELLOW+"No puede estar vacio tu nombre\n"+ANSI_RESET);
		}
		}while(nombre.trim().isEmpty());

		jugador.nombre= nombre;
	}
	
	/**
	 * El jugador seleccionan 3 personajes a su eleccion(sin repeticiones)
	 * @param jugador usuario que escogue sus personajes
	 * @param personajes personajes disponible
	 */
    public static void escogerPersonajes(Jugador jugador1, Jugador jugador2, Personaje[] personajes, int turno) {
        int iPersonaje;

        while(jugador1.contPersonajes < 3 || jugador2.contPersonajes < 3) {
            System.out.print(ANSI_CYAN);
            System.out.println((turno == 1) ? ("\n"+jugador1.nombre+" es turno de escoger un personaje") : ("\n"+jugador2.nombre+" es turno de escoger un personaje"));
            System.out.print(ANSI_RESET);

            for(int i = 0; i < personajes.length; i++) {
                if(personajes[i] != null && personajes[i].disponible) {
                    System.out.println(ANSI_YELLOW+"["+(i+1) + "] "+ANSI_RESET + personajes[i].nombre +" - "+ personajes[i].mostrarClase());
                }
            }

            System.out.print("Escribe el indice del personaje --> ");
            iPersonaje = in.nextInt();
            iPersonaje--;

            if (iPersonaje >= 0 && iPersonaje < personajes.length && personajes[iPersonaje] != null && personajes[iPersonaje].disponible) {
                boolean personajeYaElegido = false;

                for (int j = 0; j < jugador1.personajesSelecionados.length; j++) {
                    if (jugador1.personajesSelecionados[j] == personajes[iPersonaje]) {
                        personajeYaElegido = true;
                        break;
                    }
                }
                for (int j = 0; j < jugador2.personajesSelecionados.length; j++) {
                    if (jugador2.personajesSelecionados[j] == personajes[iPersonaje]) {
                        personajeYaElegido = true;
                        break;
                    }
                }

                if (personajeYaElegido) {
                    System.out.println(ANSI_YELLOW + "[ ¡Este personaje ya ha sido elegido! Escoge otro personaje. ]" + ANSI_RESET);
                } else {
                    for (int i = 0; i < jugador1.personajesSelecionados.length; i++) {
                        if (turno == 1) {
                            if (jugador1.personajesSelecionados[i] == null) {
                                jugador1.personajesSelecionados[jugador1.contPersonajes] = personajes[iPersonaje];
                                personajes[iPersonaje].disponible = false;
                                jugador1.contPersonajes++;
                                turno = 2;
                                break;
                            }
                        }
                        else {
                            if (jugador2.personajesSelecionados[i] == null) {
                                jugador2.personajesSelecionados[jugador2.contPersonajes] = personajes[iPersonaje];
                                personajes[iPersonaje].disponible = false;
                                jugador2.contPersonajes++;
                                turno = 1;
                                break;
                            }
                        }
                    }
                }
            } else {
                System.out.println(ANSI_YELLOW + "[ Opción no válida. Por favor, elige un personaje disponible. ]" + ANSI_RESET);
            }
            presionarContinuar();
        }
    }

    /**
	 * Muestra las opciones disponibles por el jugador
	 * @param jugador el que debera realizar la accion
	 * @return devuelve la accion realizada por el jugador
	 */	
	public static int interfaz(Jugador jugador) {
		System.out.println(ANSI_CYAN+"=================== Turno de "+jugador.nombre+" ==================="+ANSI_RESET);
		System.out.println("Personaje activo: "+ANSI_YELLOW+jugador.personajesSelecionados[jugador.contPersonajes].nombre +"("+jugador.personajesSelecionados[jugador.contPersonajes].mostrarClase()+")"+ANSI_RESET);
		System.out.print("Vida: "+ANSI_YELLOW+jugador.personajesSelecionados[jugador.contPersonajes].vidaActual+" / "+jugador.personajesSelecionados[jugador.contPersonajes].vidaMaxima+ANSI_RESET);
		System.out.print("\t\t | Mana: "+ANSI_YELLOW+jugador.personajesSelecionados[jugador.contPersonajes].manaActual+" / "+jugador.personajesSelecionados[jugador.contPersonajes].manaMaximo+ANSI_RESET +"\n");
		System.out.print("Nivel: "+jugador.personajesSelecionados[jugador.contPersonajes].nivel);
		if(jugador.personajesSelecionados[jugador.contPersonajes].tieneEfecto) {
			System.out.print("\t\t | Efecto de estado: "+jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto+" ("+jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto+" turnos restantes)\n");
		}else {
			System.out.print("\t\t | Efecto de estado: Ninguno\n");
		}
		System.out.print("Experiencia: " + jugador.personajesSelecionados[jugador.contPersonajes].experiencia);
		System.out.print("\t\t | Precision: " + jugador.personajesSelecionados[jugador.contPersonajes].precision + "% \n");
		System.out.print("Critico: " + jugador.personajesSelecionados[jugador.contPersonajes].arma.getProbabilidadCritico() + "%");
		System.out.print("\t\t | Armadura: " + jugador.personajesSelecionados[jugador.contPersonajes].armadura + " \n");
		System.out.println("");
		System.out.println(ANSI_CYAN+"[1]"+ANSI_RESET+" Atacar");
		System.out.println(ANSI_CYAN+"[2]"+ANSI_RESET+" Usar habilidad");
		System.out.println(ANSI_CYAN+"[3]"+ANSI_RESET+" Ver registro de combate");
		int opcion=0;
		do {
			System.out.print("Introduce el indice --> ");
			opcion = in.nextInt();
			if(opcion < 1 || opcion > 3) {
				System.out.println(ANSI_YELLOW+"Opcion No disponible"+ANSI_RESET);
			}
		}while(opcion < 1 || opcion > 3);
		return opcion;
		
	}
	
	/**
	 * Sistema de batalla
	 * @param jugador1 usuario que se enfrentara a jugador 2
	 * @param jugador2 usuario que se enfrentara a jugador 1
	 * @param personajes arreglo con todos los personajes
	 */	
	public static void batalla(Jugador jugador1, Jugador jugador2, Personaje[] personajes) {
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
		ganador(jugador1, jugador2);
		resumenDelCombate(jugador1, jugador2, personajes);
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
			
			String consecuenciasEfecto;
			registroCombate.turno--;
			consecuenciasEfecto = ANSI_RED + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" esta stuneado y no puede actuar este turno ]\n" + ANSI_RESET;
			System.out.print(ANSI_RED + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" esta stuneado y no puede actuar este turno ]\n" + ANSI_RESET);
			if(jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto == 0) {
				jugador.personajesSelecionados[jugador.contPersonajes].tieneEfecto = false;
				jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto = "";
				System.out.print(ANSI_CYAN + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" ya no esta stuneado ]\n" + ANSI_RESET);
				consecuenciasEfecto += ANSI_CYAN + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" ya no esta stuneado ]\n" + ANSI_RESET;
			}
			registroCombate.registrarEfecto(consecuenciasEfecto);
			registroCombate.turno++;
			jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto--;
			return 1;
		}

		if(jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto.equals("Congelado")) {
			registroCombate.turno--;
			String consecuenciasEfecto;
			consecuenciasEfecto = ANSI_RED + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" esta congelado y su precision esta reducida a la mitad ]\n" + ANSI_RESET;
			System.out.print(ANSI_RED + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" esta congelado y su precision esta reducida a la mitad ]\n" + ANSI_RESET);
			if(jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto == 0) {
				jugador.personajesSelecionados[jugador.contPersonajes].tieneEfecto = false;
				jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto = "";
				System.out.print(ANSI_CYAN + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" ya no esta congelado ]\n" + ANSI_RESET);
				consecuenciasEfecto += ANSI_CYAN + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" ya no esta congelado ]\n" + ANSI_RESET;
			}			
			registroCombate.registrarEfecto(consecuenciasEfecto);
			registroCombate.turno++;
			jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto--;
			return 2;
		}

		if(jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto.equals("Sangrado")) {
			String consecuenciasEfecto;
			registroCombate.turno--;
			consecuenciasEfecto =ANSI_RED + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" tiene sangrado y pierde 5 de vida cada turno con sangrado ]\n" + ANSI_RESET;
			System.out.print(ANSI_RED + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" tiene sangrado y pierde 5 de vida cada turno con sangrado ]\n" + ANSI_RESET);
			if(jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto == 0) {
				jugador.personajesSelecionados[jugador.contPersonajes].tieneEfecto = false;
				jugador.personajesSelecionados[jugador.contPersonajes].tipoEfecto = "";
				System.out.print(ANSI_CYAN + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" ya no esta sangrando ]\n" + ANSI_RESET);
				consecuenciasEfecto += ANSI_CYAN + "[ "+jugador.personajesSelecionados[jugador.contPersonajes].nombre+" ya no esta sangrando ]\n" + ANSI_RESET;
			}			
			registroCombate.registrarEfecto(consecuenciasEfecto);
			registroCombate.turno++;
			jugador.personajesSelecionados[jugador.contPersonajes].duracionEfecto--;
			return 3;
		}

		return 0;
	}

	/**
	 * Acciones que puede hacer el jugador principal contra el jugador secundario
	 * @param principal jugador que realiza las acciones
	 * @param secundario jugador que sufre las acciones
	 */
    public static void accionesBatalla(Jugador principal, Jugador secundario) {
        int efecto = efectoActuando(principal);
        if (efecto == 1) {
            return;
        }

        if (efecto == 3) {
        	registroCombate.turno--;
            String consecuenciasEfecto;
            principal.personajesSelecionados[principal.contPersonajes].vidaActual -= 5;
            System.out.println(ANSI_RED + "[ " + principal.personajesSelecionados[principal.contPersonajes].nombre + " perdió 5 de vida por el sangrado ]" + ANSI_RESET);
            consecuenciasEfecto = ANSI_RED +"[ " + principal.personajesSelecionados[principal.contPersonajes].nombre + " perdió 5 de vida por el sangrado ]"+ ANSI_RESET;
            if (principal.personajesSelecionados[principal.contPersonajes].vidaActual <= 0) {
                principal.personajesSelecionados[principal.contPersonajes].vidaActual = 0;
                principal.personajesSelecionados[principal.contPersonajes].disponible = true;
                System.out.println(ANSI_RED + "[ ¡" + principal.personajesSelecionados[principal.contPersonajes].nombre + " ha sido derrotado! ]" + ANSI_RESET);
                consecuenciasEfecto += ANSI_RED +"[ ¡" + principal.personajesSelecionados[principal.contPersonajes].nombre + " ha sido derrotado! ]"+ ANSI_RESET;
                principal.contPersonajes++;
                return;
            }
            registroCombate.registrarEfecto(consecuenciasEfecto);
            registroCombate.turno++;
        }

		if(efecto == 2) {
			principal.personajesSelecionados[principal.contPersonajes].precision /= 2;
		}
		boolean repetir=false;
		int movimiento=0;
		do {
			repetir=false;
			movimiento = interfaz(principal);
			
			switch(movimiento) {
				case 1:
					String accion=principal.personajesSelecionados[principal.contPersonajes].atacar(secundario, secundario.contPersonajes);
					System.out.println(accion);
					boolean turnoGuardado=false;
					
					if(secundario.personajesSelecionados[secundario.contPersonajes].vidaActual <= 0) {
						secundario.personajesSelecionados[secundario.contPersonajes].vidaActual = 0;
						secundario.personajesSelecionados[secundario.contPersonajes].disponible = true;
						System.out.println(ANSI_RED + "[ ¡"+secundario.personajesSelecionados[secundario.contPersonajes].nombre+" ha sido derrotado!, "+secundario.nombre+" perdio un miembro del equipo ]"+ ANSI_RESET);
						
						accion+=(ANSI_RED+ "[ ¡"+secundario.personajesSelecionados[secundario.contPersonajes].nombre+" ha sido derrotado!, "+secundario.nombre+" perdio un miembro del equipo ] "+ ANSI_RESET);
						registroCombate.registrarAtaque(principal.personajesSelecionados[principal.contPersonajes],secundario.personajesSelecionados[secundario.contPersonajes],accion);
						turnoGuardado=true;
						
						secundario.contPersonajes++;
					}
					if(efecto == 2) {
						principal.personajesSelecionados[principal.contPersonajes].precision *= 2;
			    	}
					if(!turnoGuardado) {
						registroCombate.registrarAtaque(principal.personajesSelecionados[principal.contPersonajes],secundario.personajesSelecionados[secundario.contPersonajes],accion);
					}
					break;
					
				case 2:
					if(principal.personajesSelecionados[principal.contPersonajes].manaActual >= principal.personajesSelecionados[principal.contPersonajes].manaHabilidad){
						String accionH=principal.personajesSelecionados[principal.contPersonajes].habilidad(secundario, secundario.contPersonajes);
						System.out.println(accionH);
						boolean turnoGuardadoH=false;
						
						if(secundario.personajesSelecionados[secundario.contPersonajes].vidaActual <= 0) {
							secundario.personajesSelecionados[secundario.contPersonajes].vidaActual = 0;
							secundario.personajesSelecionados[secundario.contPersonajes].disponible = true;
							System.out.println(ANSI_YELLOW + "[ ¡"+secundario.personajesSelecionados[secundario.contPersonajes].nombre+" ha sido derrotado! ]" + ANSI_RESET);
							
							accionH+=("\n[ ¡"+secundario.personajesSelecionados[secundario.contPersonajes].nombre+" ha sido derrotado! ]");
							registroCombate.registrarHabilidad(principal.personajesSelecionados[principal.contPersonajes],secundario.personajesSelecionados[secundario.contPersonajes],accionH);
							turnoGuardadoH=true;
							
							secundario.contPersonajes++;
						}
						if(efecto == 2) {
							principal.personajesSelecionados[principal.contPersonajes].precision *= 2;
				    	}	
						
						if(!turnoGuardadoH) {
							registroCombate.registrarHabilidad(principal.personajesSelecionados[principal.contPersonajes],secundario.personajesSelecionados[secundario.contPersonajes],accionH);
						}
					}else {
						System.out.println(ANSI_RED+"Mana Insuficiente"+ANSI_RESET);
						repetir= true;
					}
					break;
					
				case 3:
					registroCombate.mostrarBitacora();	
					break;
			}
			presionarContinuar();
		}while(movimiento == 3 || (movimiento==2 && repetir) );
		registroCombate.turno++;
	}
	
	/*
	 * Verifica si existe un ganador en el combate y termina el juego
	 * @param jugador1 Jugador de la ronda actual
	 * @param jugador2 Jugador de la siguiente ronda
	 */	
	public static boolean ganador(Jugador jugador1, Jugador jugador2) {
		if(jugador1.contPersonajes == 3){
			System.out.println(ANSI_GREEN + "¡Felicidades " + jugador2.nombre + " has ganado el combate!" + ANSI_RESET);
			return true;
		}
		if(jugador2.contPersonajes == 3) {
			System.out.println(ANSI_GREEN + "¡Felicidades " + jugador1.nombre + " has ganado el combate!" + ANSI_RESET);
			return true; 
		}
		if(jugador1.contPersonajes == 3 && jugador2.contPersonajes == 3) {
			System.out.println(ANSI_YELLOW + "¡El combate acabo en empate!" + ANSI_RESET);
			return true;
		} 
		return false;
	}
	
	/**
	 * Mejora la experiencia del usuario
	 */	
	public static void presionarContinuar() {
		in.nextLine();
		System.out.println(ANSI_YELLOW+"[ Presione ENTER para continuar... ]"+ANSI_RESET);
		in.nextLine();
	}
	
	/**
	 * Mejora la experiencia del usuario
	 */	
	public static void presionarContinuar2() {
		System.out.println(ANSI_YELLOW+"[ Presione ENTER para continuar... ]"+ANSI_RESET);
		in.nextLine();
	}
	
	/**
	 * Restablece todos los atributos al maximo de jugador
	 * @param personajes arreglo con todos los personajes
	 */	
	public static void restauracionPersonajes(Personaje[] personajes) {
		for(int i=0; i<personajes.length; i++) {
			if(personajes[i] != null) {
				personajes[i].disponible=true;
				personajes[i].vidaActual=personajes[i].vidaMaxima;
				personajes[i].manaActual=personajes[i].manaMaximo;
				personajes[i].tieneEfecto=false;
			}
		}
	}
	
	/**
	 * Borra los personajes del equipo del jugador
	 * @param jugador 
	 */	
	public static void reseteoEquipo(Jugador jugador) {
		for(int i=0; i<jugador.personajesSelecionados.length; i++) {
			jugador.personajesSelecionados[i] = null;
		}
		jugador.contPersonajes=0;
	}

	/**
	 * Muestra el equipo de personajes del jugador
	 * @param jugador
	 */	
	public static void mostrarEquipo(Jugador jugador) {
		System.out.println(ANSI_CYAN+"Equipo de "+jugador.nombre+ANSI_RESET);
		mostrarPersonajes(jugador.personajesSelecionados);
	}

	public static void imprimirMuertesYGanador(Personaje[] personajes) {
		System.out.println(ANSI_CYAN + "\nOrden de muertes: " + ANSI_RESET);
		for(int i=0; i < ordenMuerte.length; i++) {
			if(ordenMuerte[i] != null) {
				System.out.println((i+1)+". "+ordenMuerte[i]);
			} 
		}

		System.out.println(ANSI_CYAN + "\nGanador del combate: " + ANSI_RESET);
		if(ordenMuerte[5] == null || ordenMuerte[5].equals("")) {
			for(int i=0; i < personajes.length; i++) {
				if(personajes[i] != null && !personajes[i].disponible) {
					System.out.println(ANSI_GREEN + "[ " + personajes[i].nombre + " ]" + ANSI_RESET);
					return;
				}
			}
		} else {
			System.out.println("Empate");
		} 
	}

	/**
	 * Imprime las estadisticas completas de cada personaje
	 * @param jugador1 es el juagador 1
	 * @param jugador2 es el jugador 2
	 */
	public static void imprimirEstadisticasCompletas(Jugador jugador1, Jugador jugador2) {
		for(int i = 0; i < jugador1.personajesSelecionados.length; i++) {
			if(jugador1.personajesSelecionados[i] != null) {
				System.out.println("------------------------------------------------");
				System.out.println(ANSI_CYAN + "Personaje: " + jugador1.personajesSelecionados[i].nombre + ANSI_RESET);
				System.out.println("Daño Total Inflingido:    " + jugador1.personajesSelecionados[i].danioTotal);
				System.out.println("Críticos Acertados:      " + jugador1.personajesSelecionados[i].arma.getNumeroDeCriticos());
				System.out.println("Habilidades Usadas:   " + jugador1.personajesSelecionados[i].numeroDeHabilidadesUsadas);
				System.out.println("Nivel Final:   " + jugador1.personajesSelecionados[i].nivel);
			}
		}

		for(int i = 0; i < jugador2.personajesSelecionados.length; i++) {
			if(jugador2.personajesSelecionados[i] != null) {
				System.out.println("------------------------------------------------");
				System.out.println(ANSI_CYAN + "Personaje: " + jugador2.personajesSelecionados[i].nombre + ANSI_RESET);
				System.out.println("Daño Total Inflingido:    " + jugador2.personajesSelecionados[i].danioTotal);
				System.out.println("Críticos Acertados:      " + jugador2.personajesSelecionados[i].arma.getNumeroDeCriticos());
				System.out.println("Habilidades Usadas:   " + jugador2.personajesSelecionados[i].numeroDeHabilidadesUsadas);
				System.out.println("Nivel Final:   " + jugador2.personajesSelecionados[i].nivel);
			}
		}
		System.out.println("------------------------------------------------");
	}

	/**
	 * reinicia el orden de muertes
	 */
	public static void reiniciarOrdenMuerte() {
		for(int i = 0; i < ordenMuerte.length; i++) {
			ordenMuerte[i] = null;
		}
		contadorMuerte = 0;
	}

	
	/**
	 * Imprime un resumen del combate
	 * 
	 * @param jugador1 es el jugador 1
	 * @param jugador2 es el jugador 2 
	 * @param personajes es el arreglo con todos los personajes
	 */
	public static void resumenDelCombate(Jugador jugador1, Jugador jugador2, Personaje[] personajes) {
		System.out.println(ANSI_CYAN + "\n=== RESUMEN DEL COMBATE ===" + ANSI_RESET);
		imprimirMuertesYGanador(personajes);
		imprimirEstadisticasCompletas(jugador1, jugador2);
		reiniciarOrdenMuerte();
	}
}