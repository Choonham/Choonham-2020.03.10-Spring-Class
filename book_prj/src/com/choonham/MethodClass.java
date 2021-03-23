package com.choonham;

import java.util.Arrays;

public class MethodClass {

	public MethodClass() {
	}
	
	public String search(String inputString) {
		DataClass dc = new DataClass();
		String[] outputArray = new String[5];
		String output = "";
		for(int i = 0; i < dc.bcArray.length; i++) {
			if(dc.bcArray[i].title.contains(inputString)) {
					outputArray[0] = dc.bcArray[i].author;
					outputArray[1] = dc.bcArray[i].press;
					outputArray[2] = dc.bcArray[i].image;
					outputArray[3] = Integer.toString(dc.bcArray[i].dc);
					outputArray[4] = Integer.toString(dc.bcArray[i].price);
					output = output + " "  + Arrays.toString(outputArray);
			}
		}
		return output;
	}

}
