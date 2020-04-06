package model;

public class Cavalier extends AbstractPiece {
	
	public Cavalier(Couleur couleur, Coord coord){
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (xFinal == this.coord.x - 2) {
			if (yFinal == this.coord.x - 1 || yFinal == this.coord.x + 1) {
				ret = true;
			}
		}else if (xFinal == this.coord.x - 1) {
			if (yFinal == this.coord.x - 2 || yFinal == this.coord.x + 2) {
				ret = true;
			}
		}else if (xFinal == this.coord.x + 1) {
			if (yFinal == this.coord.x - 2 || yFinal == this.coord.x + 2) {
				ret = true;
			}
		}else if (xFinal == this.coord.x + 2) {
			if (yFinal == this.coord.x - 1 || yFinal == this.coord.x + 1) {
				ret = true;
			}
		}
		return ret;
	}
}
