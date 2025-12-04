package juego;

/**
 * La clase personaje modela a un personaje elegible con caracteristicas detalladas que serviran durante el combate.
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 1.0
 */
public abstract class Personaje {
	public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
	//Atributos---------------------------------------------------------------------------------------------------------------------------------------------------------------
	protected String nombre;
	protected int vidaMaxima;
	protected int vidaActual;
	protected int poderAtaque;
    protected double precision;
	protected int armadura;
	protected Arma arma;
	protected int nivel;
	protected int experiencia;
	protected boolean tieneEfecto;
	protected String tipoEfecto;
	protected int duracionEfecto;
	protected int manaActual;
	protected int manaMaximo;
	//Variable Ivan
	protected boolean disponible;
	protected int manaHabilidad;
	protected int danioTotal;
	protected int numeroDeHabilidadesUsadas;
	
	//Constructores---------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Constructor que recibe todas las caracteristicas necesarias para que el personaje pueda ser jugable.
	 * @param nombre Nombre del personaje
	 * @param vidaMaxima La cantidad de vid
	 * @param presicion La probabilidad para acertar un ataque
	 * @param armadura La resistencia al daño del personajea máxima que puede tener
	 * @param vidaActual La cantidad de vida que posee actualmente
	 * @param poderAtaque El daño que posee
	 * @param arma El arma que tiene equipada el personaje
	 * @param nivel Nivel actual del personaje (no del jugador)
	 * @param experiencia La progresion de experiencia para alcanzar el siguiente nivel
	 * @param tieneEfecto Saber si el personaje posee algun efecto de estado en el momento
	 * @param tipoEfecto El tipo de efecto de estado
	 * @param duracionEfecto Cuantos turnos tendrá el efecto actual
	 * @param manaActual mana actual del personaje
	 * @param manaMaximo mana maximo del personaje
	 * @param manaHabilidad mana necesario para usar la habilidad especial
	 * @param danioTotal daño total realizado por el personaje
	 * @param numeroDeHabilidadesUsadas numero de habilidades usadas por el personaje
	*/
	public Personaje(String nombre, int vidaMaxima, int vidaActual, int poderAtaque, double precision, int armadura, Arma arma, int nivel, int experiencia, boolean tieneEfecto, String tipoEfecto, int duracionEfecto, int manaActual, int manaMaximo, int manaHabilidad) {
		this.nombre = nombre;
		this.vidaMaxima = vidaMaxima;
		this.vidaActual = vidaActual;
		this.poderAtaque = poderAtaque;
	    this.precision = precision;
		this.armadura = armadura;
		this.arma = arma;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.tieneEfecto = tieneEfecto;
		this.tipoEfecto = tipoEfecto;
		this.duracionEfecto = duracionEfecto;
		this.manaActual = manaActual;
		this.manaMaximo = manaMaximo;
		this.manaHabilidad = manaHabilidad;
		this.danioTotal = 0;
		this.numeroDeHabilidadesUsadas = 0;
		disponible = true;
	}
	
	//Getters y setters---------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * @return El nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter que recibe y actualiza el nuevo nombre para el personaje
	 * @param nombre Nombre del personaje
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return La vida maxima
	 */
	public int getVidaMaxima() {
		return vidaMaxima;
	}

