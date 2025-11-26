package juego;

import java.util.Random;

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
    private Random random;

    public static final String ANSI_YELLOW = "\u001B[33m";
    /**
     * Crea un arma con los atributos especif     * @param nombre Nombre del arma.
     * @param danoExtra Daño adiciod de acertar el ataque (0.0 a 1.0).
     * @param probabilidadCritico Probabilidad de golpe crítico (0.0 a 1.0).
     */
    public Arma(String nombre, int danoExtra, double precision, double probabilidadCritico) {
        this.nombre = nombre;
        this.danoExtra = danoExtra;
        this.precision = precision;
        this.probabilidadCritico = probabilidadCritico;
        this.random = new Random();
    }
    /**
     * Obtiene el nombre del arma.
     * @return nombre del arma.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Obtiene la precisión del arma.
     * @return precisión del arma.
     */
    public double getPrecision() {
        return precision;
    }
    /**
     * Obtiene la probabilidad de golpe crítico del arma.
     * @return probabilidad de golpe crítico.
     */
    public double getProbabilidadCritico() {
        return probabilidadCritico;
    }
    /**
     * Calcula el daño infligido considerando:
     * <ul>
     *     <li>Posibilidad de fallar según la precisión.</li>
     *     <li>Posibilidad de golpe crítico según la probabilidadCritico.</li>
     *     <li>Daño extra del arma.</li>
     * </ul>
     * @return El daño final que se inflige (0 si falla).
     */
    public int calcularDano(int danoBase) {
        if (random.nextDouble() > precision) {
            System.out.println(ANSI_YELLOW + " [ ⚠️ El ataque de " + nombre + " ha fallado... ]");
            return 0;
        }
        int danoFinal = danoBase + danoExtra;
        if (random.nextDouble() < probabilidadCritico) {
            danoFinal *= 2;
            System.out.println(ANSI_RED + "[ 🛑 Golpe crítico realizado por " + nombre + " ]");
        }
        return danoFinal;
    }
}
