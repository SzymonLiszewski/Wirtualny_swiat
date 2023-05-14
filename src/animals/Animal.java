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
    @Override
    public String getName(){
        return "A";
    };
    public void findPlace(){
        //write function
    }
    public void collision(Organism otherOrganism){
        if (this.getName()==otherOrganism.getName()){
            findPlace();
        }
    }
}
