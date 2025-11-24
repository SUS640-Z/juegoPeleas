package juego;

/**
 * La clase personaje modela a un personaje elegible con caracteristicas detalladas que serviran durante el combate.
 * @author Etneilav Soto
 * @author Jesus Ivan
 * @author Guillermo Green
 * @author Favio Emiliano
 * @version 1.0
 */
public abstract class Personaje {
	//Atributos---------------------------------------------------------------------------------------------------------------------------------------------------------------
	protected String nombre;
	protected int vidaMaxima;
	protected int vidaActual;
	protected int poderAtaque;
	protected Arma arma;
	protected int nivel;
	protected int experiencia;
	protected boolean tieneEfecto;
	protected String tipoEfecto;
	protected int duracionEfecto;
	//Variable puesta por Ivan
	protected boolean disponible;
	
	
	//Constructores---------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Constructor que recibe todas las caracteristicas necesarias para que el personaje pueda ser jugable.
	 * 
	 * @param nombre Nombre del personaje
	 * @param vidaMaxima La cantidad de vida máxima que puede tener
	 * @param vidaActual La cantidad de vida que posee actualmente
	 * @param poderAtaque El daño que posee
	 * @param arma El arma que tiene equipada el personaje
	 * @param nivel Nivel actual del personaje (no del jugador)
	 * @param experiencia La progresion de experiencia para alcanzar el siguiente nivel
	 * @param tieneEfecto Saber si el personaje posee algun efecto de estado en el momento
	 * @param tipoEfecto El tipo de efecto de estado
	 * @param duracionEfecto Cuantos turnos tendrá el efecto actual
	 */
	public Personaje(String nombre, int vidaMaxima, int vidaActual, int poderAtaque, Arma arma, int nivel, int experiencia, boolean tieneEfecto, String tipoEfecto, int duracionEfecto) {
		this.nombre = nombre;
		this.vidaMaxima = vidaMaxima;
		this.vidaActual = vidaActual;
		this.poderAtaque = poderAtaque;
		this.arma = arma;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.tieneEfecto = tieneEfecto;
		this.tipoEfecto = tipoEfecto;
		this.duracionEfecto = duracionEfecto;
		this.disponible=true;
	}

	//Getters y setters---------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * @return El nombre
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return La vida maxima
	 */
	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}

	/**
	 * @return La vida actual
	 */
	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	/**
	 * @return El poder de ataque (daño)
	 */
	public int getPoderAtaque() {
		return poderAtaque;
	}

	public void setPoderAtaque(int poderAtaque) {
		this.poderAtaque = poderAtaque;
	}

	/**
	 * @return El arma
	 */
	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	/**
	 * @return El nivel actual
	 */
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return La experiencia actual
	 */
	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * @return Si tiene un efecto de estado actualmente
	 */
	public boolean isTieneEfecto() {
		return tieneEfecto;
	}

	public void setTieneEfecto(boolean tieneEfecto) {
		this.tieneEfecto = tieneEfecto;
	}

	/**
	 * @return El tipo de efecto de estado
	 */
	public String getTipoEfecto() {
		return tipoEfecto;
	}

	public void setTipoEfecto(String tipoEfecto) {
		this.tipoEfecto = tipoEfecto;
	}

	/**
	 * @return La duracion del efecto de estado
	 */
	public int getDuracionEfecto() {
		return duracionEfecto;
	}

	public void setDuracionEfecto(int duracionEfecto) {
		this.duracionEfecto = duracionEfecto;
	}
	
	//Metodos
	/**
	 * Se muestran las estadisticas actuales del personaje.
	 * @return String con las estadisticas actuales.
	 */
	public String mostrarEstadisticas() {
		return "\nPERSONAJE " +
				"\n\nNombre: " + nombre + 
				"\nVidaMaxima: " + vidaMaxima + 
				"\nVidaActual: " + vidaActual + 
				"\nPoderAtaque: " + poderAtaque + 
				"\nArma: " + arma + 
				"\nNivel: " + nivel + 
				"\nExperiencia: " + experiencia + 
				"\nTieneEfecto: " + tieneEfecto + 
				"\nTipoEfecto: " + tipoEfecto + 
				"\nDuracionEfecto: " + duracionEfecto;
	}

	/**
	 * Verifica si el jugador ha subido de nivel y si es que sube de nivel reestablece la vida al maximo y sube algunas estadisticas.
	 * @return boolean true si subio de nivel, false si no subio de nivel.
	 */
	public boolean subeNivel() {
		if (this.nivel >= 1 && this.nivel <= 4) {
			if (this.nivel == 1 && this.experiencia >= 30) {
				this.nivel = 2;
				this.experiencia -= 30;
				return true;
			} else if(this.nivel == 2 && this.experiencia >= 60) {
				this.nivel = 3;
				this.experiencia -= 60;
				return true;
			} else if(this.nivel == 3 && this.experiencia >= 100) {
				this.nivel = 4;
				this.experiencia -= 100;
				return true;
			} else if(this.nivel == 4 && this.experiencia >= 150) {
				this.nivel = 5;
				this.experiencia -= 150;
				return true;
			}
		} 
		return false;
	}
	
	/**
	 * Se verifica si se pudo atacar o no, y si es que si se calcula el daño y efectos de estado que se aplicaran al enemigo.
	 * @return boolean true si logro acertar el ataque, false si no logro acertar el ataque.
	 */
	public abstract boolean atacar();
	
	/**
	 * Se verifica si se pudo usar la habilidad o no, y si es que si se calcula el daño y efectos de estado que se aplicaran al enemigo.
	 * @return boolean true si acerto la habilidad, false si no la acerto.
	 */
	public abstract boolean habilidad();
}

