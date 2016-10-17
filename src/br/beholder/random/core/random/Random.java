/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.random.core.random;

import br.beholder.random.core.metodos.CongruenteLinear;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.beholder.random.core.metodos.RandomGenerator;
import randomjsonrpc.RandomJSONRPC;
import br.beholder.random.core.seeder.GetPixelColor;
import br.beholder.random.core.seeder.RandomOrg;
import br.beholder.random.core.seeder.Seeder;
import br.beholder.random.core.seeder.TimeMemorySeed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List <Long> list;
        try {
            for (int i = 0; i < 250; i++) {
                long time = s.getSeed();
                long org = RandomOrg.getInstance().getSeed();
                long cor =  c.getSeed();
                //System.out.println("t:"+ time+" o:"+org+" c:"+cor);
                list = new ArrayList<>();
                list.add(time);
                list.add(org);
                list.add(cor);
                Collections.shuffle(list);
                generator = new CongruenteLinear(list.get(0),list.get(1), 1024,list.get(2), 3);
                long num = generator.generate();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(RandomJSONRPC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
}
