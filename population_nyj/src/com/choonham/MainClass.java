package com.choonham;

import java.util.ArrayList;

import com.choonham.data.DataClass;
import com.choonham.util.MethodsClass;

public class MainClass {

	public static void main(String[] args) {
		MethodsClass mc = new MethodsClass();
		mc.excelReader("c:/filetest/populationData/population_in_Seoul_edit.xls");
		DataClass.check();
		String ans1 = mc.getMostPopulous_Foreigner();
		ArrayList<String> ans2 = mc.getKoreanTown();
		String ans3 = mc.findThePlace();
		
		mc.makeHTML(mc.makeTags(ans1, ans2, ans3), "c:/filetest/populationData/population_in_Seoul.HTML");
		
	}	

}
