package juego;

public class Espadachin extends Personaje{
	
	Espadachin(String nombre, Arma arma){
		super(nombre,70,70,80,new Arma(),1,0,false,"Sangrado",2);
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
