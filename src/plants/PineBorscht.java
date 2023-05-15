package plants;

import wirtual_world.World;

import java.awt.*;

public class PineBorscht extends Plant{
    public PineBorscht(int posX, int posY, World world) {
        super(10, posX, posY, world);
    }

    @Override
    public void makeCopy(int x, int y, World world) {
        world.newOrganism(new PineBorscht(x,y,world));
    }
    @Override
    public Color color() {
        return Color.PINK;
    }
    @Override
    public String getName() {
        return "PineBorscht";
    }
}
