package model;

public class Pion extends AbstractPiece {
		
	public Pion(Couleur couleur, Coord coord){
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (xFinal == this.getX() && yFinal == this.getY() +1) {
			return true;
		}else{
			return false;
		}
	}
}
