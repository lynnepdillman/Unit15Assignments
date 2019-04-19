package Unit15Assignmnets;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {

    private SpecialBall ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;		//keeps track of what keys are pressed
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private int lscore = 0, rscore = 0;
    private int ltemp = lscore, rtemp = rscore;
    private int time =0;
    public Pong() {
        //set up all game variables
        ball = new SpecialBall(100, 100, 30, 30, Color.BLUE, 1, 2);
        leftPaddle = new Paddle(100, 100, 10, 100, Color.BLUE, 2);
        rightPaddle = new Paddle(700, 100, 10, 100, Color.RED, 2);
		//instantiate a Ball

        //instantiate a left Paddle
        //instantiate a right Paddle
        keys = new boolean[5];

        //set up the Canvas
        setBackground(Color.WHITE);
        setVisible(true);

        this.addKeyListener(this);
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        time++;
//        if (rightPaddle.getyPos() > ball.getyPos()) {
//            rightPaddle.moveUpAndDraw(window);
//        } else {
//            rightPaddle.moveDownAndDraw(window);
//        }
//        if (leftPaddle.getyPos() > ball.getyPos()) {
//            leftPaddle.moveUpAndDraw(window);
//        } else {
//            leftPaddle.moveDownAndDraw(window);
//        }

//        leftPaddle.setyPos(ball.getyPos());
        window.setColor(Color.white);
        window.fillRect(0, 0, WIDTH, 101);
        window.setColor(Color.blue);
        Font font = new Font("Helvetica", Font.PLAIN, 72);
        window.setFont(font);
        window.drawString("" + lscore, 100, 100);
        window.setFont(font);
        window.setColor(Color.red);
        window.drawString("" + rscore, HEIGHT - 100, 100);
//        if(time==1){
//            time=0;
//            ball.toggle();
//        }
        ball.moveAndDraw(window);
        leftPaddle.draw(window);
        rightPaddle.draw(window);

        if (ball.collidesLeft(leftPaddle)) {
            ball.speedUp();
            ball.setXSpeed(-ball.getXSpeed());
        }
        if (ball.collidesRight(rightPaddle)) {
            ball.speedUp();
            ball.setXSpeed(-ball.getXSpeed());
        }

        if (ball.getxPos() <= 0) {
            ball.speedUp();
            ball.setXSpeed(Math.abs(ball.getXSpeed()));
            rscore++;
        }
        if (ball.getxPos() >= WIDTH - ball.getWidth()) {
            ball.speedUp();
            ball.setXSpeed(-Math.abs(ball.getXSpeed()));
            lscore++;
        }

        if (!(ball.getyPos() >= 0 && ball.getyPos() <= HEIGHT - ball.getHeight())) {
            ball.speedUp();
            ball.setYSpeed(-ball.getYSpeed());
        }

        if (keys[0] == true) {
            //move left paddle up and draw it on the window
            if (leftPaddle.getyPos() > 0) {
                leftPaddle.moveUpAndDraw(window);
            }
        }
        if (keys[1] == true) {
            //move left paddle down and draw it on the window
            if (leftPaddle.getyPos() + leftPaddle.getHeight() < HEIGHT) {
                leftPaddle.moveDownAndDraw(window);
            }

        }
        if (keys[2] == true) {
            if (rightPaddle.getyPos() > 0) {
                rightPaddle.moveUpAndDraw(window);
            }
        }
        if (keys[3] == true) {
            if (rightPaddle.getyPos() + rightPaddle.getHeight() < HEIGHT) {
                rightPaddle.moveDownAndDraw(window);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'Z':
                keys[1] = true;
                break;
            case 'I':
                keys[2] = true;
                break;
            case 'M':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'Z':
                keys[1] = false;
                break;
            case 'I':
                keys[2] = false;
                break;
            case 'M':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
        //no code needed here
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(4);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
