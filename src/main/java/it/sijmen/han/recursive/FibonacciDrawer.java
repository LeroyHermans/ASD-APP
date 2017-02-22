package it.sijmen.han.recursive;

import java.awt.*;

/**
 * Created by Sijmen on 8-2-2017.
 */
public class FibonacciDrawer {

    private Color spiralColor = Color.BLUE;
    private Color blockColor = Color.RED;
    private boolean drawSupportLines = false;

    private Rectangle boundery;

    public FibonacciDrawer(Color spiralColor, Color blockColor, boolean drawSupportLines, Rectangle boundery) {
        this.spiralColor = spiralColor;
        this.blockColor = blockColor;
        this.drawSupportLines = drawSupportLines;
        this.boundery = boundery;
    }

    public FibonacciDrawer(Color spiralColor, Color blockColor, Rectangle boundery) {
        this.spiralColor = spiralColor;
        this.blockColor = blockColor;
        this.boundery = boundery;
    }

    public FibonacciDrawer(Rectangle boundery) {
        this.boundery = boundery;
    }

    public void draw(Graphics2D graphics, Point startLocation) {
        paintFibonacciRect(graphics, startLocation, 1, 1, Direction.UP);
    }

    private void paintFibonacciRect(Graphics2D graphics, Point point, int fiboNumber,
                                           int prevFiboNumber, Direction dir) {
        if(!this.boundery.intersects(new Rectangle(point, new Dimension(fiboNumber, fiboNumber))))
            return;
        if(drawSupportLines){
            graphics.setColor(this.blockColor);
            graphics.drawRect(point.x, point.y, fiboNumber, fiboNumber);
        }


        graphics.setColor(this.spiralColor);
        switch (dir){
            case UP:
                graphics.drawArc(point.x, point.y, 2*fiboNumber, 2*fiboNumber, 90, 90);
                break;
            case RIGHT:
                graphics.drawArc(point.x-fiboNumber, point.y, fiboNumber*2, fiboNumber*2, 0, 90);
                break;
            case DOWN:
                graphics.drawArc(point.x-fiboNumber, point.y-fiboNumber, fiboNumber*2, fiboNumber*2, 270, 90);
                break;
            case LEFT:
                graphics.drawArc(point.x, point.y-fiboNumber, fiboNumber*2, fiboNumber*2, 180, 90);
                break;
        }


        int nextFiboNumber = prevFiboNumber + fiboNumber;

        Point nextPoint = new Point(point);
        Direction nextDir = dir.next();

        switch (nextDir){
            case UP:
                nextPoint.y-=nextFiboNumber;
                break;
            case RIGHT:
                nextPoint.x+=fiboNumber;
                break;
            case DOWN:
                nextPoint.y+=fiboNumber;
                nextPoint.x-=prevFiboNumber;
                break;
            case LEFT:
                nextPoint.x-=nextFiboNumber;
                nextPoint.y-=prevFiboNumber;
                break;
        }

        paintFibonacciRect(graphics,
                nextPoint,
                nextFiboNumber, fiboNumber, nextDir);
    }

    private static Point center(Rectangle rect){
        return new Point((int)rect.getCenterX(), (int)rect.getCenterY());
    }

    enum Direction {
        UP, RIGHT, DOWN, LEFT;

        Direction next(){
            switch (this){
                case UP: return RIGHT;
                case RIGHT: return DOWN;
                case DOWN: return LEFT;
                case LEFT: return UP;
                default: return Direction.UP;
            }
        }
    }

}
