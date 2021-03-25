package com.choonham.util;

import java.io.File;
import java.util.ArrayList;

import com.choonham.data.CustomerClass;
import com.choonham.data.DataClass;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelReaderClass {

	public ExcelReaderClass() {
		// TODO Auto-generated constructor stub
	}
	public static void readExcelFile(String uri) {
		File file = new File(uri);
		Workbook wb =null;
		ArrayList<String> tempArray = new ArrayList<>();
		try {
			wb = Workbook.getWorkbook(file);
			Sheet sheet = wb.getSheet(0);
			int i = 1;
			Cell cell = null;
			while(true) {
				try {
					for(int j = 1; j < 8; j++) {
						cell = sheet.getCell(j, i);
						tempArray.add(cell.getContents());
					}
					DataClass.customerList.add(new CustomerClass(tempArray.get(0), tempArray.get(1), tempArray.get(2), tempArray.get(3), 
							tempArray.get(4), tempArray.get(5), tempArray.get(6)));
					tempArray.clear();
					i++;
				} catch(Exception e) {
					break;
				}
			}
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
}
