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
	Vampiro(String nombre, Arma arma) {
        super(nombre, 75, 75, 7, 85, 25, arma, 1, 0, false, "", 0, 50, 100);
    }
	
	@Override
    public String habilidad(Jugador objetivo, int indice) {
        String mensaje = "";

        if(super.manaActual < 50){
            return "[ Mana insuficiente... ]";
        }

        super.manaActual -= 50;
        int dano = (int)(arma.calcularDano(super.poderAtaque) * 1.3);
        dano -= (int)(arma.calcularDano(super.poderAtaque)*(objetivo.personajesSelecionados[indice].getArmadura()/100));
        objetivo.personajesSelecionados[indice].vidaActual -= dano;

        if (Math.random() < 0.2) { // 20% probabilidad de sangrado
            objetivo.personajesSelecionados[indice].tieneEfecto = true;
            objetivo.personajesSelecionados[indice].tipoEfecto = "Sangrado";
            objetivo.personajesSelecionados[indice].duracionEfecto = 2;
            mensaje += "[ ¡Sangrado aplicado! ]\n";
        }

        if (Math.random() < 0.3) {  // 30% probabilidad
            super.vidaActual += dano * 0.5;  // Regenera 50% del daño infligido
            if (super.vidaActual > super.vidaMaxima) {
                super.vidaActual = super.vidaMaxima;
            }  // Asegurar que no supera la vida maxima.
            mensaje += "[ Has regenerado " + (dano * 0.5) + " de vida! ]\n";
        }

        super.experiencia += 5;
		if (super.subeNivel()) {
			System.out.println("[ ¡Has subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ]");
		}
        mensaje += "[ Le has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]";
        return mensaje;
    }

	@Override
	public String mostrarClase() {
		return "Vampiro";
	}
}