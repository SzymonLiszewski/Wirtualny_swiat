package plants;

import animals.Wolf;
import wirtual_world.World;

import java.awt.*;

public class WolfBerries extends Plant{
    public WolfBerries(int posX, int posY, World world) {
        super(99, posX, posY, world);
    }

    @Override
    public void makeCopy(int x, int y, World world) {
        world.newOrganism(new WolfBerries(x,y,world));
    }
    @Override
    public Color color() {
        return Color.YELLOW;
    }
    @Override
    public String getName() {
        return "Wolfberries";
    }
    @Override
    public String emoji(){

        return "🍒";
    };
}
