package com.choonham.data;

public class BankClass {

	private int duration = 0;
	private String loan = "";
	private String contact = "";
	
	
	public BankClass() {
		// TODO Auto-generated constructor stub
	}
	
	public BankClass(String loan, String contact, String duration) {
		this.loan = loan;
		this.contact = contact;
		this.duration = Integer.parseInt(duration);
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
