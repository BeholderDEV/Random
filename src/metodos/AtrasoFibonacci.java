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
public class AtrasoFibonacci implements RandomGenerator{
    private long a;
    private long b;
    private long seed;
    private long qtd;
    private long actual;
    private List<Long> longs;

    public AtrasoFibonacci(long a, long b, long seed, long qtd) {
        this.a = a;
        this.b = b;
        this.seed = seed;
        this.qtd = qtd;
        longs = new ArrayList<>();
    }

    @Override
    public long generate() {
        longs.add(a);
        longs.add(b);
        System.out.println("X0: "+a);
        System.out.println("X1: "+b);
        actual = (longs.get(0)*seed)%longs.get(1);
        longs.add(actual);
        System.out.println("X2: "+actual);
        for (int i = 3; i < qtd; i++) {
            actual = (longs.get(i-2)*longs.get(i-1))%longs.get(i-1);
            longs.add(actual);
            System.out.println("X"+i+": "+actual);
        }
        return 0;
    }
    
    
        
}
