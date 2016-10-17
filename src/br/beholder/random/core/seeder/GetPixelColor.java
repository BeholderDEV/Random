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
        RandomOrgClient client = RandomOrgClient.getRandomOrgClient("d65d55e4-ac90-4e06-8bd0-1bb3d31947a6");
        int numeroInts = 6;
        int image_size = 100;
        try {
            int n[] = client.generateIntegers(numeroInts, 0, 255);
            float[][] noise= generator.GeneratePerlinNoise(image_size,image_size, 7);
            NoiseDrawer drawer = new NoiseDrawer();
            Color[][] colors = drawer.MapGradient(new Color(n[0],n[1],n[2]), new Color(n[3],n[4],n[5]), noise);
            ImageDrawer imageDrawer = new ImageDrawer();
            image = imageDrawer.generateImage(colors);
            int clr=  image.getRGB(Math.abs(r.nextInt())%image_size,Math.abs(r.nextInt())%image_size);
            int  red   = (clr & 0xff0000) >> 16;
            int  green = (clr & 0x00ff00) >> 8;
            int  blue  =  clr & 0x0000ff;
            return red*green/blue;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return 1;
    }
 
}