package com.choonham;

import java.util.Scanner;

import com.choonham.data.DataClass;
import com.choonham.out.PrintClass;
import com.choonham.util.ExcelReaderClass;
import com.choonham.util.ExcelWriterClass;
import com.choonham.util.MethodClass;

public class MainClass {

	public static void main(String[] args) {
		DataClass.translationData();
		ExcelReaderClass.readExcelFile("c:/filetest/bankData/bank_data.xls");
		Scanner sc = new Scanner(System.in);
		MethodClass mc = new MethodClass();
		System.out.println("검색을 시작하시려면 \"검색\" 을 입력하세요.");
		if (sc.next().equals("검색")) {
			mc.searchStart();
		}
		PrintClass.makeHTML(mc.makeTags(),"c:/filetest/bankData/bank_data.html");
		ExcelWriterClass.createExcel();
	}

}
