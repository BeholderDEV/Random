/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.random.core.seeder;

/**
 *
 * @author 5663296
 */
public class TimeMemorySeed implements Seeder{

    @Override
    public long getSeed() {
        java.util.Random r = new java.util.Random();
//            System.out.println("time: "+System.currentTimeMillis());
//            System.out.println("mem: "+Runtime.getRuntime().freeMemory());

        int size = Math.abs(r.nextInt())%8;
        size += 4;

        long[][] a = new long[size][size];

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                a[j][k]=System.currentTimeMillis();
            }
        }
        long seed = Runtime.getRuntime().freeMemory()*System.nanoTime()%1024;
        seed = Math.abs(seed);
        if(seed!=0){
            return seed;
        }
        return getSeed();
    }
}
