package model;

import model.Couleur;

public class Tour extends AbstractPiece {
	
	public Tour(Couleur couleur, Coord coord){
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.coord.x == xFinal && this.coord.y == yFinal) {
			return false;
		}else if (xFinal == this.coord.x || yFinal == this.coord.y) {
			return true;
		}else {
			return false;
		}
	}
}
