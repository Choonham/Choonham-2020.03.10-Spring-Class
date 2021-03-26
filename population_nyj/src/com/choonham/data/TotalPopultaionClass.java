package com.choonham.data;

public class TotalPopultaionClass {
	
	private String nameOfTown;
	
	private int families;
	private int totalMenNo;
	private int totalWomenNo;
	private int totalPopulation;
	
	public TotalPopultaionClass() {
		
	}
	
	public TotalPopultaionClass(String nameOfTown, int families, int totalMenNo, int totalWomenNo) {
		this.nameOfTown = nameOfTown;
		this.families = families;
		this.totalMenNo = totalMenNo;
		this.totalWomenNo = totalWomenNo;
		this.totalPopulation = totalMenNo + totalWomenNo;
	}

	public int getFamilies() {
		return families;
	}

	public int getTotalMenNo() {
		return totalMenNo;
	}

	public int getTotalWomenNo() {
		return totalWomenNo;
	}

	public int getTotalPopulation() {
		return totalPopulation;
	}

	public String getNameOfTown() {
		return nameOfTown;
	}
	
}
