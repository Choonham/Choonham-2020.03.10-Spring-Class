package com.choonham.out;

import java.io.FileWriter;
import java.io.IOException;

public class PrintClass {

	public PrintClass() {
		// TODO Auto-generated constructor stub
	}

	public static void makeHTML(String tags, String uri) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(uri);
			fw.write(tags);
			fw.close();
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
