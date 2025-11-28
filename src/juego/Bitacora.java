package juego;

/**
 * La clase bitacora registrar el historial de todos los movimientos del combate
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 */
public class Bitacora {
	String accion;
	Personaje atacante;
	Personaje objetivo;
	int danio;
	boolean critico;
	boolean fallo;

	String registros[] = new String[100];
	
	
	public void vaciarBitacora() {
		for(int i=0; i<registros.length; i++) {
			registros[i] = null;
		}
	}
	
	public void mostrarBitacora() {
		for(int i=0; i<registros.length; i++) {
			if(registros[i] != null) {
				System.out.println(registros[i]);
			}
		}
	}
	
	public void registrarTurnos() {
		
	}
	
}