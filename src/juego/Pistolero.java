package juego;

/**
 * La clase pistolero hijo de clse personaje
 * Establece estadisticas y movimientos de pistolero
 * @author Etneilav Soto
 * @author Jesus Ivan
 * @author Guillermo Green
 * @author Favio Emiliano
 * @version 0.2
 */
public class Pistolero extends Personaje{
	Pistolero(String nombre, Arma arma){
		super(nombre,60,60,90,new Arma(),1,0,false,"Aturdimiento",2);
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
