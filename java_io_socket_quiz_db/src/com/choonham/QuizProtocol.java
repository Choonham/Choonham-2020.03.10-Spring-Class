package com.choonham;

public class QuizProtocol {
	/*
	 * 1. 서버 요청이 있을 경우 문제를 보내주고, 2. 서버로부터 전달 받은 답을 확인 후, 그 결과를 서버에 전송.
	 * 
	 */
	// 상수 선언(상태 및 문항 수), 0:대기, 1:문제 진행 중, 2: 답 제출, 3: 제공 문항 수
	private static final int WAITING = 0;
	private static final int PROBLEM = 1;
	private static final int ANSWER = 2;
	private static final int NUMOFPRO = 5;
	// 상태를 저장하는 변수(대기, 문제, 정답, 제공 문항 수)
	private int state = WAITING;
	// 현재 문항 정보를 저장할 변수
	private int currentProblem = 0;
	// 문제 배열과 정답 배열
	private String[] problems = { "20x20?", "뭉치의 견종은?", "가장 유익한 TIL 블로그는? ", "당신이 지금부터 해야할 일은?", "저녁은?" };
	private String[] answers = { "400", "푸들", "choonham's TIL", "코딩테스트 풀이", "치킨 제발"};

	public QuizProtocol() {
		// TODO Auto-generated constructor stub
	}

	// 문제를 제공하고 정답을 확인해주는 전반적인 프로세스 메서드
	public String process(String theInput) {
		String theOutput = null; // 결과를 서버에 보내기 위한 변수

		if (state == WAITING) {
			theOutput = "퀴즈를 시작합니다.(y/n)";  	// 초기 대기 상태일 경우, client에게 보여질 내용
			state = PROBLEM;
		} else if (state == PROBLEM) {     // client가 계속 문제를 진행할 것인지 여부
			if (theInput.equalsIgnoreCase("y")) {  
				theOutput = problems[currentProblem % NUMOFPRO]; // 문제 제공
				state = ANSWER;
			} else {
				state = WAITING;
				theOutput = "당신은 패배자입니까?";
			}
		} else if (state == ANSWER) {
			if (theInput.equalsIgnoreCase(answers[currentProblem % NUMOFPRO])) {
				theOutput = "성공, 당신은 했습니다. (도전 계속? y, 시시 n)"; 		// 답이 제출되었을 때
				state = PROBLEM;
			} else {
				theOutput = "실패, 빡대가리 당신입니다. (꼬우면 y, 인정하면 n)";
				state = PROBLEM;
			}
			currentProblem++;
		}

		return theOutput;
	}

}
