package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Echiquier implements BoardGames{
	
	private String message = "";
	private Set<Jeu> jeux = new HashSet<Jeu>();
	private Couleur Joueur = Couleur.BLANC;
	
	public Echiquier(){
		this.jeux.add(new Jeu(Couleur.BLANC));
		this.jeux.add(new Jeu(Couleur.NOIR));
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
		this.setMessage("KO : déplacement impossible");
		if (0 <= xFinal && 0 <= yFinal && 7 >= xFinal && 7 >= yFinal) {
			for (Jeu j : this.jeux) {
				if (j.isMoveOk(xInit, yInit, xFinal, yFinal)) {
					//TODO piece sur trajectoire (chemin et arrivée)
					ret = true;
					this.setMessage("Ok : déplacement simple");
				}
			}
		}
		return ret;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if (isMoveOk(xInit, yInit, xFinal, yFinal)) {
			for (Jeu j : this.jeux) {
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
		Iterator<Jeu> it = jeux.iterator();
		while (c == Couleur.NOIRBLANC && it.hasNext()) { 
			c = it.next().getPieceColor(x, y); 
		}
		return c;
	}
	
	public List<PieceIHM> getPiecesIHM() {
		List<PieceIHM> L = new LinkedList<PieceIHM>();
		for (Jeu j : this.jeux) { 
			L.addAll(j.getPiecesIHM());
		}
		return L;
	}
	
	public String toString() {
		String ret = "Voici mon Echiquier : \n";
		for (Jeu j : this.jeux) { ret = ret + j.toString() + "\n"; }
		return ret;
	}
}
