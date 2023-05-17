package graphics;
import animals.*;
import plants.*;
import wirtual_world.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class description extends JPanel implements KeyListener, ActionListener {
    private World world;
    public description(World w){
        world = w;
        repaint();
    }
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(new Wolf(0,0,world).color());
        g.fillRect(0, 0, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new Wolf(0,0,world).emoji()+" Wolf",0, 0+World.SIZE);

        g.setColor(new Antelope(0,0,world).color());
        g.fillRect(0, World.SIZE, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new Antelope(0,0,world).emoji()+" Antelope",0, World.SIZE*2);

        g.setColor(new Fox(0,0,world).color());
        g.fillRect(0, World.SIZE*2, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new Fox(0,0,world).emoji()+" Fox",0, World.SIZE*3);

        g.setColor(new Human(0,0,world).color());
        g.fillRect(0, World.SIZE*3, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new Human(0,0,world).emoji()+" Human",0, World.SIZE*4);

        g.setColor(new Sheep(0,0,world).color());
        g.fillRect(0, World.SIZE*4, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new Sheep(0,0,world).emoji()+" Sheep",0, World.SIZE*5);

        g.setColor(new Turtle(0,0,world).color());
        g.fillRect(0, World.SIZE*5, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new Turtle(0,0,world).emoji()+" Turtle",0, World.SIZE*6);

        g.setColor(new Grass(0,0,world).color());
        g.fillRect(0, World.SIZE*6, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new Grass(0,0,world).emoji()+" Grass",0, World.SIZE*7);

        g.setColor(new Guarana(0,0,world).color());
        g.fillRect(0, World.SIZE*7, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new Guarana(0,0,world).emoji()+" Guarana",0, World.SIZE*8);

        g.setColor(new PineBorscht(0,0,world).color());
        g.fillRect(0, World.SIZE*8, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new PineBorscht(0,0,world).emoji()+" PineBorscht",0, World.SIZE*9);

        g.setColor(new SowThistle(0,0,world).color());
        g.fillRect(0, World.SIZE*9, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new SowThistle(0,0,world).emoji()+" SowThistle",0, World.SIZE*10);

        g.setColor(new WolfBerries(0,0,world).color());
        g.fillRect(0, World.SIZE*10, World.SIZE, World.SIZE);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN,30));
        g.drawString(new WolfBerries(0,0,world).emoji()+" WolfBerries",0, World.SIZE*11);
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
