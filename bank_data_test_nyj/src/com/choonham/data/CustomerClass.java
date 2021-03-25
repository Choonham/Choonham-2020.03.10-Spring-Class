package com.choonham.data;

import java.util.ArrayList;

import com.choonham.util.EnglishToHangul;

public class CustomerClass extends BankClass{
	
	private int age;
	private String job; 
	private String marital;
	private String housing;
	
	
	public CustomerClass() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerClass(String age, String job, String marital, String housing, String loan, String contact, String duration) {
		super(usToKr(loan, DataClass.us_kr_loan), usToKr(contact, DataClass.us_kr_contact), duration);
		this.age = Integer.parseInt(age);
		this.job = usToKr(job, DataClass.us_kr_job);
		this.marital = usToKr(marital, DataClass.us_kr_marital);
		this.housing = usToKr(housing, DataClass.us_kr_housing);
	}
	
	private static String usToKr(String word, ArrayList<EnglishToHangul> en_kr_list) {
		String kr = "";
		for(EnglishToHangul en : en_kr_list) {
			if(word.equals(en.getEng())) {
				kr =  en.getHan();
			}
		}
		return kr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public String getHousing() {
		return housing;
	}

	public void setHousing(String housing) {
		this.housing = housing;
	}
	

}
