package com.choonham;

import java.io.FileWriter;
import java.io.IOException;

public class PrintClass {

	public PrintClass() { // 기본 생성자
	} // 생성자 END
	
	
	/** MainClass의 main() 내부로 부터  전달된 태그와 저장 경로 및 파일명을 **/
	/** 이용하여 html 파일을 생성하는 메서드 **/
	public static void makeHTML(String tags, String  uri) {
			FileWriter fw  = null;
			try {
				fw = new FileWriter(uri);
				fw.write(tags);
				fw.close();
			} catch(IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	} // makeHTML() END

} // class END




