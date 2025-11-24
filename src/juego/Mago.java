package juego;

/**
 * La clase mago hijo de clse personaje
 * Establece estadisticas y movimientos de mago
 * @author Etneilav Soto
 * @author Jesus Ivan
 * @author Guillermo Green
 * @author Favio Emiliano
 * @version 0.2
 */
public class Mago extends Personaje{
	Mago(String nombre, Arma arma){
		super(nombre,50,50,100,new Arma(),1,0,false,"Quemedara",2);
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
