package com.nyj.db;

public class ChicagoClass {

	private int rank;
	private String cafe;
	private String menu;
	private String url;
	public static final String base = "http://www.chicagomag.com/Chicago-Magazine/November-2012/Best-Sandwiches-in-Chicago-";
	
	
	public ChicagoClass() {
		// TODO Auto-generated constructor stub
	}

	public ChicagoClass(String rank, String cafe, String menu, String url) {
		this.rank = Integer.parseInt(rank);
		this.cafe = replaceCharacter(cafe);
		this.menu = replaceCharacter(menu);
		this.url = sliceURL(url);
	}
	
	private String replaceCharacter(String s) {
		String r=s.replace("'", "");
		return r.replace("&", "and");
	}
	
	private String sliceURL(String url) {
		String r = url.substring(base.length());
		return r;
	}

	public int getRank() {
		return rank;
	}

	public String getCafe() {
		return cafe;
	}

	public String getMenu() {
		return menu;
	}

	public String getUrl() {
		return url;
	}

	public static String getBase() {
		return base;
	}
	
	
}
