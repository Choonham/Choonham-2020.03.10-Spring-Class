package com.choonham;

import java.util.ArrayList;

public class DataClass {

	ArrayList<BookClass> bcArray = new ArrayList<BookClass>();

	public DataClass()
	{

	}

	public DataClass(ArrayList<String> totalData) {
		this.initData(totalData);
	}

	public void initData(ArrayList<String> totalData) {
		String title = "";
		String author = "";
		String press = "";
		int  price = 0;
		int dc = 0;
		String image = "";
		
		for (String i : totalData) {
			String[] temp = i.split("__");
			title = temp[0];
			author = temp[1];
			press = temp[2];
			price = Integer.parseInt(temp[3]);
			image = temp[4];
			dc = Integer.parseInt(temp[5]);
			bcArray.add(new BookClass(image, title, dc, price, press, author));
		}
		
	}

}
