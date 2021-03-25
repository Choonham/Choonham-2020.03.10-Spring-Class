package com.choonham.util;

import java.io.File;

import com.choonham.data.DataClass;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelWriterClass {

	public ExcelWriterClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void createExcel() {
		String uri = "c:/filetest/bankData/output_data.xls";
		File file = new File(uri);
		WritableWorkbook wb = null;
		try {
			wb = Workbook.createWorkbook(file);
			WritableSheet sheet = wb.createSheet("output", 0);
			
			for(int i =0; i < DataClass.outputList.size(); i++) {
				Label label0 = new Label(0, i, Integer.toString(DataClass.outputList.get(i).getAge()));
				Label label1 = new Label(1, i, DataClass.outputList.get(i).getJob());
				Label label2 = new Label(2, i, DataClass.outputList.get(i).getMarital());
				Label label3 = new Label(3, i, DataClass.outputList.get(i).getHousing());
				Label label4 = new Label(4, i, DataClass.outputList.get(i).getLoan());
				Label label5 = new Label(5, i, DataClass.outputList.get(i).getContact());
				Label label6 = new Label(6, i, Integer.toString(DataClass.outputList.get(i).getDuration()));
				sheet.addCell(label0);
				sheet.addCell(label1);
				sheet.addCell(label2);
				sheet.addCell(label3);
				sheet.addCell(label4);
				sheet.addCell(label5);
				sheet.addCell(label6);
			}
			wb.write();
			wb.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
