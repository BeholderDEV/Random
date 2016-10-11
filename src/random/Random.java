/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import metodos.CongruenteLinear;
import metodos.RandomGenerator;
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
//        RandomGenerator generator = new CongruenteLinear(5234, 4567, 1024, 123475, 10);
//        generator.generate();
        Seeder s = new TimeMemorySeed();
        for (int i = 0; i < 10; i++) {
            System.out.println(s.getSeed());
        }
    }
    
}
