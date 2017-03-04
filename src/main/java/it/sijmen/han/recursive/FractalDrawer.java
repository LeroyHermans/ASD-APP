package it.sijmen.han.recursive;

import it.sijmen.han.exersises.FibonacciDrawer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sijmen on 8-2-2017.
 */
public class FractalDrawer {

    Rectangle drawingspace = new Rectangle(1920, 1080);
    BufferedImage image;

    public FractalDrawer(String filename){
        image = new BufferedImage(drawingspace.width, drawingspace.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        drawBackground(graphics);
        FibonacciDrawer drawer = new FibonacciDrawer(drawingspace);

        int radius = 150;
        for(int degree=0; degree<360; degree+=20){
            double radians = degree * Math.PI/180;
            drawer.draw(graphics, new Point(
                    (int)(drawingspace.getCenterX() + radius * Math.cos(radians)),
                    (int)(drawingspace.getCenterY() + radius * Math.sin(radians))));
        }



        writeFile(filename);
    }

    private void writeFile(String filename){
        File outputfile = new File(filename);
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawBackground(Graphics2D graphics){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, drawingspace.width, drawingspace.height);
    }

    public static void main(String[] args) {
        new FractalDrawer("image.png");
    }
}
