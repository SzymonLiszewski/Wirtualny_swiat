package animals;
import wirtual_world.Organism;
import wirtual_world.World;
import java.util.concurrent.ThreadLocalRandom;
public abstract class Animal extends Organism {
    public Animal(int strength, int initiative, int posX, int posY, World world) {
        super(strength, initiative, posX, posY, world);
    }
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
        this.world.moveOrganism(this,moveX,moveY);
    }
    public abstract void makeCopy(int x, int y, World world);
    @Override
    public String getName(){
        return "A";
    };
    public int findPlace(int x, int y, World world){
        if (x+1 < world.getSizeX() && world.getOrganism(x+1,y) == null){
            this.makeCopy(x+1, y, world);
            return 0;
        }
        if (y+1 < world.getSizeY() && world.getOrganism(x,y+1) == null){
            this.makeCopy(x, y+1, world);
            return 0;
        }
        if (x-1>=0 && world.getOrganism(x-1,y) == null){
            this.makeCopy(x-1, y, world);
            return 0;
        }
        if (y-1>=0 && world.getOrganism(x,y-1) == null){
            this.makeCopy(x, y-1, world);
            return 0;
        }
        return -1;
    }
    public void collision(Organism otherOrganism){
        if (this.getName()==otherOrganism.getName()){
            if (findPlace(this.getPosX(),this.getPosY(),this.world)==-1){
                findPlace(otherOrganism.getPosX(), otherOrganism.getPosY(), this.world);
            }
            else{
                world.printMessage("new "+ this.getName()+" was born (" +this.getPosX()+", "+this.getPosY()+")",0);
            }
        }
        else{
            if(this.getStrength()<=otherOrganism.getStrength()){
                this.world.printMessage(otherOrganism.getName() + " kills "+this.getName() + "(" + this.getPosX()+", "+this.getPosY()+")", 0);
                this.world.removeOrganism(this);
            }
            else if (this.getStrength()>otherOrganism.getStrength()){
                this.world.printMessage(this.getName() +  " kills "+otherOrganism.getName() +"(" + this.getPosX()+", "+this.getPosY()+")", 0);
                this.world.removeOrganism(otherOrganism);
            }
        }
    }
}
