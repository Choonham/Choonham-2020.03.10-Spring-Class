package board_prj;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String way = sc.next();
		ArrayList<BoardClass> outputList = new ArrayList<BoardClass>();
		MethodClass mc = new MethodClass();
		int wayNum = mc.searchWay(way);
		while(wayNum == 99) {
			System.out.println("검색 방법을 다시 입력해주세요.");
			way = sc.next();
			wayNum = mc.searchWay(way);
		}
		String inputString = sc.next();
		outputList = mc.search(wayNum, inputString);
		for(int i = 0; i < outputList.size(); i++) {
			System.out.println(outputList.get(i).no + "-" + outputList.get(i).title + "-" + outputList.get(i).author + "-" +outputList.get(i).hit);
		}
	}
	

}
