package com.nyj;

import com.nyj.db.OracleClass;
import com.nyj.files.ExcelFileReadClass;
import com.nyj.out.CreateTagHTMLClass;

public class SandwichesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelFileReadClass ex = new ExcelFileReadClass();
		OracleClass oc = new OracleClass();
		CreateTagHTMLClass html = new CreateTagHTMLClass();
		ex.loadExcelToArrayList("../../chicago/best_sandwiches_list_chicago_url.xls");
		// ChicagoDataClass.checkData();
		oc.oracleConnect();
		int n = oc.recordCount();
		if (n <= 0) {
			oc.recordInsert();
			String tags = html.createTagsReturn(oc.recordSelect());
			html.createFileForHTML("../../chicago/best_sandwiches_list_chicago_url.HTML", tags);
			oc.close();
		}
	}

}
