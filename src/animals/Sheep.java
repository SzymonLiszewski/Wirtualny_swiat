package animals;

import wirtual_world.World;

import java.awt.*;

public class Sheep extends Animal{
    public Sheep(int posX, int posY, World world){super(4,4,posX,posY,world);}
    @Override
    public void makeCopy(int x, int y, World world) {
        world.newOrganism(new Sheep(x,y,world));
    }

    @Override
    public void draw() {

    }

    @Override
    public Color color() {
        return Color.CYAN;
    }
    @Override
    public String getName() {
        return "Sheep";
    }
}
