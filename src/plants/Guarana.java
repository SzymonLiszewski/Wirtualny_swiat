package plants;

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
}
