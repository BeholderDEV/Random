/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.util.logging.Level;
import java.util.logging.Logger;
import metodos.CongruenteLinear;
import metodos.CongruenteLinearUnico;
import metodos.RandomGenerator;
import org.random.api.RandomOrgClient;
import randomjsonrpc.RandomJSONRPC;
import seeder.GetPixelColor;
import seeder.Seeder;
import seeder.TimeMemorySeed;

/**
 *
 * @author 5663296
 */
public class Random {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Seeder s = new TimeMemorySeed();
        Seeder c =  new GetPixelColor();
        RandomGenerator generator;
        RandomOrgClient client = RandomOrgClient.getRandomOrgClient("d65d55e4-ac90-4e06-8bd0-1bb3d31947a6");
        int numeroInts = 10;
        try {
            int n[] = client.generateIntegers(numeroInts, 0, 1024);
            for (int i = 0; i < numeroInts; i++) {
                long time = s.getSeed();
                System.out.println("1");
                long org = n[i];
                System.out.println("2");
                long cor =  c.getSeed();
                System.out.println("3");
                generator = new CongruenteLinearUnico(time,org, 1024,cor, 4);
                long num = generator.generate();
                System.out.println("time:"+time+" | org:"+org+" | cor:"+cor+" | "+num);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(RandomJSONRPC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
}
