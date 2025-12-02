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
	 Tanque(String nombre, Arma arma) {
	        super(nombre, 120, 120, 10, 95, 50, arma, 1, 0, false, "", 0, 100, 100);
	 }

	@Override
	 public String habilidad(Jugador objetivo, int indice) {
        String mensaje = "";

        if(super.manaActual < 50){
            return "[ Mana insuficiente... ]";
        }

        super.manaActual -= 50;
        int dano = arma.calcularDano(super.poderAtaque) * 2;
        dano -= (int)(arma.calcularDano(super.poderAtaque)*(objetivo.personajesSelecionados[indice].getArmadura()/100));
        objetivo.personajesSelecionados[indice].vidaActual -= dano;

        if (Math.random() < 0.15) {  
            objetivo.personajesSelecionados[indice].tieneEfecto = true;
            objetivo.personajesSelecionados[indice].tipoEfecto = "Stuneado";
            objetivo.personajesSelecionados[indice].duracionEfecto = 3;
            mensaje += "[ ¡Stuneado aplicado! ]\n";
        }
        mensaje += "[ Le has restado " + dano + " a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]";
        

        return mensaje;
    }

	@Override
	public String mostrarClase() {
		return "Tanque";
	}
	
	
	
}