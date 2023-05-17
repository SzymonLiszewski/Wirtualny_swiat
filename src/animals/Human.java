package animals;

import wirtual_world.World;

import java.awt.*;

public class Human extends Animal{
    public Human(int posX, int posY, World world) {
        super(5, 4, posX, posY, world);
    }
    @Override
    public void human_action(int move){
        int dist = 1;
        if (this.world.getSpecialAbility()==1){dist = 2;}
        if (move == 1){
            this.world.moveOrganism(this,0,-dist);
        }
        if (move == 2){
            this.world.moveOrganism(this,dist,0);
        }
        if (move == 3){
            this.world.moveOrganism(this,0,dist);
        }
        if (move == 4){
            this.world.moveOrganism(this,-dist,0);
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
    @Override
    public String emoji(){

        return "🙂";
    };
}
