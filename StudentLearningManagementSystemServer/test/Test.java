/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pahansith
 */
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Test {

    public static void main(String[] args) {
        Random r = new Random();
        Set<Integer> gen = new LinkedHashSet<>();
        
        while(gen.size() < 5){
            Integer next = r.nextInt(10);
            gen.add(next);
        }
        
        for (Integer integer : gen) {
            System.out.println(integer);
        }
        
                
        
    }

    /*public static BufferedImage transform(BufferedImage image, int numquadrants) {
        int w0 = image.getWidth();
        int h0 = image.getHeight();
        int w1 = w0;
        int h1 = h0;

        int centerX = w0 / 2;
        int centerY = h0 / 2;

        if (numquadrants % 2 == 1) {
            w1 = h0;
            h1 = w0;
        }

        if (numquadrants % 4 == 1) {
            if (w0 > h0) {
                centerX = h0 / 2;
                centerY = h0 / 2;
            } else if (h0 > w0) {
                centerX = w0 / 2;
                centerY = w0 / 2;
            }
            // if h0 == w0, then use default
        } else if (numquadrants % 4 == 3) {
            if (w0 > h0) {
                centerX = w0 / 2;
                centerY = w0 / 2;
            } else if (h0 > w0) {
                centerX = h0 / 2;
                centerY = h0 / 2;
            }
            // if h0 == w0, then use default
        }

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToQuadrantRotation(numquadrants, centerX, centerY);

        AffineTransformOp opRotated = new AffineTransformOp(affineTransform,
                AffineTransformOp.TYPE_BILINEAR);

        BufferedImage transformedImage = new BufferedImage(w1, h1,
                image.getType());

        transformedImage = opRotated.filter(image, transformedImage);
        return transformedImage;
    }*/
    
}
