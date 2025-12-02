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
	 Mago(String nombre, Arma arma) {
	        super(nombre, 50, 50, 25, 80, 10, arma, 1, 0, false, "", 0, 100, 100);
	    }

	@Override
	public boolean atacar(Jugador objetivo, int indice) {
		 int probabilidadAtaque = (int)(Math.random() * 100) + 1;
		 if (probabilidadAtaque < super.precision) {
	            int dano = arma.calcularDano(super.poderAtaque);
	            objetivo.personajesSelecionados[indice].vidaActual -= dano;
	            // Si el ataque es exitoso, aplica la habilidad de congelación
	            if (Math.random() < 0.2) {  // 20% probabilidad de congelar
	                objetivo.personajesSelecionados[indice].precision *= 0.5;  // Reduce la precisión del enemigo en un 50%
	                objetivo.personajesSelecionados[indice].tieneEfecto = true;
	                objetivo.personajesSelecionados[indice].tipoEfecto = "Congelado";
	                objetivo.personajesSelecionados[indice].duracionEfecto = 2;
	                System.out.println("[ ¡Congelado! ] " + objetivo.personajesSelecionados[indice].getNombre());
	            }
	            return true;
	        }

	        return false;
	}

	@Override
	public String habilidad(Jugador objetivo, int indice) {
        return "";  // La habilidad de congelar ya se encuentra en el ataque.
    }

	@Override
	public String mostrarClase() {
		return "Mago de hielo";
	}
}