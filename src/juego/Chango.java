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
public class Chango extends Personaje{
    Chango(String nombre, Arma arma) {
        super(nombre, 100, 100, 10, 80, 10, arma, 1, 0, false, "", 0, 33, 100);
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

            if (Math.random() < 0.05) { 
                if(super.arma.getProbabilidadCritico() > 100){
                    super.arma.setProbabilidadCritico(100);
                } else {
                    super.arma.setProbabilidadCritico(super.arma.getProbabilidadCritico() + 5);
                    mensaje += "[ La probabilidad de critico de tu arma ha aumentado en 5%! ]\n";
                }
            }

			this.experiencia += 5;
			if (this.subeNivel()) {
				mensaje += "[ ¡Has subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ] \n";
			}
            mensaje += "[ Le has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]";
        }

        mensaje += "[ Ataque fallido! ]";
        return mensaje;
	}

	@Override
	 public String habilidad(Jugador objetivo, int indice) {
        String mensaje = "";

        if(super.manaActual < 33){
            return "[ Mana insuficiente... ]";
        }

        super.manaActual -= 33;

        if(super.arma.getProbabilidadCritico() >= 100){
            super.arma.setProbabilidadCritico(100);
            mensaje += "[ La probabilidad de critico de tu arma ha llegado al maximo! ]\n";
        } else {
            super.arma.setProbabilidadCritico(super.arma.getProbabilidadCritico() + 5);
            mensaje += "[ La probabilidad de critico de tu arma ha aumentado en 5%! ]\n";
        }

        if(super.precision < 33){
            super.precision -= 3;
            if(super.precision < 33){
                super.precision = 33;
            }
        }
        
        int dano = arma.calcularDano(super.poderAtaque);
        dano -= (int)(arma.calcularDano(super.poderAtaque)*(objetivo.personajesSelecionados[indice].getArmadura()/100));
        objetivo.personajesSelecionados[indice].vidaActual -= dano;

        super.experiencia += 5;
		if (super.subeNivel()) {
			System.out.println("[ ¡Has subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ]");
		}
        mensaje += "[ Le has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]";
        return mensaje;
    }

	@Override
	public String mostrarClase() {
		return "Chango loco desquisiado";
	}
}