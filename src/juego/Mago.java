package juego;

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
