package com.nyj.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.nyj.db.ChicagoClass;
import com.nyj.db.ChicagoDataClass;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelFileReadClass {

	public ExcelFileReadClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void loadExcelToArrayList(String uri) {
		File file = new File(uri);
		Workbook wb = null;
		List<String> tempArray = new ArrayList<>();
		try {
			wb = Workbook.getWorkbook(file);
			Sheet sheet = wb.getSheet(0);
			Cell cell = null;
			int n = 1;
			while (true) {
				try {
					for (int i = 1; i < 5; i++) {
						cell = sheet.getCell(i, n);
						tempArray.add(cell.getContents());
					}
					ChicagoDataClass.chicagoList.add(new ChicagoClass(tempArray.get(0), tempArray.get(1), tempArray.get(2),
							tempArray.get(3)));
					tempArray.clear();
					n++;
				} catch (Exception e) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
