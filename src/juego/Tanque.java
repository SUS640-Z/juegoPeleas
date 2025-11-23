package juego;

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
