package juego;

/**
 * La clase tanque hijo de clse personaje
 * Establece estadisticas y movimientos de tanque
 * @author Etneilav Soto
 * @author Jesus Ivan
 * @author Guillermo Green
 * @author Favio Emiliano
 * @version 0.2
 */
public class Tanque extends Personaje {
	Tanque(String nombre, Arma arma){
		super(nombre,100,100,50,new Arma(),1,0,false,"Escudo",2);
	}

	@Override
	public boolean atacar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean habilidad() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
