package Unit15Assignmnets;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block {

    private int xSpeed;
    private int ySpeed;

    public Ball() {
        super(200, 200);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y) {
        super(x, y);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h) {
        super(x, y, w, h);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h, Color c, int xS, int yS) {
        super(x, y, w, h, c);
        xSpeed = xS;
        ySpeed = yS;
    }

    //add the other Ball constructors
    //add the set methods
    public void moveAndDraw(Graphics window) {
        //draw a white ball at old ball location
        setColor(Color.WHITE);
        draw(window);
        setxPos(getxPos() + getxSpeed());
        setyPos(getyPos() + getySpeed());
		//setY

        //draw the ball at its new location
        draw(window);
        //setColor(Color.BLUE);
        //draw(window, getColor());
    }

    public boolean equals(Object obj) {
        Ball test = (Ball) obj;
        return super.equals(obj) && this.getxSpeed() == test.getxSpeed() && this.getySpeed() == test.getySpeed();
    }

    //add a toString() method

    /**
     * @return the xSpeed
     */
    public int getxSpeed() {
        return xSpeed;
    }

    /**
     * @param xSpeed the xSpeed to set
     */
    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * @return the ySpeed
     */
    public int getySpeed() {
        return ySpeed;
    }

    /**
     * @param ySpeed the ySpeed to set
     */
    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
}
