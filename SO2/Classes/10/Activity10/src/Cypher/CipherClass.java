/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cypher;


import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import static java.security.Security.getProviders;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


/**
 *
 * @author massas
 */
public class CipherClass {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        System.out.println(Arrays.toString(getProviders()));
        
        Provider [] providers = java.security.Security.getProviders();
        
        //for each service of the first provider
        for(Provider.Service serviço: providers[0].getServices() ) {
            System.out.println("S tipo: " + serviço.getType() + ", algoritmo -> " + serviço.getAlgorithm());
        }
        
        System.out.println("\n|New task|\n");
        
        //Find out which algortihms we have available to cipher
        for(String alg: Security.getAlgorithms("Cipher") ) {
            System.out.println(alg);
        }
        
        System.out.println("\n|New task|\n");
        
        //generate AES KEY
        KeyGenerator key = KeyGenerator.getInstance("AES"); 
        SecretKey secretKey = key.generateKey();
        
        System.out.println("Encrypted key:" + secretKey.getAlgorithm());
        
        //New task
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        /* para vários blocos usar-se-ia o método update() (multiple-part encryption)
        até ao penúltimo bloco, seguido de doFinal()
         */
        
        String MSG = "aulaSO2";
        
        byte[] plaintext = MSG.getBytes();
        byte[] ciphertext = cipher.doFinal(plaintext);  // cifrar num "bloco" só

        // teste rápido para ver o q fica, que não será visível:
        System.out.println(new String(ciphertext));
        
        
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        
        
    }
}
