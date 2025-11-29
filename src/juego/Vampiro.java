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
public class Vampiro extends Personaje{
	public Vampiro(String nombre, Arma arma){
		super(nombre, 60, 60, 90, 70, 50, arma, 1, 0, false, "", 0, 100, 100);
	}

	@Override
	public boolean atacar(Jugador objetivo, int indice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String habilidad(Jugador objetivo, int indice) {
		int probSangrado = (int)(Math.random() * 100) + 1;
		int probCurarse = (int)(Math.random() * 100) + 1;
		double poderAtaque;
		String mensaje = "";
		
		if(super.manaActual >= 60) {
			super.manaActual -= 60;
			
			if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Tanque")) {
				poderAtaque = 10 * 1.2;
				objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
				mensaje += "habilidad con ventaja\n";
			}
			else {
				poderAtaque = 10;
				objetivo.personajesSelecionados[indice].vidaActual -= poderAtaque;
			}
			
			
			if(probSangrado <= 50) {
				objetivo.personajesSelecionados[indice].tieneEfecto = true;
				objetivo.personajesSelecionados[indice].tipoEfecto = "Sangrado";
				objetivo.personajesSelecionados[indice].duracionEfecto = 3;
				mensaje += "Se aplico sangrado\n";
			}
			if(probCurarse <= 20) {
				super.vidaActual +=  poderAtaque * 0.5;
				mensaje += ("Se aplico robo de vida: " + poderAtaque * 0.5 +"\n");
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
		return "Vampiro";
	}
}
