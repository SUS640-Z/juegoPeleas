package juego;

/**
 * La clase mago hijo de clse personaje
 * Establece estadisticas y movimientos de mago
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 */
public class Mago extends Personaje{
	Mago(String nombre, Arma arma){
		super(nombre, 50, 50, 100, 85, 5, new Arma("Vara", 20, 100), 1, 0, false, "", 0, 100, 100);
	}

	@Override
	public boolean atacar(Jugador objetivo, int indice) {
		int probabilidadAtaque = (int)(Math.random() * 100) + 1;

		if(probabilidadAtaque > super.precision) {
			objetivo.personajesSelecionados[indice].vidaActual -= arma.calcularDano(super.poderAtaque);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean habilidad(Jugador objetivo, int indice) {
		int probabilidadAtaque = (int)(Math.random() * 100) + 1;

		if(probabilidadAtaque > super.precision) {
			objetivo.personajesSelecionados[indice].vidaActual -= arma.calcularDano(super.poderAtaque);
			return true;
		}
		
		return false;
	}

	@Override
	public String mostrarClase() {
		return "Mago";
	}
}