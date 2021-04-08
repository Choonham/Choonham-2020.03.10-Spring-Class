package com.nyj.db;

import java.util.ArrayList;
import java.util.List;

public class ChicagoDataClass {
	
	public static List<ChicagoClass> chicagoList = new ArrayList<>();
	
	public ChicagoDataClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void checkData() {
		for(ChicagoClass m : chicagoList) {
			System.out.println(m.getRank() + " | " + m.getCafe() + " | " + m.getUrl());
		}
	}

}
