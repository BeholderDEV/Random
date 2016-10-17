package br.beholder.random.core.seeder;

import java.awt.image.BufferedImage;
import java.util.Random;
import br.beholder.random.perlin.ImageDrawer;
import br.beholder.random.perlin.NoiseDrawer;
import br.beholder.random.perlin.NoiseGenerator;
import java.awt.Color;
import org.random.api.RandomOrgClient;

public class GetPixelColor implements Seeder
{

    @Override
    public long getSeed() {
        BufferedImage image;
        Random r = new Random(System.nanoTime());
        NoiseGenerator generator = new NoiseGenerator();
        int image_size = 10;
        float[][] noise= generator.GeneratePerlinNoise(image_size,image_size, 7);
        NoiseDrawer drawer = new NoiseDrawer();

        Color cor1= new Color((int) RandomOrg.getInstance().getSeed()%255,(int) RandomOrg.getInstance().getSeed()%255,(int) RandomOrg.getInstance().getSeed()%255);
        Color cor2= new Color((int) RandomOrg.getInstance().getSeed()%255,(int) RandomOrg.getInstance().getSeed()%255,(int) RandomOrg.getInstance().getSeed()%255);

        Color[][] colors = drawer.MapGradient(cor1, cor2, noise);
        ImageDrawer imageDrawer = new ImageDrawer();
        image = imageDrawer.generateImage(colors);
        int clr=  image.getRGB(Math.abs(r.nextInt())%image_size,Math.abs(r.nextInt())%image_size);

        int  red   = (clr & 0xff0000) >> 16;
        int  green = (clr & 0x00ff00) >> 8;
        int  blue  =  clr & 0x0000ff;
        return red*green*blue;
            
    }
 
}