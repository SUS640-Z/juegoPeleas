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
public class Paladin extends Personaje{
	
	Paladin(String nombre, Arma arma){
		super(nombre, 70, 70, 12, 95, 35, new Arma("Espada", 15, 95), 1, 0, false, "", 0, 100, 100);
	}

	@Override
	public boolean atacar(Jugador objetivo, int indice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String habilidad(Jugador objetivo, int indice) {
		/*int probCongelar = (int)(Math.random() * 100) + 1;
		double poderAtaque;
		String mensaje = "";
		
		if(super.manaActual >= 60) {
			super.manaActual -= 60;
			
			if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Vampiro")) {
				poderAtaque = 15 * 1.2;
				objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
				mensaje += "habilidad con ventaja\n";
			}
			else {
				poderAtaque = 15;
				objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
			}
			
			if(probCongelar <= 20) {
				objetivo.personajesSelecionados[indice].tieneEfecto = true;
				objetivo.personajesSelecionados[indice].tipoEfecto = "Congelado";
				objetivo.personajesSelecionados[indice].duracionEfecto = 3;
				mensaje += "Se aplico Congelar\n";
			}
			
			mensaje += "Le has restado " + poderAtaque + " a " + objetivo.personajesSelecionados[indice].getNombre();
		}
		else {
			mensaje = "Mana insuficiente...";
		}
		
		return mensaje;*/
		return "";
	}

	@Override
	public String mostrarClase() {
		return "Paladin";
	}
}