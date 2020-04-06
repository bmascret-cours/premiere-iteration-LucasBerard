package model;

public class Fou extends AbstractPiece {
	
	public Fou(Couleur couleur, Coord coord){
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.coord.x == xFinal && this.coord.y == yFinal) {
			return false;
		}else if (Math.abs(this.coord.x)-xFinal == Math.abs(this.coord.y)-yFinal) {
			return true;
		}else{
			return false;
		}
	}
}