package com.choonham;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient {
/*
 1. 서버로부터 전송 받은 문제에 대한 입력한 답을 서버에 전달

  2. 서버로부터 전송받은 결과를 확인

  3. 문제를 계속 풀 것인지 여부를 결정.
  */
	public static void main(String[] args){
		
		Socket quizSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			//서버 접속 및 서버로 전송할 데이터 준비
			quizSocket = new Socket("localhost", 5555);
			OutputStream toSocket = quizSocket.getOutputStream();
			out = new PrintWriter(toSocket, true);
			
			//서버로부터 전송된 데이터 읽기 준비
			InputStream fromSocket = quizSocket.getInputStream();
			InputStreamReader quizIsr = new InputStreamReader(fromSocket);
			in = new BufferedReader(quizIsr);  //Socket에 있는 Stream을 싸그리 싹싹 Read
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader user = new BufferedReader(isr);  //콘솔창 입력 Stream을 싸그리 싹싹 Read
			
			String fromServer;
			String fromUser;
			
			while((fromServer = in.readLine()) != null) {
				System.out.println("서버 =>" + fromServer); //Socket에 있는 Stream을 읽어서 확인
				if(fromServer.equals("당신은 패배자입니까?")) {
					break;
				}
				
				fromUser = user.readLine();
				if(fromUser != null) {  //유저가 입력한 콘솔 Stream을 읽어서 확인
					System.out.println("클라이언트 =>" + fromUser);
					out.println(fromUser);
				}
			}
			out.close();
			in.close();
			quizSocket.close();
		} catch(UnknownHostException e) {
			System.out.println("Localhost에 접근할 수 없습니다.");
			System.exit(1);
		} catch(IOException e) {
			System.out.println("입출력 오류");
			System.exit(1);
		}
	
	}

}
