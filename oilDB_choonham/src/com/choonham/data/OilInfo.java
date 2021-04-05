package com.choonham.data;

public class OilInfo {

	private String name;
	private String address;
	private String brand;
	private String phone;
	private int isSelf;
	private int gasoline;
	private int diesel;

	public OilInfo() {
		// TODO Auto-generated constructor stub
	}

	public OilInfo(String name, String address, String brand, String phone, String isSelf, String gasoline,
			String diesel) {
		this.name = name;
		this.address = address;
		this.brand = brand;
		this.phone = phone;

		if (isSelf.equals("Y"))
			this.isSelf = 1;
		else
			this.isSelf = 0;

		this.gasoline = Integer.parseInt(gasoline);
		this.diesel = Integer.parseInt(diesel);
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getBrand() {
		return brand;
	}

	public String getPhone() {
		return phone;
	}

	public int isSelf() {
		return isSelf;
	}

	public int getGasoline() {
		return gasoline;
	}

	public int getDiesel() {
		return diesel;
	}

}