	/**
	 * Setter que recibe y actualiza la cantidad de vida maxima nueva.
	 * @param vidaMaxima La cantidad de vida máxima que puede tener
	 */	
	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}

	/**
	 * @return La vida actual
	 */
	public int getVidaActual() {
		return vidaActual;
	}

	/**
	 * Setter que recibe y actualiza la cantidad de vida actual del personaje.
	 * @param vidaActual La cantidad de vida que posee actualmente
	 */	
	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	/**
	 * @return El poder de ataque (daño)
	 */
	public int getPoderAtaque() {
		return poderAtaque;
	}

	/**
	 * Setter que recibe y actualiza el daño del personaje.
	 * @param poderAtaque El daño que posee
	 */	
	public void setPoderAtaque(int poderAtaque) {
		this.poderAtaque = poderAtaque;
	}

	/**
	 * @return La probabilidad para acertar un ataque
	 */
	public double getPrecision() {
		return precision;
	}

	/**
	 * Setter que recibe y actualiza el daño del personaje.
	 * @param presicion La probabilidad para acertar un ataque
	 */	
	public void setPresicion(double presicion) {
		this.precision = presicion;
	}

	/**
	 * @return La armadura
	 */
	public int getArmadura() {
		return armadura;
	}

	/**
	 * Setter que recibe y actualiza la armadura del personaje.
	 * @param armadura La armadura que posee el personaje
	 */	
	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	/**
	 * @return El arma
	 */
	public Arma getArma() {
		return arma;
	}

	/**
	 * Setter que recibe y actualiza el arma del personaje.
	 * @param arma El arma que tiene equipada el personaje
	 */	
	public void setArma(Arma arma) {
		this.arma = arma;
	}

	/**
	 * @return El nivel actual
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Setter que recibe y actualiza el nivel actual del personaje.
	 * @param nivel Nivel actual del personaje (no del jugador)
	 */	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return La experiencia actual
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Setter que recibe y actualiza la cantidad de experiencia del personaje.
	 * @param experiencia La progresion de experiencia para alcanzar el siguiente nivel
	 */	
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * @return Si tiene un efecto de estado actualmente
	 */
	public boolean isTieneEfecto() {
		return tieneEfecto;
	}

	/**
	 * Setter que recibe y actualiza el estado (true o false) de tieneEfecto.
	 * @param tieneEfecto Saber si el personaje posee algun efecto de estado en el momento
	 */	
	public void setTieneEfecto(boolean tieneEfecto) {
		this.tieneEfecto = tieneEfecto;
	}

	/**
	 * @return El tipo de efecto de estado
	 */
	public String getTipoEfecto() {
		return tipoEfecto;
	}

	/**
	 * Setter que recibe y actualiza el tipo de efecto de estado que posee el personaje (si es que tiene).
	 * @param tipoEfecto El tipo de efecto de estado
	 */	
	public void setTipoEfecto(String tipoEfecto) {
		this.tipoEfecto = tipoEfecto;
	}

	/**
	 * @return La duracion del efecto de estado
	 */
	public int getDuracionEfecto() {
		return duracionEfecto;
	}

	/**
	 * Setter que recibe la duracion del efecto de estado del personaje si es que posee uno.
	 * @param duracionEfecto Cuantos turnos tendrá el efecto actual
	 */	
	public void setDuracionEfecto(int duracionEfecto) {
		this.duracionEfecto = duracionEfecto;
	}

	/**
	 * @return El mana actual
	 */
	public int getManaActual() {
		return manaActual;
	}

	/**
	 * Setter que recibe el mana del personaje.
	 * @param manaActual mana actual del personaje
	 */	
	public void setManaActual(int manaActual) {
		this.manaActual = manaActual;
	}

	/**
	 * @return El mana maximo
	 */
	public int getManaMaximo() {
		return manaMaximo;
	}

	/**
	 * Setter que recibe el mana maximo del personaje.
	 * @param manaMaximo mana maximo del personaje
	 */	
	public void setManaMaximo(int manaMaximo) {
		this.manaMaximo = manaMaximo;
	}

	/**
	 * @return El dano total del personaje
	 */
	public int getDanioTotal() {
		return danioTotal;
	}

	/**
	 * Setter que recibe el dano total del personaje.
	 * @param danioTotal dano total del personaje
	 */	
	public void setDanioTotal(int danioTotal) {
		this.danioTotal = danioTotal;
	}

	/**
	 * @return Numero de habilidades usadas por el personaje
	 */
	public int getNumeroDeHabilidadesUsadas() {
		return numeroDeHabilidadesUsadas;
	}

	/**
	 * Setter que recibe el numero de habilidades usadas del personaje.
	 * @param numeroDeHabilidadesUsadas numero de habilidades usadas por el personaje
	 */	
	public void setNumeroDeHabilidadesUsadas(int numeroDeHabilidadesUsadas) {
		this.numeroDeHabilidadesUsadas = numeroDeHabilidadesUsadas;
	}
	
	//Metodos
	/**
	 * Se muestran las estadisticas actuales del personaje.
	 * @return String con las estadisticas actuales.
	 */
	public String mostrarEstadisticas() {
		return "\nPERSONAJE " +
				"\n\nNombre: " + nombre + 
				"\nVida Maxima: " + vidaMaxima + 
				"\nVida Actual: " + vidaActual + 
				"\nPoder de Ataque: " + poderAtaque + 
				"\nPrecision: " + precision + "%" +
				"\nArmadura: " + armadura + 
				"\nArma: " + arma.getNombre() + 
				"\nCritico: " + arma.getProbabilidadCritico() + "%" +
				"\nNivel: " + nivel + 
				"\nExperiencia: " + experiencia + 
				"\nTiene Efecto: " + tieneEfecto + 
				"\nTipo de Efecto: " + tipoEfecto + 
				"\nDuracion de Efecto: " + duracionEfecto +
				"\nMana Actual: " + manaActual +
				"\nMana Maximo: " + manaMaximo;
	}
	
	public String mostrarPresentacion() {
		return "\nNombre: "+ANSI_CYAN + nombre + ANSI_RESET+
				"\nVida: " + ANSI_CYAN + vidaMaxima + ANSI_RESET + 
				"\nAtaque: " + ANSI_CYAN + poderAtaque + ANSI_RESET + 
				"\nPrecision: "+ ANSI_CYAN + precision + "%" + ANSI_RESET +
				"\nArmadura: " + ANSI_CYAN + armadura + ANSI_RESET + 
				"\nArma: " +  ANSI_CYAN + arma.getNombre() + ANSI_RESET + 
				"\nCritico: "+ ANSI_CYAN + precision + "%" + ANSI_RESET +
				"\nNivel: " + ANSI_CYAN + nivel + ANSI_RESET +
				"\nMana : " + ANSI_CYAN + manaMaximo + ANSI_RESET;
	}

	/**
	 * Verifica si el jugador ha subido de nivel y si es que sube de nivel reestablece la vida al maximo y sube algunas estadisticas.
	 * @return boolean true si subio de nivel, false si no subio de nivel.
	 */
	public boolean subeNivel() {
		if (this.nivel >= 1 && this.nivel <= 4) {
			if (this.nivel == 1 && this.experiencia >= 30) {
				actualizarDatosDeNivel(2, 30);
				return true;
			} else if(this.nivel == 2 && this.experiencia >= 60) {
				actualizarDatosDeNivel(3, 60);
				return true;
			} else if(this.nivel == 3 && this.experiencia >= 100) {
				actualizarDatosDeNivel(4, 100);
				return true;
			} else if(this.nivel == 4 && this.experiencia >= 150) {
				actualizarDatosDeNivel(5, 150);
				return true;
			}
		} 
		return false;
	}

	public void actualizarDatosDeNivel(int nivel, int experiencia){
		this.nivel = nivel;
		this.experiencia -= experiencia;
		vidaMaxima=(int)(vidaMaxima+vidaMaxima*0.1);
		poderAtaque=(int)(poderAtaque+poderAtaque*0.1);
		this.vidaActual = this.vidaMaxima;
		this.manaActual = this.manaMaximo;
	}
	
	/**
	 * Se verifica si se pudo atacar o no, y si es que si se calcula el daño y efectos de estado que se aplicaran al enemigo.
	 */
	public abstract String atacar(Jugador objetivo, int indice);
	
	/**
	 * Se verifica si se pudo usar la habilidad o no, y si es que si se calcula el daño y efectos de estado que se aplicaran al enemigo.
	 */
	public abstract String habilidad(Jugador objetivo, int indice);
	
	public abstract String mostrarClase();
}