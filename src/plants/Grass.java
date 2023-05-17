package plants;

import animals.Antelope;
import wirtual_world.World;

import java.awt.*;

public class Grass extends Plant{
    public Grass(int posX, int posY, World world) {
        super(0, posX, posY, world);
    }

    @Override
    public void makeCopy(int x, int y, World world) {
        world.newOrganism(new Grass(x,y,world));
    }

    @Override
    public Color color() {
        return Color.DARK_GRAY;
    }
    @Override
    public String getName() {
        return "Grass";
    }
    @Override
    public String emoji(){

        return "🌿";
    };
}
