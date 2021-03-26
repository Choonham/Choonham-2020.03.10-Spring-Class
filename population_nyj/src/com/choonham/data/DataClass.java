package com.choonham.data;

import java.util.ArrayList;

public class DataClass {

	public static ArrayList<PopulationClass> popList = new ArrayList<>();
	
	public DataClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void check() {
		for(PopulationClass pc : popList) {
			System.out.println(pc.getNameOfTown() +" | " + pc.getFamilies()+" | " + pc.getTotalPopulation()+" | " + pc.getTotalMenNo() +" | "+ pc.getTotalWomenNo() +" | "+
					pc.getTotalKorean() +" | "+ pc.getMenKorean() +" | "+ pc.getWomenKorean() +" | "+ 
					pc.getTotalForeigner() +" | "+ pc.getMenForeigner() +" | "+ pc.getWomenForeigner() +  " | " + pc.getPopPerF());
		}
	}

}
