package model;

import model.Couleur;

public class Tour extends AbstractPiece {
	
	public Tour(Couleur couleur, Coord coord){
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.getX() == xFinal && this.getY() == yFinal) {
			return false;
		}else if (xFinal == this.getX() || yFinal == this.getY()) {
			return true;
		}else {
			return false;
		}
	}
}
