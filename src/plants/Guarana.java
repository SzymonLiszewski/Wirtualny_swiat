package plants;

import wirtual_world.Organism;
import wirtual_world.World;

import java.awt.*;

public class Guarana extends Plant{
    public Guarana(int posX, int posY, World world) {
        super(0, posX, posY, world);
    }

    @Override
    public void makeCopy(int x, int y, World world) {
        world.newOrganism(new Guarana(x,y,world));
    }
    @Override
    public Color color() {
        return Color.ORANGE;
    }
    @Override
    public String getName() {
        return "Guarana";
    }
    @Override
    public void collision(Organism otherOrganism) {
        if (!(otherOrganism instanceof Plant)){
            if (this.strength<=otherOrganism.getStrength()){
                this.world.printMessage(otherOrganism.getName()+" eats "+this.getName()+" ("+this.getPosX()+", "+this.getPosY()+") + 3 strength",0);
                otherOrganism.setStrength(otherOrganism.getStrength()+3);
                this.world.removeOrganism(this);
            }
            else if (this.strength>otherOrganism.getStrength()){
                this.world.printMessage(this.getName()+" kills "+otherOrganism.getName()+" ("+this.getPosX()+", "+this.getPosY()+")",0);
                this.world.removeOrganism(otherOrganism);
            }
        }
    }
}
