package main;

import piece.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/// This class is use as our window screen.
public class GamePanel extends JPanel implements Runnable{

    public static final int WIDTH = 550;
    public static final int HEIGHT = 400;
    final int FPS = 60; // Frame per second.
    Thread gameThread;

    // The board panel.
    Board board = new Board();

    // COLOR.
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

    //PIECES
    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> simPieces = new ArrayList<>();

    GamePanel()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); // To set the dimension of the screen.
        setBackground(Color.black); // To set the background color.

        setPieces();
        copyPieces(pieces,simPieces);
    }

    // Add all the pieces to the pieces array.
    public void setPieces()
    {
        //White team.
        pieces.add(new Pawn(WHITE,0, 6));
        pieces.add(new Pawn(WHITE,1, 6));
        pieces.add(new Pawn(WHITE,2, 6));
        pieces.add(new Pawn(WHITE,3, 6));
        pieces.add(new Pawn(WHITE,4, 6));
        pieces.add(new Pawn(WHITE,5, 6));
        pieces.add(new Pawn(WHITE,6, 6));
        pieces.add(new Pawn(WHITE,7, 6));
        pieces.add(new Rock(WHITE,0, 7));
        pieces.add(new Rock(WHITE,7, 7));
        pieces.add(new Knight(WHITE,1, 7));
        pieces.add(new Knight(WHITE,6, 7));
        pieces.add(new Bishop(WHITE,2, 7));
        pieces.add(new Bishop(WHITE,5, 7));
        pieces.add(new Queen(WHITE,3, 7));
        pieces.add(new King(WHITE,4, 7));

        //Black team.
        pieces.add(new Pawn(BLACK,0, 1));
        pieces.add(new Pawn(BLACK,1, 1));
        pieces.add(new Pawn(BLACK,2, 1));
        pieces.add(new Pawn(BLACK,3, 1));
        pieces.add(new Pawn(BLACK,4, 1));
        pieces.add(new Pawn(BLACK,5, 1));
        pieces.add(new Pawn(BLACK,6, 1));
        pieces.add(new Pawn(BLACK,7, 1));
        pieces.add(new Rock(BLACK,0, 0));
        pieces.add(new Rock(BLACK,7, 0));
        pieces.add(new Knight(BLACK,1, 0));
        pieces.add(new Knight(BLACK,6, 0));
        pieces.add(new Bishop(BLACK,2, 0));
        pieces.add(new Bishop(BLACK,5, 0));
        pieces.add(new Queen(BLACK,3, 0));
        pieces.add(new King(BLACK,4, 0));
    }

    private void copyPieces(ArrayList<Piece> source,ArrayList<Piece> target)
    {
        target.clear();
        target.addAll(source); // Another way of copying from a list to a list.
    }

    public void launchGame()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Create the game here.
        double drawInterval = 1000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null)
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 0)
            {
                update();
                repaint(); // This method call the PaintComponent method.
                delta--;
            }
        }
    }

    // Method to update all the stuff of the game.
    private void update()
    {

    }

    // Method to paint the component on the screen.
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        // BOARD
        board.draw(g2);

        //PIECES
        for(Piece p : simPieces)
            p.draw(g2);
    }

}
