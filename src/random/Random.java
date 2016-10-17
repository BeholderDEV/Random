/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.random.api.RandomOrgClient;
import randomjsonrpc.RandomJSONRPC;

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
//        Seeder s = new TimeMemorySeed();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(s.getSeed());
//        }
        
        // Limite diário de requets (1000)
        // Código do jar: https://github.com/RandomOrg/JSON-RPC-Java
        RandomOrgClient client = RandomOrgClient.getRandomOrgClient("d65d55e4-ac90-4e06-8bd0-1bb3d31947a6");
        int numeroInts = 10;
        try {
            int n[] = client.generateIntegers(numeroInts, 0, 500);
            for (int i = 0; i < numeroInts; i++) {
                System.out.println(n[i]);
            }
        } catch (Exception ex) {
            Logger.getLogger(RandomJSONRPC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
