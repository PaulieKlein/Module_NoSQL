package jedis;

import redis.clients.jedis.*;
import java.io.*;
import java.util.*;

public class RedisMain {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JedisPool jedisPool = new JedisPool("localhost");
		try{
			Jedis jedis = jedisPool.getResource();
			String result = jedis.get("msg");
			
			
			
			System.out.println(result);
			
			
			Scanner clavier = new Scanner(System.in);
			String key;
			String valeur;
			
			do {
				System.out.println("Veuillez entrer votre clé: "); 
				key = clavier.nextLine(); 
				System.out.println("Veuillez entrer votre valeur: "); 
				valeur = clavier.nextLine();
				
			}while(!key.equals(""));	
			
			
			jedis.set(key, valeur);
			String result2 = jedis.get("key");
			System.out.println(result2);
			
			jedisPool.returnResource(jedis);
		} finally {
			jedisPool.destroy();
			System.out.println("test2");
		}

		

	}

}
