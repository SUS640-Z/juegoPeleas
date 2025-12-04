package juego;

/**
 * La clase Vamprio hijo de clase Personaje
 * Establece estadisticas y movimientos de Vampiro
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 */
public class Vampiro extends Personaje{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Constructor de la clase Vampiro
     * @param nombre el nombre del personaje
     * @param arma el arma del personaje
     */
	Vampiro(String nombre, Arma arma) {
        super(nombre, 75, 75, 22, 85, 18, arma, 1, 0, false, "", 0, 50, 100,50);
    }

	/**
	  * Realiza un ataque basico contra el personaje del jugador objetivo
	  * @param objetivo es el jugador que recibira el ataque
	  * @param indice es el indice del personaje en el equipo del jugador objetivo
	  */
    @Override
    public String atacar(Jugador objetivo, int indice) {
		int probabilidadAtaque = (int)(Math.random() * 100) + 1;
        String mensaje;

		this.manaActual += 10;
		if(this.manaActual > this.manaMaximo){
			this.manaActual = this.manaMaximo;
		}

        if (probabilidadAtaque < precision) {
            int dano =  arma.calcularDano(super.poderAtaque); 

            if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Tanque")) {
            	dano *= 1.20;
            	mensaje = "[ El ataque fue muy efectivo! ]\n";
            }

            dano -= (int)(dano*(objetivo.personajesSelecionados[indice].getArmadura()/100));             
            super.danioTotal += dano;
            objetivo.personajesSelecionados[indice].vidaActual -= dano;
            if(objetivo.personajesSelecionados[indice].vidaActual > 0) {
                objetivo.personajesSelecionados[indice].experiencia += 5;
            }

            mensaje = "[ "+nombre+" ha restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n"+ANSI_RESET;

            if (Math.random() < 0.05) { 
                objetivo.personajesSelecionados[indice].tieneEfecto = true;
                objetivo.personajesSelecionados[indice].tipoEfecto = "Sangrado";
                objetivo.personajesSelecionados[indice].duracionEfecto = 2;
                mensaje += ANSI_GREEN + "[ ¡Sangrado aplicado! ]\n";
            }

			this.experiencia += 5;
			if (this.subeNivel()) {
				mensaje += ANSI_GREEN + "[ ¡"+nombre+"ha subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ]";
			}
        } else{
            mensaje = ANSI_RED + "[ Ataque fallido! ]"+ANSI_RESET;
        }

        return mensaje + ANSI_RESET;
	}
	
    /**
     * Usa la habilidad especial contra el objetivo
     * La habilidad consume mana, aplica sangrado y dano al objetivo
     * @param objetivo es el jugador que recibira el ataque
     * @param indice es el indice del personaje en el equipo del jugador objetivo
     */
	@Override
    public String habilidad(Jugador objetivo, int indice) {
        String mensaje;

        if(super.manaActual < manaHabilidad){
            return ANSI_RED + "[ Mana insuficiente... ]\n" + ANSI_RESET;
        }

        super.numeroDeHabilidadesUsadas++;
        super.manaActual -= manaHabilidad;
        int dano = (int)(arma.calcularDano(super.poderAtaque) * 1.3);
			     
        if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Tanque")) {
        	dano *= 1.20;
        	mensaje = "[ El ataque fue muy efectivo! ]\n";
        }

        dano -= (int)(dano*(objetivo.personajesSelecionados[indice].getArmadura()/100));    
        super.danioTotal += dano;
        objetivo.personajesSelecionados[indice].vidaActual -= dano;
        if(objetivo.personajesSelecionados[indice].vidaActual > 0) {
			objetivo.personajesSelecionados[indice].experiencia += 5;
		}

        mensaje = ANSI_GREEN+"[ Le has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n"+ANSI_RESET;

        if (Math.random() < 0.4) { // 40% probabilidad de sangrado
            objetivo.personajesSelecionados[indice].tieneEfecto = true;
            objetivo.personajesSelecionados[indice].tipoEfecto = "Sangrado";
            objetivo.personajesSelecionados[indice].duracionEfecto = 2;
            mensaje += ANSI_GREEN + "[ ¡Sangrado aplicado! ]\n";
        }

        if (Math.random() < 0.7) {  // 70% probabilidad
            super.vidaActual += dano * 0.5;  // Regenera 50% del daño infligido
            if (super.vidaActual > super.vidaMaxima) {
                super.vidaActual = super.vidaMaxima;
            }  // Asegurar que no supera la vida maxima.
            mensaje += ANSI_GREEN + "[ "+nombre+"ha regenerado " + (dano * 0.5) + " de vida! ]\n";
        }

        super.experiencia += 5;
		if (super.subeNivel()) {
			mensaje += ANSI_GREEN + "[ ¡"+nombre+"Ha subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ]\n"; 
		}
        return mensaje + ANSI_RESET;
    }

	/**
	 * Devuelve la clase del personaje
	 * 
	 * @return nombre descriptivo de la clase
	 */
	@Override
	public String mostrarClase() {
		return "Vampiro";
	}
	
	/**
	 * Devuelve una presentacion completa del personaje, incluyendo su clase y estadisticas
	 * 
	 * @return cadena con la presentacion del personaje
	 */
	public String mostrarPresentacion() {
		return "\nClase: "+ANSI_CYAN+ mostrarClase()+ANSI_RESET +
			super.mostrarPresentacion();
	}
}