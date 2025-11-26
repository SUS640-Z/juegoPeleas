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
	/* nigga estupido assholes*/
	//Novato Sensacion
	String accion;
	Personaje atacante;
	Personaje objetivo;
	int danio;
	boolean critico;
	boolean fallo;

	String registros[] = new String[10000];
	
	public void mostrarBitcora(){
		System.out.println("---------- BITACORA ----------");

		for(int i = 0; i < registros.length; i++){
			if(registros[i] != null){
				System.out.println(registros[i]);
			}
		}
	}
}