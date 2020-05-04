package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Coord;
import model.Couleur;
import tools.ChessImageProvider;
import tools.ChessPieceImage;
import tools.ChessPiecePos;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener{
		
	private static final long serialVersionUID = 1L;
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;

	ChessGameGUI(){
		Dimension boardSize = new Dimension(600, 600);
	  
	  //  Use a Layered Pane for this this application
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);

	  //Add a chess board to the Layered Pane 
	 
		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout( new GridLayout(8, 8) );
		chessBoard.setPreferredSize( boardSize );
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
	 
		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel( new BorderLayout() );
			chessBoard.add( square );
	 
			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground( i % 2 == 0 ? Color.blue : Color.white );
			else
				square.setBackground( i % 2 == 0 ? Color.white : Color.blue );
		}
		JLabel piece;
		JPanel panel;
		for (int i = 0; i < ChessPieceImage.values().length; i++) {
		  for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
			piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(ChessPiecePos.values()[i].nom, ChessPiecePos.values()[i].couleur)));
			int comp = 8*(ChessPiecePos.values()[i].coords[j].y) + ChessPiecePos.values()[i].coords[j].x;
			panel = (JPanel)chessBoard.getComponent(comp);
			panel.add(piece);
		  }
		  
		}
	}

	public void mousePressed(MouseEvent e){
	  chessPiece = null;
	  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
	 
	  if (c instanceof JPanel) 
		  return;
	 
	  Point parentLocation = c.getParent().getLocation();
	  xAdjustment = parentLocation.x - e.getX();
	  yAdjustment = parentLocation.y - e.getY();
	  chessPiece = (JLabel)c;
	  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
	  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
	  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);

	  }
	 
	  //Move the chess piece around
	  
	public void mouseDragged(MouseEvent me) {
		if (chessPiece == null) return;
		chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	 }
	 
	  //Drop the chess piece back onto the chess board
	 
	public void mouseReleased(MouseEvent e) {
	  if(chessPiece == null) return;
	 
	  chessPiece.setVisible(false);
	  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());	 
	  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( chessPiece );
	  }
	  else {
		  Container parent = (Container)c;
		  parent.add( chessPiece );
	  }
	 
	  chessPiece.setVisible(true);
	  }
	 
	public void mouseClicked(MouseEvent e) {}
	  
	public void mouseMoved(MouseEvent e) {}
		
	public void mouseEntered(MouseEvent e){}
			
	public void mouseExited(MouseEvent e) {}
	 
  public static void main(String[] args) {
	  
	  JFrame frame = new ChessGameGUI();
	  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	  frame.pack();
	  frame.setResizable(true);
	  frame.setLocationRelativeTo( null );
	  frame.setVisible(true);
  }
}