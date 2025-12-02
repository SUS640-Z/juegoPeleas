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
	        super(nombre, 120, 120, 5, 95, 40, arma, 1, 0, false, "", 0, 50, 100);
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
                super.armadura += 5;
                mensaje += "[ ¡Te has fortalecido! ]\n";
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

        if(super.manaActual < 50){
            return "[ Mana insuficiente... ]";
        }

        super.manaActual -= 50;
        int dano = (int)(arma.calcularDano(super.poderAtaque) * 1.5);
        dano -= (int)(arma.calcularDano(super.poderAtaque)*(objetivo.personajesSelecionados[indice].getArmadura()/100));
        objetivo.personajesSelecionados[indice].vidaActual -= dano;

        if (Math.random() < 0.15) {  
            objetivo.personajesSelecionados[indice].tieneEfecto = true;
            objetivo.personajesSelecionados[indice].tipoEfecto = "Stuneado";
            objetivo.personajesSelecionados[indice].duracionEfecto = 3;
            mensaje += "[ ¡Stuneado aplicado! ]\n";
        }

        super.experiencia += 5;
		if (super.subeNivel()) {
			System.out.println("[ ¡Has subido de nivel, restauraste tu vida y mana! Ahora eres nivel " + this.nivel + "! ]");
		}
        mensaje += "[ Le has restado " + dano + " a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]";
        return mensaje;
    }

	@Override
	public String mostrarClase() {
		return "Tanque";
	}
	
	
	
}