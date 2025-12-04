package juego;

/**
 * La clase bitacora registrar el historial de todos los movimientos del combate
 * @author Etneilav Andree Soto Valdez
 * @author Jesus Ivan Jimenez Aguilar
 * @author Guillermo Green Aviles
 * @author Favio Emiliano Sanchez Lopez
 * @version 0.2
 */
public class Bitacora {
	public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
	String accion;
	int danio;
	boolean critico;
	boolean fallo;
	int turno;
	String registros[];
	
	Bitacora() {
		registros = new String[100];
		turno=0;
	}
	
	/**
	 * Registra un ataque eleborado en un turno
	 * @param atacante personaje que realizo el ataque
	 * @param objetivo personaje que sufre el ataque
	 * @param contexto elementos extra acerca de lo transcurrido al momento de atacar
	 */	
	public void registrarAtaque(Personaje atacante, Personaje objetivo, String contexto) {
		String sucedido=(atacante.nombre+" ha atacado a "+objetivo.nombre);
		sucedido+="\n";
		sucedido+=contexto;
		registros[turno]=sucedido;
	}
	
	/**
	 * Registra una habilidad eleborada en un turno
	 * @param atacante personaje que realizo la habilidad
	 * @param objetivo personaje que sufre la habilidad
	 * @param contexto elementos extra acerca de lo transcurrido al momento de usar la habilidad
	 */	
	public void registrarHabilidad(Personaje atacante, Personaje objetivo, String contexto) {
		String sucedido=(atacante.nombre+" ha usado su habilidad contra "+objetivo.nombre);
		sucedido+="\n";
		sucedido+=contexto;
		registros[turno]=sucedido;
	}
	
	/**
	 * Añadir mas detalles de lo transcurrido en turno por culpa de un efecto
	 * @param efecto
	 */	
	public void registrarEfecto(String efecto) {
		registros[turno]+=efecto;
	}
	
	/**
	 * Se vacia la bitacora
	 */	
	public void vaciarBitacora() {
		for(int i=0; i<registros.length; i++) {
			registros[i] = null;
		}
		turno=0;
	}
	
	/**
	 * Se muestra la bitacora
	 */	
	public void mostrarBitacora() {
		if(registros[0] == null) {
			System.out.println("No se han realizado acciones");
			return;
		}
		for(int i=0; i<registros.length; i++) {
			if(registros[i] != null) {
				System.out.println(ANSI_CYAN+"\nTurno "+(i+1)+ANSI_RESET);
				System.out.println(registros[i]);
			}	
		}
	}

	
}