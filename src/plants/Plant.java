package plants;

import animals.Antelope;
import wirtual_world.Organism;
import wirtual_world.World;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Plant extends Organism {
    public Plant(int strength, int posX, int posY, World world){
        super(strength, 0, posX, posY, world);
    }
    @Override
    public void action() {
        int test = ThreadLocalRandom.current().nextInt(0, 4);
        if (test == 0){
            int moveX = ThreadLocalRandom.current().nextInt(-1, 2);
            int moveY = ThreadLocalRandom.current().nextInt(-1, 2);
            if (this.posX+moveX>=this.world.getSizeX() || this.posX+moveX<0){moveX = 0;}
            if (this.posY+moveY>=this.world.getSizeY() || this.posY+moveY<0){moveY = 0;}
            if (this.world.getOrganism(this.posX+moveX,this.posY+moveY)==null){
                this.makeCopy(this.posX+moveX,this.posY+moveY, this.world );
            }
        }
    }
    public abstract void makeCopy(int x, int y, World world);

    @Override
    public void collision(Organism otherOrganism) {
        if (!(otherOrganism instanceof Plant)){
            if (this.strength<=otherOrganism.getStrength()){
                this.world.printMessage(otherOrganism.getName()+" eats "+this.getName()+" ("+this.getPosX()+", "+this.getPosY()+")",0);
                this.world.removeOrganism(this);
            }
            else if (this.strength>otherOrganism.getStrength()){
                this.world.printMessage(this.getName()+" kills "+otherOrganism.getName()+" ("+this.getPosX()+", "+this.getPosY()+")",0);
                this.world.removeOrganism(otherOrganism);
            }
        }
    }

    @Override
    public void draw() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Color color() {
        return null;
    }
}
