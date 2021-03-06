package board_prj;

import java.util.ArrayList;

public class DataClass {

	ArrayList<BoardClass> boardList = new ArrayList<>();
	public DataClass() {
		this.initData();
	}
	private void initData() {
		this.boardList.add(new BoardClass(11968, "2020 07 08 클래스연습데이터7 (student, takes)" , 	"김광식", 	25));
		this.boardList.add( new BoardClass(11967, "2020 07 08 클래스연습데이터5 (학과/학생)" ,	"김정현", 62));
		this.boardList.add(new BoardClass(11965, "2020 07 07 클래스 연습 데이터 4 (부서/사원)", 	"김현정", 60));
		this.boardList.add(new BoardClass(11966, "2020 07 07 클래스 연습 데이터 4 ",	 	"김성주", 34));
		this.boardList.add(new BoardClass(11964, "2020 07 07 클래스 연습 데이터 3 (도서) ", 	"이성주", 65));
		this.boardList.add(new BoardClass(11964, "2020 07 07 클래스 연습 데이터 3 (도서) ", 	"이성주", 65));
		this.boardList.add(new BoardClass(11962, "2020 07 06 클래스 연습 데이터 (교수) ", 	 	"백태성", 48));
		this.boardList.add(new BoardClass(11962, "2020 07 06 클래스 연습 데이터 (교수) ", 	 	"백태성", 48));
		this.boardList.add( new BoardClass(11960, "2020 07 03 split() 와 클래스 연습 데이터", 	"김정현", 54));
		this.boardList.add(new BoardClass(11959, "2020 07 02 마지막 3가지 문제 ", 	 	"박광수", 92));
		this.boardList.add( new BoardClass(11958, "2020 07 02 split test ", 		 	"김현정", 53));
		this.boardList.add( new BoardClass(11957, "2020 07 02 제어문 연습데이터 ", 	 	"김정현", 64));
		this.boardList.add( new BoardClass(11956, "코드를 엉망으로 작성하는 법 ", 		 	"박광수", 43));
		this.boardList.add(new BoardClass(11955, "유지 보수 어렵게 코딩하는 방법 ",	 	"김광식", 59));
		this.boardList.add(new BoardClass(11954, "2020 07 01 Java Platform Standard Edition 8 Documentation ", "Amor vincit omnia", 29));
		this.boardList.add(new BoardClass(11641, "2019 01 30 변수, 배열, 객체, 클래스 (기초 문법 간단 요약) ", 	"박광수", 91));
		this.boardList.add(new BoardClass(11640, "2019 01 30 변수, 배열, 객체, 클래스 (기초 문법 간단 요약) ",	"김성주", 95));
		this.boardList.add(new BoardClass(11639, "2019 01 30 기본 지식 정리 ",				"김성주", 70 ));
	}
}
