package wirtual_world;

import wirtual_world.Organism;

import java.util.LinkedList;
import java.util.List;

public class World {
    private int sizeX;
    private int sizeY;
    private List<Organism> organisms_ordered = new LinkedList<>();
    private List<Organism> new_organisms = new LinkedList<>();
    private Organism[][] organisms;
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
        //add code
    };
    public void drawWorld(){
        //add code
    };
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
                else if (i == organisms_ordered.size()){
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
            organism.setPosX(x);
            organism.setPosY(y);
            organisms[organism.getPosX()+x][organism.getPosY()+y] = organism;
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
