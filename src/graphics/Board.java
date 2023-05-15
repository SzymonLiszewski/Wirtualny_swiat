package graphics;
import wirtual_world.*;
import animals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements KeyListener, ActionListener {
    private World world;
    public Board(World w){
        world = w;
        repaint();
    }
    public void paint (Graphics g){
        super.paint(g);
        legend(g);
    }
    public void legend(Graphics g){
       // g.setColor(Color.red);
        // g.fillRect(0,0,10,10);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
