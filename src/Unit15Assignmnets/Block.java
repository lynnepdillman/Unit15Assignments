package Unit15Assignmnets;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private Color color;

    public Block() {
        
        color = Color.BLACK;
    }
    
    public Block(int x, int y) {
        xPos = x;
        yPos = y;
    }
    
    public Block(int x, int y, int w) {
        xPos = x;
        yPos = y;
        width = w;
    }
    
    public Block(int x, int y, int w, int h) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
    }

    public Block(int x, int y, int w, int h, Color c) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = c;
    }
    
    public void setPos( int x, int y) {
        xPos = x;
        yPos = y;
    }

	//add other Block constructors - x , y , width, height, color
    //add the other set methods
    public void setColor(Color col) {
        color = col;
    }

    public void draw(Graphics window) {
        //uncomment after you write the set and get methods
        window.setColor(color);
        window.fillRect(getxPos(), getyPos(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {

    }

    public boolean equals(Object obj) {
        Block test = (Block) obj;
        if (this.getColor() != null || test.getColor() != null) {
            if (this.getxPos() == test.getxPos()
                    && this.getyPos() == test.getyPos()
                    && this.getWidth() == test.getWidth()
                    && this.getHeight() == test.getHeight()
                    && this.getColor().equals(test.getColor())) {
                return true;
            }
        } else {
            if (this.getxPos() == test.getxPos()
                    && this.getyPos() == test.getyPos()
                    && this.getWidth() == test.getWidth()
                    && this.getHeight() == test.getHeight()) {
                return false;
            }
        }
        if (this.getxPos() == test.getxPos()
                && this.getyPos() == test.getyPos()
                && this.getWidth() == test.getWidth()
                && this.getHeight() == test.getHeight()
                && this.getColor().equals(test.getColor())) {
            return true;
        }
        return false;
    }

   //add the other get methods
    //add a toString() method  - x , y , width, height, color
    public String toString() {
        return getxPos() + " " + getyPos() + " " + getWidth() + " " + getHeight() + " " + getColor();
    }

    /**
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
}
