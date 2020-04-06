package model;

public class Pion extends AbstractPiece {
		
	public Pion(Couleur couleur, Coord coord){
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (xFinal == this.coord.x && yFinal == this.coord.y +1) {
			return true;
		}else{
			return false;
		}
	}
}
