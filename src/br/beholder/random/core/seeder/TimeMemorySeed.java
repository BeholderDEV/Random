/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.random.core.seeder;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5663296
 */
public class TimeMemorySeed implements Seeder{
    Random r = new Random();
    
    @Override
    public long getSeed() {
        long seed = r.nextInt();
        seed = Math.abs(seed);
        if(seed!=0){
            return seed;
        }
        try {
            Thread.sleep(133);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimeMemorySeed.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getSeed();
    }
}
