package com.choonham.data;

import java.util.ArrayList;

import com.choonham.util.EnglishToHangul;

public class DataClass {

	public static ArrayList<EnglishToHangul> us_kr_job = new ArrayList<>();
	public static ArrayList<EnglishToHangul> us_kr_marital = new ArrayList<>();
	public static ArrayList<EnglishToHangul> us_kr_housing = new ArrayList<>();
	public static ArrayList<EnglishToHangul> us_kr_loan = new ArrayList<>();
	public static ArrayList<EnglishToHangul> us_kr_contact = new ArrayList<>();


	public static ArrayList<CustomerClass> customerList = new ArrayList<>();
	public static ArrayList<CustomerClass> outputList = new ArrayList<>();
	
	public DataClass() {
	}
	
	public static void translationData() {
		us_kr_job.add(new EnglishToHangul("admin.", "관리"));
		us_kr_job.add(new EnglishToHangul("blue-collar", "노동"));
		us_kr_job.add(new EnglishToHangul("entrepreneur", "사업"));
		us_kr_job.add(new EnglishToHangul("housemaid", "가정부"));
		us_kr_job.add(new EnglishToHangul("management", "경영"));
		us_kr_job.add(new EnglishToHangul("retired", "은퇴"));
		us_kr_job.add(new EnglishToHangul("self-employed", "자영업"));
		us_kr_job.add(new EnglishToHangul("services", "서비스"));
		us_kr_job.add(new EnglishToHangul("student", "학생"));
		us_kr_job.add(new EnglishToHangul("technician", "기술자"));
		us_kr_job.add(new EnglishToHangul("unemployed", "실직"));
		us_kr_job.add(new EnglishToHangul("unknown", "모름"));
		
		us_kr_marital.add(new EnglishToHangul("divorced", "이혼"));
		us_kr_marital.add(new EnglishToHangul("married", "기혼"));
		us_kr_marital.add(new EnglishToHangul("single", "미혼"));
		
		us_kr_housing.add(new EnglishToHangul("no", "없음"));
		us_kr_housing.add(new EnglishToHangul("unknown", "모름"));
		us_kr_housing.add(new EnglishToHangul("yes", "소유"));
		
		us_kr_loan.add(new EnglishToHangul("no", "없음"));
		us_kr_loan.add(new EnglishToHangul("unknown", "모름"));
		us_kr_loan.add(new EnglishToHangul("yes", "소유"));

		us_kr_contact.add(new EnglishToHangul("cellular", "휴대폰"));
		us_kr_contact.add(new EnglishToHangul("telephone", "집전화"));
	}
	
	
}
