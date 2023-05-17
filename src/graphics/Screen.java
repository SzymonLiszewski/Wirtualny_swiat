package graphics;

import animals.Wolf;
import wirtual_world.Organism;
import wirtual_world.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

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
                g.drawRect(i*World.SIZE,j*World.SIZE,World.SIZE,World.SIZE);
                if (organisms[i][j]!=null) {
                    g.setColor(organisms[i][j].color());
                    g.fillRect(i * World.SIZE, j * World.SIZE, World.SIZE, World.SIZE);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
                    g.drawString(organisms[i][j].emoji(),i * World.SIZE, j * World.SIZE+World.SIZE);
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
        //System.out.println(e.getKeyCode());
        if (e.getKeyCode()==38){//up
            world.makeTurn(1);
        }
        if (e.getKeyCode()==39){//right
            world.makeTurn(2);
        }
        if (e.getKeyCode()==40){//down
            world.makeTurn(3);
        }
        if (e.getKeyCode()==37){//left
            world.makeTurn(4);
        }
        if (e.getKeyCode()==32){//space
            if (world.getCooldown() == 0) {
                world.printMessage("Special Ability activated", 0);
                world.setSpecialAbility(1);
                world.setSpecialAbilityTimer(1);
                world.setCooldown(5);
            }
        }
        if (e.getKeyCode()==83){
            try {
                world.save();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }//s
        if (e.getKeyCode()==76){
            world.load();
        }//l
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
