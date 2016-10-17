/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.random.core.metodos;

/**
 *
 * @author 5663296
 */
public class CongruenteLinearUnico implements RandomGenerator{
    private long a;
    private long b;
    private long m;
    private long xn;
    private long seed;
    private long qtd;

    public CongruenteLinearUnico(long a, long b, long m, long seed, long qtd) {
        this.a = a;
        this.b = b;
        this.m = m;
        this.qtd = qtd;
        this.seed = seed;
    }

    @Override
    public long generate() {
        for (int i = 1; i < qtd; i++) {
            xn = (a*xn+b)%m;
        }
        return xn;
    }
    
}
