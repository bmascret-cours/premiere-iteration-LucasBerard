package model;

public class Roi extends AbstractPiece {;
	
	public Roi(Couleur couleur, Coord coord){
		super(couleur, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (this.coord.x == xFinal && this.coord.y == yFinal) {}
		else if (Math.abs(this.coord.x-xFinal)<2 && Math.abs(this.coord.y-yFinal)<2) {
			ret = true;
		}
		return ret;
	}
}