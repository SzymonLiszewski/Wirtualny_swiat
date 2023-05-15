package graphics;

import animals.Wolf;
import wirtual_world.Organism;
import wirtual_world.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen extends JPanel implements ActionListener, KeyListener, MouseListener {
    private Color color;
    private Organism[][] organisms;
    private World world;
    private int width, height;
    private JFrame frame;
    public Screen(JFrame f, World w, Organism[][] o, int  wid, int h){
        organisms = o;
        frame = f;
        world = w;
        width = wid;
        height = h;
        repaint();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        addMouseListener(this);
    }
    public void paint(Graphics g){
        super.paint(g);
        for (int i=0;i<world.getSizeX();i++){
            for (int j=0;j<world.getSizeY();j++){
                g.setColor(Color.BLACK);
                g.drawRect(i*20,j*20,20,20);
                if (organisms[i][j]!=null) {
                    g.setColor(organisms[i][j].color());
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode()==38){
            world.makeTurn();
        }
        world.update();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
