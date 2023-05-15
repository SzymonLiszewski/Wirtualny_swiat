package plants;

import animals.Antelope;
import wirtual_world.World;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class SowThistle extends Plant{
    public SowThistle( int posX, int posY, World world) {
        super(0, posX, posY, world);
    }

    @Override
    public void action() {
        for (int i = 0; i < 3; i++) {
            int test = ThreadLocalRandom.current().nextInt(0, 4);
            if (test == 0) {
                int moveX = ThreadLocalRandom.current().nextInt(-1, 2);
                int moveY = ThreadLocalRandom.current().nextInt(-1, 2);
                if (this.posX + moveX >= this.world.getSizeX() || this.posX + moveX < 0) {
                    moveX = 0;
                }
                if (this.posY + moveY >= this.world.getSizeY() || this.posY + moveY < 0) {
                    moveY = 0;
                }
                if (this.world.getOrganism(this.posX + moveX, this.posY + moveY) == null) {
                    this.makeCopy(this.posX + moveX, this.posY + moveY, this.world);
                }
            }
        }
    }
    @Override
    public void makeCopy(int x, int y, World world) {
        world.newOrganism(new SowThistle(x,y,world));
    }
    @Override
    public Color color() {
        return Color.MAGENTA;
    }
}
