package wirtual_world;

import animals.*;
import plants.*;
import graphics.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class World {
    public static final int SIZE = 30;
    private int sizeX;
    private int sizeY;
    private int specialAbility;
    private int Cooldown;
    private int SpecialAbilityTimer;
    private List<Organism> organisms_ordered = new LinkedList<>();
    private List<Organism> new_organisms = new LinkedList<>();
    private Organism[][] organisms;
    public List<String> messages = new LinkedList<>();
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
        this.specialAbility = 0;
        this.Cooldown = 0;
        this.SpecialAbilityTimer = 0;
    }
    public void makeTurn(int human_move){
        messages.clear();
        printMessage("Cooldown: "+getCooldown(),0);
        printMessage("czas trwania: "+getSpecialAbilityTimer(),0);
        for (int i=0; i<organisms_ordered.size();i++){
            if (organisms_ordered.get(i).getName()=="Human") {
                organisms_ordered.get(i).human_action(human_move);
            }
            else{
                organisms_ordered.get(i).action();
            }
        }
        for (int i=0;i<new_organisms.size();i++){
            this.addOrganism(new_organisms.get(i));
        }
        new_organisms.clear();
        if (getSpecialAbilityTimer()==0&&getCooldown()>0&&getSpecialAbility()!=1){
            this.setCooldown(this.getCooldown()-1);
        }
        if (getSpecialAbilityTimer()==5){
            this.setSpecialAbility(0);
            this.setSpecialAbilityTimer(0);
        }
        if (getSpecialAbilityTimer()<5 && getSpecialAbility()==1) {
            this.setSpecialAbilityTimer(this.getSpecialAbilityTimer() + 1);
        }

        //add code
    };
    public void drawWorld(){
        //JFrame f;
        //f = new JFrame();
        f.setSize(this.sizeX*(SIZE+1)*2, (this.sizeY+2)*(SIZE));
        //f.setLayout(null);//using no layout managers
        f.setLayout(new GridLayout(1,3,0,0));
        description b = new description(this);
        Screen s = new Screen(f, this, organisms, sizeX, sizeY);
        f.add(s);
        s.setVisible(true);

        b.setVisible(true);
        f.add(b);
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
        messages.add(msg);
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
    public void SpecialAbility(){
        this.specialAbility = 1;
    }

    public int getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(int specialAbility) {
        this.specialAbility = specialAbility;
    }

    public int getCooldown() {
        return Cooldown;
    }

    public void setCooldown(int cooldown) {
        Cooldown = cooldown;
    }

    public int getSpecialAbilityTimer() {
        return SpecialAbilityTimer;
    }

    public void setSpecialAbilityTimer(int specialAbilityTimer) {
        SpecialAbilityTimer = specialAbilityTimer;
    }
    public void save() throws IOException {
        try {
            File myObj = new File("save.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("save.txt");
            myWriter.write(this.sizeX+"\n"+this.sizeY+"\n"+this.specialAbility+"\n"+this.Cooldown+"\n"+this.SpecialAbilityTimer+"\n");
            for (int i=0;i<organisms_ordered.size();i++){
                myWriter.write(organisms_ordered.get(i).getName()+" "+organisms_ordered.get(i).getPosX()+" "+organisms_ordered.get(i).getPosY()+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void load(){
        try {
            File myObj = new File("save.txt");
            Scanner myReader = new Scanner(myObj);
            this.sizeX = Integer.parseInt(myReader.nextLine());
            this.sizeY = Integer.parseInt(myReader.nextLine());
            this.specialAbility = Integer.parseInt(myReader.nextLine());
            this.Cooldown = Integer.parseInt(myReader.nextLine());
            this.SpecialAbilityTimer = Integer.parseInt(myReader.nextLine());
            this.organisms_ordered.clear();
            this.new_organisms.clear();
            for (int i=0;i<sizeX;i++){
                for (int j=0;j<sizeY;j++){
                    this.organisms[i][j]=null;
                }
            }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataarr = data.split(" ");
                if (Objects.equals(dataarr[0], "Antelope")){
                    this.newOrganism(new Antelope(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "Fox")){
                    this.newOrganism(new Fox(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "Human")){
                    this.newOrganism(new Human(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "Sheep")){
                    this.newOrganism(new Sheep(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "Turtle")){
                    this.newOrganism(new Turtle(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "Wolf")){
                    this.newOrganism(new Wolf(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "Grass")){
                    this.newOrganism(new Grass(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "Guarana")){
                    this.newOrganism(new Guarana(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "PineBorscht")){
                    this.newOrganism(new PineBorscht(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "SowThistle")){
                    this.newOrganism(new SowThistle(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
                if (Objects.equals(dataarr[0], "WolfBerries")){
                    this.newOrganism(new WolfBerries(Integer.parseInt(dataarr[1]),Integer.parseInt(dataarr[2]),this));
                }
            }
            //this.makeTurn(0);
            myReader.close();
           // f.dispose();
            this.update();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
