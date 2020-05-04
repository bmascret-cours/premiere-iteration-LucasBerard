package model;

public class Pion extends AbstractPiece {
		
	public Pion(Couleur couleur, Coord coord){
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (xFinal == this.getX()) {
			if (this.getCouleur() == Couleur.BLANC) {
				if (yFinal == this.getY()-1) {
					ret = true;
				} else if (yFinal == this.getY()-2 && this.getY() == 6) {
					ret = true;
				}
			}else if (this.getCouleur() == Couleur.NOIR) {
				if (yFinal == this.getY()+1) {
					ret = true;
				} else if (yFinal == this.getY()+2 && this.getY() == 1) {
					ret = true;
				}
			}
		}
		return ret;
	}
}
