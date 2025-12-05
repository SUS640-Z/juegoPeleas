package juego;

/**
 * La clase Chango hijo de clase Personaje
 * Establece estadisticas y movimientos de Chango
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 */
public class Chango extends Personaje{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Constructor de la clase Chango
     * @param nombre el nombre del personaje
     * @param arma el arma del personaje
     */
    Chango(String nombre, Arma arma) {
        super(nombre, 100, 100, 24, 80, 3, arma, 1, 0, false, "", 0, 33, 100,33);
    }

    /**
     * Realiza un ataque basico contra el personaje del jugador objetivo
     * @param objetivo es el jugador que recibira el ataque
     * @param indice es el indice del personaje en el equipo del jugador objetivo
     */
    @Override
    public String atacar(Jugador objetivo, int indice) {
		int probabilidadAtaque = (int)(Math.random() * 100) + 1;
        String mensaje="";

		this.manaActual += 10;
		if(this.manaActual > this.manaMaximo){
			this.manaActual = this.manaMaximo;
		}

        if (probabilidadAtaque < precision) {
            int dano =  arma.calcularDano(super.poderAtaque);
            
            if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Mago de hielo")) {
            	dano *= 1.20;
            	mensaje += "[ El ataque fue muy efectivo! ]\n";;
            }
            
            dano -= (int)(dano*(objetivo.personajesSelecionados[indice].getArmadura()/100)); 
            super.danioTotal += dano;
            objetivo.personajesSelecionados[indice].vidaActual -= dano;
            if(objetivo.personajesSelecionados[indice].vidaActual > 0) {
                objetivo.personajesSelecionados[indice].experiencia += 5;
            }
			
            mensaje += ANSI_GREEN+"[ "+nombre+" has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n"+ANSI_RESET;

            if (Math.random() < 0.05) { 
                if(super.arma.getProbabilidadCritico() > 100){
                    super.arma.setProbabilidadCritico(100);
                } else {
                    super.arma.setProbabilidadCritico(super.arma.getProbabilidadCritico() + 5);
                    mensaje += ANSI_GREEN + "[ La probabilidad de critico de tu arma ha aumentado en 5%! ]\n";
                }
            }

            this.experiencia += 5;
			if (this.subeNivel()) {
			    mensaje += ANSI_GREEN + "[ ¡"+nombre+" has subido de nivel, se ha restaurado tu vida y mana! Ahora eres nivel " + this.nivel + "! ]\n"; 
			}
        } else{
            mensaje += ANSI_RED + "[ Ataque fallido! ]";
        }

        return mensaje + ANSI_RESET;
	}

    /**
     * Usa la habilidad especial contra el objetivo
     * La habilidad consume mana, aplica dano y aumenta la probabilidad de critico
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

        if(super.arma.getProbabilidadCritico() >= 100){
            super.arma.setProbabilidadCritico(100);
            mensaje += ANSI_YELLOW + "[ La probabilidad de critico de tu arma ha llegado al maximo! ]\n";
        } else {
            super.arma.setProbabilidadCritico(super.arma.getProbabilidadCritico() + 5);
            mensaje += ANSI_GREEN+ "[ La probabilidad de critico de tu arma ha aumentado en 5%! ]\n";
        }

        if(super.precision < 33){
            super.precision -= 3;
            if(super.precision < 33){
                super.precision = 33;
            }
        }
        
        int dano =  arma.calcularDano(super.poderAtaque);
        
        if(objetivo.personajesSelecionados[indice].mostrarClase().equalsIgnoreCase("Mago de hielo")) {
        	dano *= 1.20;
        	mensaje += "[ El ataque fue muy efectivo! ]\n";
        }
        
        dano -= (int)(dano*(objetivo.personajesSelecionados[indice].getArmadura()/100));
        objetivo.personajesSelecionados[indice].vidaActual -= dano;
        if(objetivo.personajesSelecionados[indice].vidaActual > 0) {
			objetivo.personajesSelecionados[indice].experiencia += 5;
		}
        
        super.danioTotal += dano;
        mensaje += "[ "+nombre+" has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]\n";

        super.experiencia += 5;
		if (super.subeNivel()) {
			mensaje += ANSI_GREEN + "[ ¡"+nombre+" has subido de nivel, se ha restaurado tu vida y mana! Ahora eres nivel " + this.nivel + "! ]\n"; 
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
		return "Chango loco desquisiado";
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