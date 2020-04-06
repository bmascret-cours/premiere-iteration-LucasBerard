package model;

public class Reine extends AbstractPiece {

	public Reine(Couleur couleur, Coord coord){
		super(couleur, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (this.coord.x == xFinal && this.coord.y == yFinal) {}
		else if (xFinal == this.coord.x || yFinal == this.coord.y) {
			ret = true;
		}else if (Math.abs(this.coord.x)-xFinal == Math.abs(this.coord.y)-yFinal) {
			ret = true;
		}
		return ret;
	}
}