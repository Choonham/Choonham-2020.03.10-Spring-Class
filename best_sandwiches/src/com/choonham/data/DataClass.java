package com.choonham.data;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
	
	public static List<MealInfo> mealList = new ArrayList<>();
	
	public DataClass() {
		
	}
	
	public static void checkData() {
		for(MealInfo m : mealList) {
			System.out.println(m.getRank() + " | " + m.getCafe() + " | " + m.getImgName());
		}
	}
}
