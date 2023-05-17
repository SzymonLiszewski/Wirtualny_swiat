package animals;

import wirtual_world.World;

import java.awt.*;

public class Wolf extends Animal {

    public Wolf(int posX, int posY, World world) {
        super(9, 5, posX, posY, world);
    }

    @Override
    public void makeCopy(int x, int y, World world) {
        world.newOrganism(new Wolf(x,y,world));
    }

    @Override
    public void draw() {

    }
    public Color color(){
        return Color.BLUE;
    }
    @Override
    public String getName() {
        return "Wolf";
    }
    @Override
    public String emoji(){

        return "🐩";
    };
}
