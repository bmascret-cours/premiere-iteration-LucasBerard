package model;

public class Fou extends AbstractPiece {
	
	public Fou(Couleur couleur, Coord coord){
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.getX() == xFinal && this.getY() == yFinal) {
			return false;
		}else if (Math.abs(this.getX())-xFinal == Math.abs(this.getY())-yFinal) {
			return true;
		}else{
			return false;
		}
	}
}