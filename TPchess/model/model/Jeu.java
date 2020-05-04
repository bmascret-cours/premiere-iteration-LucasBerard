package model;

import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	private List<Pieces> pieces = null;
	private Couleur couleur;

	public Jeu(Couleur color) {
		this.couleur = color;
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
		}
		return false;
	}
	
	private Pieces findPiece(int x, int y) {
		if (isPieceHere(x, y)) {
			for (Pieces p : pieces) {
				if (x == p.getX() && y == p.getY()) {
					return p;
				}
			}
		}
		return null;
	}
    
	public Couleur getCouleur() {
		return this.couleur;
	}
	           
	public Coord getKingCoord() {
		for (Pieces p : pieces) {
			if (p.getClass().getSimpleName() == "Roi") {
				Coord c = new Coord(p.getX(),p.getY());
				return c;
			}	
		}
		return null;
	}
	           
	public Couleur getPieceColor(int x, int y) {
		Pieces p = findPiece(x, y);
		if (p != null) {
			return p.getCouleur();
		}
		return Couleur.NOIRBLANC;
	}
	           
	/**
	* @return une vue de la liste des pièces en cours
	* ne donnant que des accès en lecture sur des PieceIHM
	* (type piece + couleur + liste de coordonnées)
	*/
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		for (Pieces piece : pieces){
			boolean existe = false;
			// si le type de piece existe déjà dans la liste de PieceIHM
			// ajout des coordonnées de la pièce dans la liste de Coord de ce type
			// si elle est toujours en jeu (x et y != -1)
			for ( PieceIHM pieceIHM : list){
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					existe = true;
					if (piece.getX() != -1){
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
					}
				}
			}
			// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
			if (! existe) {
				if (piece.getX() != -1){
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
					piece.getCouleur());
					newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
	}
	           
	public java.lang.String getPieceType(int x, int y){
		Pieces p = findPiece(x, y);
		return p.getClass().getSimpleName();
	}
	           
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces p = findPiece(xInit, yInit);
		if (p != null && p.isMoveOk(xFinal, yFinal)) {
			return true;
		}
		return false;
	}
	           
	public boolean isPawnPromotion(int xFinal, int yFinal) {
		Pieces p = findPiece(xFinal, yFinal);
		if (p.getClass().getSimpleName() == "Pion" && (yFinal == 0 || yFinal == 7)) {
			return true;
		}
		return false;
	}
	           	           
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if (isMoveOk(xInit, yInit, xFinal, yFinal)) {
			Pieces p = findPiece(xInit, yInit);
			p.move(xFinal, yFinal);
			return true;
		}
		return false;
	}
	           
	public boolean pawnPromotion(int xFinal, int yFinal, java.lang.String type) {
		if (isPawnPromotion(xFinal, yFinal)) {
			Coord c = new Coord(xFinal, yFinal);
			Pieces p = null;
			if (type == "Fou") {
				p = new Fou(this.couleur, c);
			} else if (type == "Cavalier") {
				p = new Cavalier(this.couleur, c);
			} else if (type == "Tour") {
				p = new Tour(this.couleur, c);
			}else {
				p = new Reine(this.couleur, c);
			}
			Pieces pion = findPiece(xFinal, yFinal);
			this.pieces.remove(pion);
			this.pieces.add(p);
		}
		return false;
	}
}
