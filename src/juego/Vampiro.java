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
        super(nombre, 60, 60, 15, 85, 25, arma, 1, 0, false, "", 0, 100, 100);
    }

	@Override
	public boolean atacar(Jugador objetivo, int indice) {
        int probabilidadAtaque = (int)(Math.random() * 100) + 1;

        if (probabilidadAtaque < super.precision) {
            int dano = arma.calcularDano(super.poderAtaque);
            objetivo.personajesSelecionados[indice].vidaActual -= dano;

            if (Math.random() < 0.2) { // 20% probabilidad de sangrado
                objetivo.personajesSelecionados[indice].vidaActual -= 5;  // Daño de sangrado
            }

            if (Math.random() < 0.3) {  // 30% probabilidad
                super.vidaActual += dano * 0.5;  // Regenera 50% del daño infligido
                if (super.vidaActual > super.vidaMaxima) super.vidaActual = super.vidaMaxima;  // Asegurar que no supera la vida maxima.
            }
            return true;
        }

        return false;
    }
	
	@Override
    public String habilidad(Jugador objetivo, int indice) {
        return "";  // La habilidad ya se encuentra integrada en el ataque.
    }

	@Override
	public String mostrarClase() {
		return "Vampiro";
	}
}