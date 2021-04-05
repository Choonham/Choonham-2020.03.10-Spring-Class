package com.choonham;

import com.choonham.data.DataClass;
import com.choonham.util.MethodsClass;

public class MainClass {

	public static void main(String[] args) {
		String uri = "c:/filetest/oilData/oil.xls";
		MethodsClass ms = new MethodsClass();
		ms.readExcel(uri);
		ms.setDataInto();
		String tags = ms.makeTags();
		ms.makeHTML(tags, "c:/filetest/oilData/oil.html");
		// DataClass.checkData();
	}
}
