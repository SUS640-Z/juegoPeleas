package juego;

/**
 * La clase pistolero hijo de clse personaje
 * Establece estadisticas y movimientos de pistolero
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 */
public class Pistolero extends Personaje{
	Pistolero(String nombre, Arma arma){
		super(nombre, 60, 60, 90, 70, 50, new Arma("Pistola", 20, 100), 1, 0, false, "", 0, 0, 0);
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
		return "Pistolero";
	}
}