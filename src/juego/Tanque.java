package juego;

/**
 * La clase tanque hijo de clse personaje
 * Establece estadisticas y movimientos de tanque
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 */
public class Tanque extends Personaje {
	Tanque(String nombre, Arma arma){
		super(nombre, 100, 100, 50, 35, 50, new Arma("Escudo", 20, 100), 1, 0, false, "", 0, 100, 100);
	}

	@Override
	public boolean atacar(Jugador objetivo, int indice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String habilidad(Jugador objetivo, int indice) {
		int probStuneo = (int)(Math.random() * 100) + 1;
		double poderAtaque;
		String mensaje = "";
		
		if(super.manaActual >= 60) {
			super.manaActual -= 60;
			
			if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Chango loco desquisiado")) {
				poderAtaque = 15 * 1.2;
				objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
				mensaje += "habilidad con ventaja\n";
			}
			else {
				poderAtaque = 15;
				objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
			}
			
			if(probStuneo <= 5) {
				objetivo.personajesSelecionados[indice].tieneEfecto = true;
				objetivo.personajesSelecionados[indice].tipoEfecto = "Stuneado";
				objetivo.personajesSelecionados[indice].duracionEfecto = 3;
				mensaje += "Se aplico Stuneo\n";
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
		return "Tanque";
	}
	
	
	
}
