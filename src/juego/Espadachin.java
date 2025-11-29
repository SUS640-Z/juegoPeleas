package juego;

/**
 * La clase espadachin hijo de clse personaje
 * Establece estadisticas y movimientos de espadachin
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 */
public class Espadachin extends Personaje{
	
	Espadachin(String nombre, Arma arma){
		super(nombre, 70, 70, 80, 95, 15, new Arma("Espada", 15, 95), 1, 0, false, "", 0, 0, 0);
	}

	@Override
	public boolean atacar(Jugador objetivo, int indice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String habilidad(Jugador objetivo, int indice) {
		return "";
	}

	@Override
	public String mostrarClase() {
		return "Espadachin";
	}
}
