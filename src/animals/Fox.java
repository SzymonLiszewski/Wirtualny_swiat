package animals;

import wirtual_world.World;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Fox extends Animal{
    public Fox(int posX, int posY, World world) {
        super(3, 7  , posX, posY, world);
    }
    @Override
    public void action(){
        int moveX = ThreadLocalRandom.current().nextInt(-1, 2);
        int moveY = 0;
        if (moveX == 0){
            int r = ThreadLocalRandom.current().nextInt(0, 2);
            if (r == 0){
                moveY = 1;
            }
            else{
                moveY = -1;
            }
        }
        else{
            moveY = ThreadLocalRandom.current().nextInt(-1, 2);
        }
        if (this.getPosX()+moveX>=this.world.getSizeX() || this.getPosX()+moveX<0){moveX = 0;}
        if (this.getPosY()+moveY>=this.world.getSizeY() || this.getPosY()+moveY<0){moveY = 0;}
        if (world.getOrganism(this.getPosX()+moveX,this.getPosY()+moveY)==null || world.getOrganism(this.getPosX()+moveX,this.getPosY()+moveY).getName()==this.getName() || this.strength>=world.getOrganism(this.getPosX()+moveX,this.getPosY()+moveY).getStrength()){
            this.world.moveOrganism(this,moveX,moveY);
        }
    }
    @Override
    public void makeCopy(int x, int y, World world) {
        world.newOrganism(new Fox(x,y,world));
    }

    @Override
    public void draw() {

    }

    @Override
    public Color color() {
        return Color.ORANGE;
    }
    @Override
    public String getName() {
        return "Fox";
    }
    @Override
    public String emoji(){

        return "🐕";
    };
}
