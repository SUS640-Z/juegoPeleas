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
        super(nombre, 100, 100, 20, 80, 5, arma, 1, 0, false, "", 0, 100, 100);
    }

	@Override
	 public String habilidad(Jugador objetivo, int indice) {
        String mensaje = "";

        if(super.manaActual < 33){
            return "[ Mana insuficiente... ]";
        }

        super.manaActual -= 33;
        super.arma.setProbabilidadCritico(super.arma.getProbabilidadCritico() + 5);

        if(super.arma.getProbabilidadCritico() > 100){
            super.arma.setProbabilidadCritico(100);
            mensaje += "[ La probabilidad de critico de tu arma ha llegado al maximo! ]\n";
        } else {
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

        mensaje += "[ Le has restado " + dano + " de vida a " + objetivo.personajesSelecionados[indice].getNombre() + "! ]";
        return mensaje;
    }

	@Override
	public String mostrarClase() {
		return "Chango loco desquisiado";
	}
}