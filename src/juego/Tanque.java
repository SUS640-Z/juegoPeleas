package juego;

/**
 * La clase Tanque hijo de clase Personaje
 * Establece estadisticas y movimientos de Tanque
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

    /**
     * Constructor de la clase Tanque
     * @param nombre el nombre del personaje
     * @param arma el arma del personaje
     */
	 Tanque(String nombre, Arma arma) {
	        super(nombre, 120, 120, 19, 95,33, arma, 1, 0, false, "", 0, 50, 100,50);
	 }

	 /**
	  * Realiza un ataque basico contra el personaje del jugador objetivo
	  * @param objetivo es el jugador que recibira el ataque
	  * @param indice es el indice del personaje en el equipo del jugador objetivo
	  */
     @Override
    public String atacar(Jugador objetivo, int indice) {
		int probabilidadAtaque = (int)(Math.random() * 100) + 1;
        String mensaje ="";

		this.manaActual += 10;
		if(this.manaActual > this.manaMaximo){
			this.manaActual = this.manaMaximo;
		}

        if (probabilidadAtaque < precision) {
            int dano =  arma.calcularDano(super.poderAtaque);  

            if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Chango loco desquisiado")) {
            	dano *= 1.20;
            	mensaje = "[ El ataque fue muy efectivo! ]\n";
            }

            dano -= (int)(dano*(objetivo.personajesSelecionados[indice].getArmadura()/100));             
            super.danioTotal += dano;
            objetivo.personajesSelecionados[indice].vidaActual -= dano;
            if(objetivo.personajesSelecionados[indice].vidaActual > 0) {
                objetivo.personajesSelecionados[indice].experiencia += 5;
            }

            mensaje += "[ "+nombre+" ha restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n"+ANSI_RESET;

            if (Math.random() < 0.05) { 
                super.armadura += 5;
                mensaje += ANSI_GREEN + "[ ¡Te has fortalecido! ]\n";
            }

			this.experiencia += 5;
			if (this.subeNivel()) {
				mensaje += ANSI_GREEN + "[ ¡"+nombre+"ha subido de nivel,se ha restauraurado su vida y mana! Ahora eres nivel " + this.nivel + "! ]";
			}
            
        } else{
            mensaje = ANSI_RED + "[ Ataque fallido! ]";
        }

        return mensaje + ANSI_RESET;
	}

     /**
      * Usa la habilidad especial contra el objetivo
      * La habilidad consume mana, aplica dano y stunea al objetivo
      * @param objetivo es el jugador que recibira el ataque
      * @param indice es el indice del personaje en el equipo del jugador objetivo
      */
	@Override
	 public String habilidad(Jugador objetivo, int indice) {
        String mensaje = "";

        if(super.manaActual < manaHabilidad){
            return ANSI_RED + "[ Mana insuficiente... ]\n" + ANSI_RESET;
        }

        super.numeroDeHabilidadesUsadas++;
        super.manaActual -= manaHabilidad;
        int dano = (int)(arma.calcularDano(super.poderAtaque) * 1.5);
			        
        if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Chango loco desquisiado")) {
        	dano *= 1.20;
        	mensaje += "[ El ataque fue muy efectivo! ]\n";
        }

        dano -= (int)(dano*(objetivo.personajesSelecionados[indice].getArmadura()/100)); 
        super.danioTotal += dano;
        objetivo.personajesSelecionados[indice].vidaActual -= dano;
        if(objetivo.personajesSelecionados[indice].vidaActual > 0) {
			objetivo.personajesSelecionados[indice].experiencia += 5;
		}

        mensaje += "[ "+nombre+" has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n"+ANSI_RESET;

        if (Math.random() < 0.6) {  
            objetivo.personajesSelecionados[indice].tieneEfecto = true;
            objetivo.personajesSelecionados[indice].tipoEfecto = "Stuneado";
            objetivo.personajesSelecionados[indice].duracionEfecto = 1;
            mensaje += ANSI_CYAN + "[ ¡Stuneado aplicado! ]\n";
        }

        super.experiencia += 5;
		if (super.subeNivel()) {
			mensaje += ANSI_GREEN + "[ ¡"+nombre+"Ha subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ]\n\n"; 
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
		return "Tanque";
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