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
	Chango(String nombre, Arma arma){
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
	public String habilidad(Jugador objetivo, int indice) {
		int probRabia = (int)(Math.random() * 100) + 1;
		double poderAtaque;
		String mensaje = "";
		
		if(super.manaActual >= 60) {
			super.manaActual -= 60;
			
			if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Mago")) {
				poderAtaque = 15 * 1.2;
				objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
				mensaje += "habilidad con ventaja\n";
			}
			else {
				poderAtaque = 15;
				objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
			}
			
			if(probRabia <= 20) {
				this.tieneEfecto = true;
				this.tipoEfecto = "Rabioso";
				this.duracionEfecto = 3;
				mensaje += (this.nombre + " ha enfurecido\n");
			}
			
			mensaje += "Le has restado " + poderAtaque + " a " + objetivo.personajesSelecionados[indice].getNombre();
		}
		else {
			mensaje = "Mana insuficiente...";
		}
		
		return mensaje;
	}

	@Override
	public String mostrarClase() {
		return "Chango loco desquisiado";
	}
}
