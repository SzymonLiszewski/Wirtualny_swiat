package graphics;

import animals.*;
import plants.*;
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
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Antelope");
        JMenuItem menuItem2 = new JMenuItem("Fox");
        JMenuItem menuItem3 = new JMenuItem("Sheep");
        JMenuItem menuItem4 = new JMenuItem("Turtle");
        JMenuItem menuItem5 = new JMenuItem("Wolf");
        JMenuItem menuItem6 = new JMenuItem("Grass");
        JMenuItem menuItem7 = new JMenuItem("Guarana");
        JMenuItem menuItem8 = new JMenuItem("PineBorscht");
        JMenuItem menuItem9 = new JMenuItem("SowThistle");
        JMenuItem menuItem10 = new JMenuItem("WolfBerries");

        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);
        popupMenu.add(menuItem4);
        popupMenu.add(menuItem5);
        popupMenu.add(menuItem6);
        popupMenu.add(menuItem7);
        popupMenu.add(menuItem8);
        popupMenu.add(menuItem9);
        popupMenu.add(menuItem10);

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new Antelope((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new Fox((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });
        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new Sheep((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });
        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new Turtle((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });
        menuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new Wolf((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });
        menuItem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new Grass((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });
        menuItem7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new Guarana((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });
        menuItem8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new PineBorscht((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });
        menuItem9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new SowThistle((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });
        menuItem10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                world.newOrganism(new WolfBerries((int)Math.floor(e.getX()/world.SIZE),(int)Math.floor(e.getY()/world.SIZE),world));
                world.update();
            }
        });


        popupMenu.show(e.getComponent(), e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
