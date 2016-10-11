/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 5663296
 */
public class QuadradoDoMeio implements RandomGenerator{
    private long seed;
    private long actual;
    private long qtd;
    private long casas;
    private long low = 1;
    private long high = 100;

    public QuadradoDoMeio(long seed, long qtd, long casas) {
        this.seed = seed;
        this.qtd = qtd;
        this.casas = casas;
        this.actual = seed;
        for(int i=2;i<casas;i++){
            low = low*10;
        }
        for(int i=2;i<casas;i++){
            high = high*10;
        }
    }

    
    
    

    @Override
    public long generate() {
        System.out.println("X"+0+": "+actual);
        for (long i = 1; i < qtd; i++) {
            actual = actual*actual;
            actual = actual/low;
            actual = actual%high;
            System.out.println("X"+i+": "+actual);
        }
        return 0;
    }

    
}
