package wirtual_world;

import java.awt.*;

public abstract class Organism {
    protected int  strength;
protected int initiative;
protected int posX;
protected int posY;
protected World world;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Organism() {
    }

    public Organism(int strength, int initiative, int posX, int posY, World world) {
        this.strength = strength;
        this.initiative = initiative;
        this.posX = posX;
        this.posY = posY;
        this.world = world;
    }
    abstract public void action();
    abstract public void collision(Organism otherOrganism);
    abstract public void draw();
    abstract public String getName();
    abstract public Color color();
}
