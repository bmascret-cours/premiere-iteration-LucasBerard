package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	List<Pieces> pieces = null;

	public Jeu(Couleur couleur) {
		this.pieces = ChessPiecesFactory.newPieces(couleur);
	}
	
	public String toString() {
		String ret = "";
		for (Pieces p : pieces) {
			ret = ret + p.toString();
		}
		return ret;
	}
	public boolean isPieceHere(int x, int y) {
		for (Pieces p : pieces) {
			if (x == p.getX() && y == p.getY()) {
				return true;
			}
		return false;
	}
	
	private Pieces findPiece(int x, int y) {
		for (Pieces p : pieces) {
			if (isPieceHere(x,y)) {
				return p;
			}
		}
	}
	
	public static void main(String[] a) {
		Jeu Bj = new Jeu(Couleur.BLANC);
		System.out.println(Bj);
		System.out.println(findPiece(6, 7));
	}
}
