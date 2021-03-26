package com.choonham.data;

public class PopulationClass extends TotalPopultaionClass{
	
	private int menKorean;
	private int womenKorean;
	private int totalKorean;
	
	private int menForeigner;
	private int womenForeigner;
	private int totalForeigner;
	private float popPerF;
	
	public PopulationClass() {
		// TODO Auto-generated constructor stub
	}
	

	public PopulationClass(String nameOfTown, String families, String menKorean, String womenKorean, String menForeigner, String womenForeigner, String popPerFam) {
		
		super(nameOfTown, Integer.parseInt(families), (Integer.parseInt(menKorean) + Integer.parseInt(menForeigner)), 
				(Integer.parseInt(womenKorean) + Integer.parseInt(womenForeigner)));
		this.menKorean = Integer.parseInt(menKorean);
		this.womenKorean = Integer.parseInt(womenKorean);
		this.totalKorean = Integer.parseInt(menKorean) + Integer.parseInt(womenKorean);
		this.menForeigner = Integer.parseInt(menForeigner);
		this.womenForeigner =Integer.parseInt( womenForeigner);
		this.totalForeigner = Integer.parseInt(menForeigner) + Integer.parseInt(womenForeigner);
		this.popPerF = Float.parseFloat(popPerFam);
	}


	public int getMenKorean() {
		return menKorean;
	}

	public int getWomenKorean() {
		return womenKorean;
	}

	public int getTotalKorean() {
		return totalKorean;
	}

	public int getMenForeigner() {
		return menForeigner;
	}

	public int getWomenForeigner() {
		return womenForeigner;
	}

	public int getTotalForeigner() {
		return totalForeigner;
	}

	public float getPopPerF() {
		return popPerF;
	}
	
}
