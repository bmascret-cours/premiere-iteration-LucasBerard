package model;

public abstract class AbstractPiece implements Pieces{
	
	Coord coord;
	Couleur couleur;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur = couleur;
		this.coord = coord;
	}
	
	public boolean capture() {
		return false;
	}
      
	public Couleur getCouleur() {
		return this.couleur;
	}
	            
	public int getX() {
		Coord tmp = new Coord(this.coord.x, this.coord.y);
		return tmp.x;
	}
	            
	public int getY() {
		Coord tmp = new Coord(this.coord.x, this.coord.y);
		return tmp.y;
	}
	            
	public abstract boolean isMoveOk(int xFinal, int yFinal);
	            
	public boolean move(int x, int y) {
		if (isMoveOk(x,y)) {
			this.coord.x = x;
			this.coord.y = y;
			return true;
		}else {
			return false;
		}
	}
	            
	public java.lang.String toString(){
		return this.coord.toString()+" "+this.getClass().getSimpleName();
	}
	
	/*public static void main(String [] a){
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
		Pieces maReine = new Reine(Couleur.NOIR, new Coord(0, 0));
		Pieces monRoi = new Roi(Couleur.NOIR, new Coord(5, 5));
		Pieces monPion = new Pion(Couleur.NOIR, new Coord(5, 5));
		System.out.println(monPion.toString());
		System.out.println(maReine.toString());
		System.out.println(maTour.toString());
		System.out.println(monRoi.toString());

	}*/
}
