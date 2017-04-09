package com.link.core;

import java.util.Random;

public class CommonUtil {

	public static int random(int max) {
		Random random = new Random();
		return random.nextInt(max);
	}
	
	public static void main(String []args) {
		System.out.println((299+1) / 20);
		System.out.println((299 +1) % 20);
		
		System.out.println((24+1) / 20);
		System.out.println((24 +1) % 20);
		
		System.out.println((5+1) / 20);
		System.out.println((5 +1) % 20);
	}
}
