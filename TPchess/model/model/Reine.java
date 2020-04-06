package model;

public class Reine extends AbstractPiece {

	public Reine(Couleur couleur, Coord coord){
		super(couleur, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (this.getX() == xFinal && this.getY() == yFinal) {}
		else if (xFinal == this.getX() || yFinal == this.getY()) {
			ret = true;
		}else if (Math.abs(this.getX())-xFinal == Math.abs(this.getY())-yFinal) {
			ret = true;
		}
		return ret;
	}
}