package com.choonham;

import com.choonham.data.DataClass;
import com.choonham.util.JDBC;
import com.choonham.util.MethodsClass;

public class MainClass {

	public static void main(String[] args) {
		MethodsClass mc = new MethodsClass();
		JDBC db = new JDBC();

		int count = db.countDB();

		if (count < 1) {
			mc.readExcel("../../filetest/sandwichs/best_sandwiches_list_chicago_price_address.xls");
			DataClass.checkData();
			db.putDataInto();
			String tags = db.makeTags();
			mc.makeHTML(tags, "../../filetest/sandwichs/sandwiches.HTML");
		}
		else {
			System.out.println("데이터 이미 있음~");
		}
	}
}
