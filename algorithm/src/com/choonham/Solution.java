package com.choonham;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> bridgeQ = new LinkedList<Integer>();
		int totalWeightOn = 0;
		for (int i : truck_weights) {
			while (true) {
				if (bridgeQ.isEmpty()) {
					bridgeQ.add(i);
					totalWeightOn += i;
					answer++;
					break;
				} else if (bridgeQ.size() == bridge_length) {
 					totalWeightOn -= bridgeQ.poll();
				} else {
					if (totalWeightOn + i <= weight) {
						bridgeQ.add(i);
						answer++;
						totalWeightOn += i;
						break;
					} else {
						bridgeQ.add(0);
						answer++;
					}
				}
			}
		}
		return answer + bridge_length;
	}
}