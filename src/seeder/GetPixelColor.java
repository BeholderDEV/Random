package seeder;

import java.awt.image.BufferedImage;
import java.util.Random;
import web.FileTransfer;

public class GetPixelColor implements Seeder
{

    @Override
    public long getSeed() {
        BufferedImage image;
        Random r = new Random(System.nanoTime());
        image = FileTransfer.downloadImage("http://lorempixel.com/10/10");
        int clr=  image.getRGB(Math.abs(r.nextInt())%10,Math.abs(r.nextInt())%10);
        int  red   = (clr & 0xff0000) >> 16;
        int  green = (clr & 0x00ff00) >> 8;
        int  blue  =  clr & 0x0000ff;
        return red*green*blue;
    }
 
}