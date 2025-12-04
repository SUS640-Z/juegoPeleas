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
	public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

	 Mago(String nombre, Arma arma) {
	        super(nombre, 60, 60, 26, 80, 8, arma, 1, 0, false, "", 0, 70, 100,70);
	    }

	@Override
    public String atacar(Jugador objetivo, int indice) {
		int probabilidadAtaque = (int)(Math.random() * 100) + 1;
        String mensaje = "";

		this.manaActual += 10;
		if(this.manaActual > this.manaMaximo){
			this.manaActual = this.manaMaximo;
		}

        if (probabilidadAtaque < precision) {
            int dano = (int)(arma.calcularDano(poderAtaque) - arma.calcularDano(poderAtaque)*(objetivo.personajesSelecionados[indice].getArmadura()/100));
            objetivo.personajesSelecionados[indice].vidaActual -= dano;

            mensaje += "[ "+nombre+" ha restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n";

            if (Math.random() < 0.05) { 
                objetivo.personajesSelecionados[indice].tieneEfecto = true;
                objetivo.personajesSelecionados[indice].tipoEfecto = "Congelado";
                objetivo.personajesSelecionados[indice].duracionEfecto = 2;
                mensaje += ANSI_GREEN + "[ ¡Congelación aplicada! ]\n";
            }

			this.experiencia += 5;
			if (this.subeNivel()) {
				mensaje += ANSI_GREEN + "[ ¡Has subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ]";
			}
        } else{
            mensaje += ANSI_RED + "[ Ataque fallido! ]";
        }

        return mensaje + ANSI_RESET;
	}

	@Override
	public String habilidad(Jugador objetivo, int indice) {
		String mensaje = "";

        if(super.manaActual < manaHabilidad){
            return ANSI_RED + "[ Mana insuficiente... ]" + ANSI_RESET;
        }

        super.manaActual -= manaHabilidad;
	    int dano = (int)(arma.calcularDano(super.poderAtaque) * 1.7);
		dano -= (int)(arma.calcularDano(super.poderAtaque)*(objetivo.personajesSelecionados[indice].getArmadura()/100));
	    objetivo.personajesSelecionados[indice].vidaActual -= dano;

	    mensaje += "[ Le has restado " + dano + " a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n"; 

	    if (Math.random() < 0.5) {  
	        objetivo.personajesSelecionados[indice].tieneEfecto = true;
	        objetivo.personajesSelecionados[indice].tipoEfecto = "Congelado";
	        objetivo.personajesSelecionados[indice].duracionEfecto = 2;
	        mensaje += ANSI_GREEN + "[ ¡Congelación aplicada! ]\n";
	    }

		super.experiencia += 5;
		if (super.subeNivel()) {
			mensaje += ANSI_GREEN + "[ ¡Has subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ]\n";
		}
		return mensaje + ANSI_RESET;
    }

	@Override
	public String mostrarClase() {
		return "Mago de hielo";
	}
}