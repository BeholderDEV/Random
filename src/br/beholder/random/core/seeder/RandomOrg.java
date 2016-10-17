/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.random.core.seeder;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.random.api.RandomOrgClient;

/**
 *
 * @author lite
 */
public class RandomOrg{
    private RandomOrgClient client;
    private int numbers = 500;
    private int n[];
    private int count =0;
    private static RandomOrg rand;

    private RandomOrg() {
        client = RandomOrgClient.getRandomOrgClient("d65d55e4-ac90-4e06-8bd0-1bb3d31947a6");
        try {
            n = client.generateIntegers(numbers, 1, 1024);
        } catch (Exception ex) {
            Logger.getLogger(RandomOrg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static RandomOrg getInstance(){
        if(rand == null){
            rand = new RandomOrg();
        }
        return rand;
    }
    
    public long getSeed() {
        if(count<numbers-1){
            count++;
            return Math.abs(n[count]);
        }
        else{
            count=0;
            count++;
            try {
                n = client.generateIntegers(numbers, 1, 1024);
                return Math.abs(n[count]);
            } catch (Exception ex) {
                Logger.getLogger(RandomOrg.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 1024;
        }
    }
    
}
