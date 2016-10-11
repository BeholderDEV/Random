/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author 5663296
 */
public class CongruenteLinear implements RandomGenerator{
    private long a;
    private long b;
    private long m;
    private long xn;
    private long seed;
    private long qtd;

    public CongruenteLinear(long a, long b, long m, long seed, long qtd) {
        this.a = a;
        this.b = b;
        this.m = m;
        this.seed = seed;
        this.qtd = qtd;
        this.xn = seed;
    }
    
    @Override
    public long generate() {
        System.out.println("X"+0+": "+xn);
        for (int i = 1; i < qtd; i++) {
            xn = (a*xn+b)%m;
            System.out.println("X"+i+": "+xn);
        }
        return 0;
    }
    
}
