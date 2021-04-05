package com.choonham.data;

import java.util.ArrayList;

public class DataClass {

	public static ArrayList<OilInfo> oilInfoArray = new ArrayList<>();
	
	public DataClass() {
		
	}
	
	public static void checkData() {
		for(int i = 0; i < oilInfoArray.size(); i++) {
			System.out.println(oilInfoArray.get(i).getName() + " | " + oilInfoArray.get(i).getBrand() + " | " +
					oilInfoArray.get(i).getPhone() + " | "  + oilInfoArray.get(i).getAddress() + " | " + oilInfoArray.get(i).isSelf() + " | "
					+oilInfoArray.get(i).getDiesel() + " | " + oilInfoArray.get(i).getGasoline());
		}
	}

}
