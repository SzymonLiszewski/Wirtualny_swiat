package wirtual_world;

import wirtual_world.Organism;
import graphics.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.LinkedList;
import java.util.List;

public class World {
    private int sizeX;
    private int sizeY;
    private List<Organism> organisms_ordered = new LinkedList<>();
    private List<Organism> new_organisms = new LinkedList<>();
    private Organism[][] organisms;
    private JFrame f = new JFrame();
    public World(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        organisms = new Organism[sizeX][sizeY];
        for (int i=0;i<sizeX;i++){
            for (int j=0;j<sizeY;j++){
                organisms[i][j] = null;
            }
        }
    }
    public void makeTurn(){
        for (int i=0; i<organisms_ordered.size();i++){
            organisms_ordered.get(i).action();
        }
        for (int i=0;i<new_organisms.size();i++){
            this.addOrganism(new_organisms.get(i));
        }
        new_organisms.clear();
        //add code
    };
    public void drawWorld(){
        //JFrame f;
        //f = new JFrame();
        f.setSize(this.sizeX*21, this.sizeY*22);
        //f.setLayout(null);//using no layout managers
        f.setLayout(new GridLayout(1,1,0,0));
        Board b = new Board(this);
        Screen s = new Screen(f, this, organisms, sizeX, sizeY);
        f.add(s);
        s.setVisible(true);

        //b.setVisible(true);
        //f.add(b);
        f.setVisible(true);//making the frame visible

        //add code
    };
    public void update(){
        f.repaint();
    }
    public void newOrganism(Organism newOrganism){
        this.new_organisms.add(newOrganism);
        organisms[newOrganism.getPosX()][newOrganism.getPosY()]=newOrganism;
    };
    public void addOrganism(Organism newOrganism){
        if (this.organisms_ordered.size() == 0){
            organisms_ordered.add(newOrganism);
        }
        else{
            for (int i=0;i<organisms_ordered.size();i++){
                if (organisms_ordered.get(i).getInitiative()<newOrganism.getInitiative()){
                    organisms_ordered.add(i,newOrganism);
                    return;
                }
                else if (i == organisms_ordered.size()-1){
                    organisms_ordered.add(newOrganism);
                    return;
                }
            }
        }
    };
    public Organism getOrganism(int x, int y){
        return organisms[x][y];
    };
    public void moveOrganism(Organism organism, int x, int y){
        if (organisms[organism.getPosX()+x][organism.getPosY()+y]!=null && (x!=0||y!=0)){
            organisms[organism.getPosX()+x][organism.getPosY()+y].collision(organism);
        }
        if (organisms[organism.getPosX()+x][organism.getPosY()+y]==null && (x!=0||y!=0)){
            organisms[organism.getPosX()][organism.getPosY()] = null;
            organism.setPosX(organism.getPosX()+x);
            organism.setPosY(organism.getPosY()+y);
            organisms[organism.getPosX()][organism.getPosY()] = organism;
        }
    };
    public void removeOrganism(Organism organism){
        organisms_ordered.remove(organism);
        if (organism.getName()=="Human"){
            isHumanAlive = 0;
        }
        organisms[organism.getPosX()][organism.getPosY()] = null;
    };
    public void printMessage(String msg, int newTurn){
        System.out.println(msg);
        System.out.println("\n");
        //add code
    };
    public int isHumanAlive = 1;
    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
}
