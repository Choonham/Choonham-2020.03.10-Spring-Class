package com.choonham;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		MethodClass mc = new MethodClass();
		System.out.println("검색할 도서를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String inputString = sc.next();
		System.out.println(mc.search(inputString));
	}

}
 