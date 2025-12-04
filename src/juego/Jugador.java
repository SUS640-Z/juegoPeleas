package juego;

/**
 * La clase jugador permite identificar a los jugadores
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 * @param nombre identificador del jugador
 * @param personajesSelecionados personajes que fueron selecionados por el jugador
 * @param contPersonajes conocer el numero hasta ahora de elementos usados por personajesSeleccionados
 */
public class Jugador {
	String nombre;
	Personaje[] personajesSelecionados;
	int contPersonajes;
	
	Jugador(){
		personajesSelecionados = new Personaje[3];
		contPersonajes=0;
	}

	
}