import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

import animals.*;
import plants.*;
import wirtual_world.*;
class text extends JFrame implements ActionListener {
    // JTextField
    static JTextField t, t2;
    static JFrame f;
    static JButton b;
    static JLabel l, l2;
    text()
    {
    }
    public static void main(String[] args)
    {
        f = new JFrame("textfield");
        l = new JLabel("size x: ");
        l2 = new JLabel("size y: ");
        b = new JButton("submit");
        text te = new text();

        b.addActionListener(te);

        t = new JTextField(20);
        t2 = new JTextField(20);

        JPanel p = new JPanel();

        p.add(l);
        p.add(t);
        p.add(l2);
        p.add(t2);
        p.add(b);


        f.add(p);

        f.setSize(300, 300);

        f.show();
    }

    public void drawAnimal(int x, int y, World world, int color){
        //add code
    }
    public void createWorld(int x, int y){
        World world = new World(x,y);
        int posX, posY;
        for (int i=0;i<4;i++){
            world.newOrganism(new Antelope(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
            world.newOrganism(new Fox(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
            world.newOrganism(new Sheep(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
            world.newOrganism(new Turtle(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
            world.newOrganism(new Wolf(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
            world.newOrganism(new Grass(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
            world.newOrganism(new Guarana(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
            world.newOrganism(new PineBorscht(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
            world.newOrganism(new SowThistle(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
            world.newOrganism(new WolfBerries(ThreadLocalRandom.current().nextInt(0, x),ThreadLocalRandom.current().nextInt(0, y),world));
        }
        world.newOrganism(new Human(0,0,world));

        world.drawWorld();

    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
           createWorld(Integer.parseInt(t.getText()) , Integer.parseInt(t2.getText()));
           f.dispose();
        }
    }
}