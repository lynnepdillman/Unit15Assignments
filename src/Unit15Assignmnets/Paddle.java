package Unit15Assignmnets;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {

    //instance variables
    private int speed;

    public Paddle() {
        super(10, 10);
        speed = 5;
    }

    public Paddle(int xPos, int yPos) {
        super(xPos, yPos);
        this.speed = 5;
    }

    public Paddle(int xPos, int yPos, int speed) {
        super(xPos, yPos);
        this.speed = speed;
    }

    public Paddle(int xPos, int yPos, int width, int height, int speed) {
        super(xPos, yPos, width, height);
        this.speed = speed;
    }

    public Paddle(int xPos, int yPos, int width, int height, Color color, int speed) {
        super(xPos, yPos, width, height, color);
        this.speed = speed;
    }

    //add the other Paddle constructors
    public void moveUpAndDraw(Graphics window) {
        window.setColor(Color.white);
        window.fillRect(super.getxPos(),super.getyPos(),super.getWidth(),super.getHeight());
        setyPos(getyPos() - getSpeed());
        //draw(window,getColor());
        window.setColor(super.getColor());
        window.fillRect(super.getxPos(),super.getyPos(),super.getWidth(),super.getHeight());
    }

    public void moveDownAndDraw(Graphics window) {
        window.setColor(Color.white);
        window.fillRect(super.getxPos(),super.getyPos(),super.getWidth(),super.getHeight());
        setyPos(getyPos() + getSpeed());
        //draw(window,getColor());
        window.setColor(super.getColor());
        window.fillRect(super.getxPos(),super.getyPos(),super.getWidth(),super.getHeight());
    }

   //add get methods
    //add a toString() method
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "" + getxPos() + " " + getyPos() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getSpeed();
    }
}
