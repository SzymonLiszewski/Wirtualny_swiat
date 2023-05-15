package animals;

import wirtual_world.World;

import java.awt.*;

public class Human extends Animal{
    public Human(int posX, int posY, World world) {
        super(5, 4, posX, posY, world);
    }
    @Override
    public void human_action(int move){
        if (move == 1){
            this.world.moveOrganism(this,0,-1);
        }
        if (move == 2){
            this.world.moveOrganism(this,1,0);
        }
        if (move == 3){
            this.world.moveOrganism(this,0,1);
        }
        if (move == 4){
            this.world.moveOrganism(this,-1,0);
        }
    }
    @Override
    public void makeCopy(int x, int y, World world) {

    }

    @Override
    public void draw() {

    }

    @Override
    public Color color() {
        return Color.GREEN;
    }
    @Override
    public String getName() {
        return "Human";
    }
}
