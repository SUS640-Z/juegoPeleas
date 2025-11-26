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
		super(nombre, 70, 70, 80, new Arma(), 1, 0, false, "Sangrado", 2);
	}

	@Override
	public boolean atacar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean habilidad() {
		// TODO Auto-generated method stub
		return false;
	}
}
