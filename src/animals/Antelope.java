package animals;

import wirtual_world.Organism;
import wirtual_world.World;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Antelope extends Animal{
    public Antelope(int posX, int posY, World world) {
        super(4, 4, posX, posY, world);
    }

    @Override
    public void action(){
        int moveX = 2*(ThreadLocalRandom.current().nextInt(-1, 2));
        int moveY = 0;
        if (moveX == 0){
            int r = ThreadLocalRandom.current().nextInt(0, 2);
            if (r == 0){
                moveY = 2;
            }
            else{
                moveY = -2;
            }
        }
        else{
            moveY = ThreadLocalRandom.current().nextInt(-1, 2);
        }
        if (this.getPosX()+moveX>=this.world.getSizeX() || this.getPosX()+moveX<0){moveX = 0;}
        if (this.getPosY()+moveY>=this.world.getSizeY() || this.getPosY()+moveY<0){moveY = 0;}
        this.world.moveOrganism(this,moveX,moveY);
    }
    @Override
    public void collision(Organism otherOrganism){
        if (this.getName()==otherOrganism.getName()){
            if (findPlace(this.getPosX(),this.getPosY(),this.world)==-1){
                findPlace(otherOrganism.getPosX(), otherOrganism.getPosY(), this.world);
            }
        }
        else{
            if(this.getStrength()<=otherOrganism.getStrength()){
                int test = ThreadLocalRandom.current().nextInt(0, 2);
                if (test == 1){
                    this.world.printMessage("Antelope run away ("+this.getPosX()+", "+this.getPosY()+")",0);
                }
                else {
                    this.world.printMessage(otherOrganism.getName() + "kills" + this.getName() + "(" + this.getPosX() + ", " + this.getPosY() + ")", 0);
                    this.world.removeOrganism(this);
                }
            }
            else if (this.getStrength()>otherOrganism.getStrength()){
                this.world.printMessage(this.getName() +  "kills"+otherOrganism.getName() +"(" + this.getPosX()+", "+this.getPosY()+")", 0);
                this.world.removeOrganism(otherOrganism);
            }
        }
    }
    @Override
    public void makeCopy(int x, int y, World world) {
        world.newOrganism(new Antelope(x,y,world));
    }

    @Override
    public void draw() {

    }

    @Override
    public Color color() {
        return null;
    }
    @Override
    public String getName() {
        return "Antelope";
    }
    @Override
    public String emoji(){

        return "🦌";
    };
}
