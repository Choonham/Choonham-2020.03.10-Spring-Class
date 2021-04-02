package com.choonham;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {
	/*
	 * 1. 클라이언트 요청 시, 문제 은행으로부터 추출된 문제를 클라이언트에 전송,
	 * 
	 * 2. 클라이언트로부터 전송받은 답을 문제은행에 제출.
	 * 
	 * 3. 문제은행이 보내준 결과를 다시 클라이언트에게 전달.
	 */

	public static void main(String[] args) throws IOException {
		// main메서드는 다른 클래스가 호출하지 않으므로 throws를 사용해도 상관이 없으나, 다른 경우에는 throws를 건 객체를 사용하는
		// 객체가 또 다시 예외 처리를 해야한다.
			
		// 클라이언트와 통신 준비 시작
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5555);
			
		} catch (IOException e) {
			System.out.println("다음 포트에 연결할 수 없습니다. : 5555");
			e.printStackTrace();
			System.exit(1); // main()을 완전히 종료
		}
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.out.println("accept() 실패");
			System.exit(1);
		}
		// 클라이언트와 통신 준비 종료

		// 클라이언트와 통신 시작

		OutputStream toSocket = clientSocket.getOutputStream();
		PrintWriter out = new PrintWriter(toSocket, true);   //입력 받는 모든 Stream을 Socket에게 보내기 위한 Writer

		InputStream fromSocket = clientSocket.getInputStream();
		InputStreamReader isr = new InputStreamReader(fromSocket);
		BufferedReader in = new BufferedReader(isr);  //Socket에 있는 모든 Stream을 읽어올 Reader

		String inputLine;
		String outputLine;
		
		// 클라이언트와 통신 종료

		// 퀴즈 시작
		QuizProtocol qp = new QuizProtocol();
		outputLine = qp.process(null);
		out.println(outputLine); //초기값 null을 넣고 프로세스 시작
		
		while ((inputLine = in.readLine()) != null) {
			outputLine = qp.process(inputLine);  //소켓에 들어온 값을 프로세스에게 전달
			out.println(outputLine);
			if (outputLine.equals("당신은 패배자입니까?")) {
				break;
			}
		}
		
		// 항상 문은 닫는 습관을 들이자
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}

}
