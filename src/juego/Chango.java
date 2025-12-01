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
public class Chango extends Personaje{
    Chango(String nombre, Arma arma) {
        super(nombre, 50, 50, 100, 85, 5, arma, 1, 0, false, "", 0, 100, 100);
    }

	@Override
	public boolean atacar(Jugador objetivo, int indice) {
		 int probabilidadAtaque = (int)(Math.random() * 100) + 1;

		// -3% de precisión para el chango
	        if (probabilidadAtaque > (super.precision - 3)) {
	            objetivo.personajesSelecionados[indice].vidaActual -= arma.calcularDano(super.poderAtaque);
	            return true;
	        }
	        return false;
	}

	@Override
	 public String habilidad(Jugador objetivo, int indice) {
        int probCritico = (int)(Math.random() * 100) + 1;
        double poderAtaque;
        String mensaje = "";

        // Habilidad de Chango: Aumento en el golpe crítico +5% de probabilidad
        if (probCritico <= 5) {  // Chango tiene +5% de critico
            poderAtaque = super.poderAtaque * 2;
            objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
            mensaje += "[ ¡Golpe Crítico de Chango! ]\n";
        } else {
            poderAtaque = super.poderAtaque;
            objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
        }

        mensaje += "[ Le has restado " + poderAtaque + " a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]";
        return mensaje;
    }

	@Override
	public String mostrarClase() {
		return "Chango loco desquisiado";
	}
}