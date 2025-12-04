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
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

	 Tanque(String nombre, Arma arma) {
	        super(nombre, 120, 120, 5, 95, 40, arma, 1, 0, false, "", 0, 50, 100,50);
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
            super.danioTotal += dano;
            objetivo.personajesSelecionados[indice].vidaActual -= dano;

            mensaje += "[ Le has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n";

            if (Math.random() < 0.05) { 
                super.armadura += 5;
                mensaje += ANSI_GREEN + "[ ¡Te has fortalecido! ]\n";
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
            return ANSI_RED + "[ Mana insuficiente... ]\n" + ANSI_RESET;
        }

        super.numeroDeHabilidadesUsadas++;
        super.manaActual -= manaHabilidad;
        int dano = (int)(arma.calcularDano(super.poderAtaque) * 1.5);
        dano -= (int)(arma.calcularDano(super.poderAtaque)*(objetivo.personajesSelecionados[indice].getArmadura()/100));
        super.danioTotal += dano;
        objetivo.personajesSelecionados[indice].vidaActual -= dano;

        mensaje += "[ Le has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n";

        if (Math.random() < 0.6) {  
            objetivo.personajesSelecionados[indice].tieneEfecto = true;
            objetivo.personajesSelecionados[indice].tipoEfecto = "Stuneado";
            objetivo.personajesSelecionados[indice].duracionEfecto = 1;
            mensaje += ANSI_GREEN + "[ ¡Stuneado aplicado! ]\n";
        }

        super.experiencia += 5;
		if (super.subeNivel()) {
			mensaje += ANSI_GREEN + "[ ¡Has subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ]\n"; 
		}
        return mensaje + ANSI_RESET;
    }

	@Override
	public String mostrarClase() {
		return "Tanque";
	}
	
	
	
}