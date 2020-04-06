package model;

public class Cavalier extends AbstractPiece {
	
	public Cavalier(Couleur couleur, Coord coord){
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (xFinal == this.getX() - 2) {
			if (yFinal == this.getY() - 1 || yFinal == this.getY() + 1) { 
				ret = true;
			}
		}else if (xFinal == this.getX() - 1) {
			if (yFinal == this.getY() - 2 || yFinal == this.getY() + 2) {
				ret = true;
			}
		}else if (xFinal == this.getX() + 1) {
			if (yFinal == this.getY() - 2 || yFinal == this.getY() + 2) {
				ret = true;
			}
		}else if (xFinal == this.getX() + 2) {
			if (yFinal == this.getY() - 1 || yFinal == this.getY() + 1) {
				ret = true;
			}
		}
		return ret;
	}
}
