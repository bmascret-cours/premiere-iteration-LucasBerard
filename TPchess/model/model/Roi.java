package model;

public class Roi extends AbstractPiece {;
	
	public Roi(Couleur couleur, Coord coord){
		super(couleur, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if (this.getX() == xFinal && this.getY() == yFinal) {}
		else if (Math.abs(this.getX()-xFinal)<2 && Math.abs(this.getY()-yFinal)<2) {
			ret = true;
		}
		return ret;
	}
}