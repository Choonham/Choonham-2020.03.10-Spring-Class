package com.choonham;

import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args)  throws IOException {
		int bridgeLength = 2; 
		int weight = 10;
		int[] truckWeight = {7,4,5,6};
		
		Solution s = new Solution();
		int result = s.solution(bridgeLength,weight,truckWeight);
		System.out.println(result);
	}
	
}

