import java.awt.event.*;
import javax.swing.*;

import animals.Sheep;
import animals.Wolf;
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
        world.newOrganism(new Wolf(3,3,world));
        world.newOrganism(new Wolf(5,8,world));
        world.newOrganism(new Sheep(10,8,world));
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