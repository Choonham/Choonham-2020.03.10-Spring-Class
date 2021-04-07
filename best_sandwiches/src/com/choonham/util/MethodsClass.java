package com.choonham.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.choonham.data.DataClass;
import com.choonham.data.MealInfo;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MethodsClass implements Methods{

	public MethodsClass() {

	}
	
	@Override
	public void readExcel(String uri) {
		File file = new File(uri);
		Workbook wb = null;
		List<String> tempArray = new ArrayList<>();

		String imgUri = "../../filetest/sandwichs/images";
		File imageFolder = new File(imgUri);
		File[] images = imageFolder.listFiles();

		try {
			wb = Workbook.getWorkbook(file);
			Sheet sheet = wb.getSheet(0);
			Cell cell = null;
			int n = 1;
			while (true) {
				try {
					for (int i = 0; i < 5; i++) {
						cell = sheet.getCell(i, n);
						tempArray.add(cell.getContents());
					}
					DataClass.mealList.add(new MealInfo(tempArray.get(0), tempArray.get(1), tempArray.get(2),
							tempArray.get(3), tempArray.get(4), images[n - 1].getName()));
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

	@Override
	public void makeHTML(String tags, String uri) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(uri);
			fw.write(tags);
			fw.close();
			System.out.println("HTML 파일 생성 완료!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
