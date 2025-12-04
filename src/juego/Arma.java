package juego;

/**
 * La clase arma
 * Representa un arma utilizada por un personaje en el juego.
 * Cada arma tiene un nombre, daño extra, precisión y probabilidad de golpe crítico.
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 */
public class Arma {
    private String nombre;
    private int danoExtra;
    private double probabilidadCritico;
    private int numeroDeCriticos;

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    /**
     * Crea un arma con los atributos especif     
     * @param nombre Nombre del arma.
     * @param danoExtra Daño adicional para el ataque.
     * @param probabilidadCritico Probabilidad de golpe crítico.
     */
    public Arma(String nombre, int danoExtra, double probabilidadCritico) {
        this.nombre = nombre;
        this.danoExtra = danoExtra;
        this.probabilidadCritico = probabilidadCritico;
        this.numeroDeCriticos = 0;
    }
    /**
     * Obtiene el nombre del arma.
     * @return nombre del arma.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la probabilidad de golpe crítico del arma.
     * @return probabilidad de golpe crítico.
     */
    public double getProbabilidadCritico() {
        return probabilidadCritico;
    }

    /**
	 * Setter que recibe el critico del arma.
	 * @param probabilidadCritico critico del arma.
	 */	
	public void setProbabilidadCritico(double probabilidadCritico) {
		this.probabilidadCritico = probabilidadCritico;
	}

    /**
     * Numero de criticos realizados con el arma.
     * @return numero de criticos.
     */
    public int getNumeroDeCriticos() {
        return numeroDeCriticos;
    }

    /**
	 * Setter que recibe el numero de criticos del arma.
	 * @param numeroDeCriticos numero de criticos.
	 */	
	public void setProbabilidadCritico(int numeroDeCriticos) {
		this.numeroDeCriticos = numeroDeCriticos;
	}

    /**
     * Calcula el daño infligido considerando:
     * <ul>
     *     <li>Posibilidad de golpe crítico según la probabilidadCritico.</li>
     *     <li>Daño extra del arma.</li>
     * </ul>
     * @return El daño final que se inflige.
     */
    public int calcularDano(int danoBase) {
        int danoFinal = danoBase + danoExtra;
        int critico = (int)(Math.random() * 100) + 1;
        if (critico < probabilidadCritico) {
            System.out.println(ANSI_YELLOW + "[ ¡Golpe crítico! ]");
            numeroDeCriticos++;
            danoFinal *= 2;
            System.out.println(ANSI_YELLOW);
            return danoFinal;
        } 
        System.out.println(ANSI_GREEN);
        return danoFinal;
    }
}