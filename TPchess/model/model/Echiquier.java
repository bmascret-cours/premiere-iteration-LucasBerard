package model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Echiquier implements BoardGames{
	
	private String message;
	private Set<Jeu> Jeux = new HashSet<Jeu>();
	private Couleur Joueur = Couleur.BLANC;
	
	public Echiquier(){
		this.Jeux.add(new Jeu(Couleur.BLANC));
		this.Jeux.add(new Jeu(Couleur.NOIR));
	}

	private void setMessage(String message) {
		this.message = message;
	}
	
	public void switchJoueur() {
		if (this.Joueur == Couleur.BLANC) {
			this.Joueur = Couleur.NOIR;
		}else if (this.Joueur == Couleur.NOIR) {
			this.Joueur = Couleur.BLANC;
		}
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		if (0 <= xFinal && 0 <= yFinal && 7 >= xFinal && 7 >= yFinal) {
			for (Jeu j : this.Jeux) {
				if (j.isMoveOk(xInit, yInit, xFinal, yFinal)) {
					//TODO piece sur trajectoire (chemin et arrivée)
					ret = true;
				}
			}
		}
		return ret;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if (isMoveOk(xInit, yInit, xFinal, yFinal)) {
			for (Jeu j : this.Jeux) {
				j.move(xInit, yInit, xFinal, yFinal);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.Joueur;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		Couleur c = Couleur.NOIRBLANC;
		for (Jeu j : this.Jeux) { 
			c = j.getPieceColor(x, y); 
		}
		return c;
	}
	
	public List<PieceIHM> getPiecesIHM() {
		List<PieceIHM> L = new LinkedList<PieceIHM>();
		for (Jeu j : this.Jeux) { 
			L.addAll(j.getPiecesIHM());
		}
		return L;
	}
	
	public String toString() {
		String ret = "Voici mon Echiquier : \n";
		for (Jeu j : this.Jeux) { ret = ret + j.toString() + "\n"; }
		return ret;
	}
}
