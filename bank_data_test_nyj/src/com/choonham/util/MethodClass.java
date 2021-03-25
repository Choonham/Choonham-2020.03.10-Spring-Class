package com.choonham.util;

import java.util.ArrayList;
import java.util.Scanner;

import com.choonham.data.CustomerClass;
import com.choonham.data.DataClass;

public class MethodClass implements MethodsInterface {

	public MethodClass() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void searchStart() {
		ArrayList<String> conditionList = new ArrayList<>();
		ArrayList<String> inputList = new ArrayList<>();
		ArrayList<String[]> result = new ArrayList<String[]>();
		while (true) {
			System.out.println("검색 조건을 입력하세요. (검색을 종료하시려면, end를 입력하세요.)");
			System.out.println("age: 18 ~ 120");
			System.out.println("job: 관리, 노동, 사업, 가정부, 경영, 은퇴, 자영업, 서비스, 학생, 기술자, 실직, 모름");
			System.out.println("marital: 기혼, 미혼, 이혼");
			System.out.println("housing: 없음, 소유, 모름");
			System.out.println("loan: 없음, 소유, 모름");
			System.out.println("contact: 휴대폰, 집전화");
			System.out.println("duration: 7 ~ 2062");
			
			Scanner scCondition = new Scanner(System.in);
			String condition = scCondition.next();
			if (condition.equals("end"))
				break;
			conditionList.add(condition);
			System.out.println("내용을 입력하세요.");
			Scanner scInput = new Scanner(System.in);
			String searchInput = scInput.next();
			if (searchInput.equals("end"))
				break;
			inputList.add(searchInput);
		}
		this.getSearchResult(conditionList, inputList);
	}

	@Override
	public void getSearchResult(ArrayList<String> searchCondition, ArrayList<String> searchInput) {
		for (int i = 0; i < searchCondition.size(); i++) {
			if (searchCondition.get(i).equals("age")) {
				if (i == 0) {
					for (CustomerClass cc : DataClass.customerList) {
						if (cc.getAge() == Integer.parseInt(searchInput.get(i))) {
							DataClass.outputList.add(cc);
						}
					}
				} else {
					for (int n = DataClass.outputList.size() - 1; n >= 0; n--) {
						if (DataClass.outputList.get(n).getAge() != Integer.parseInt(searchInput.get(i))) {
							delete(n);
						}
					}
				}
			} else if (searchCondition.get(i).equals("job")) {
				if (i == 0) {
					for (CustomerClass cc : DataClass.customerList) {
						if (cc.getJob().equals(searchInput.get(i))) {
							DataClass.outputList.add(cc);
						}
					}
					System.out.println(DataClass.outputList.size());
				} else {
					for (int n = DataClass.outputList.size() - 1; n >= 0; n--) {
						if (!DataClass.outputList.get(n).getJob().equals(searchInput.get(i))) {
							delete(n);
						}
					}
				}
			} else if (searchCondition.get(i).equals("marital")) {
				if (i == 0) {
					for (CustomerClass cc : DataClass.customerList) {
						if (cc.getMarital().equals(searchInput.get(i))) {
							DataClass.outputList.add(cc);
						}
					}
				} else {
					for (int n = DataClass.outputList.size() - 1; n >= 0; n--) {
						if (!DataClass.outputList.get(n).getMarital().equals(searchInput.get(i))) {
							delete(n);
						}
					}
				}
			} else if (searchCondition.get(i).equals("housing")) {
				if (i == 0) {
					for (CustomerClass cc : DataClass.customerList) {
						if (cc.getHousing().equals(searchInput.get(i))) {
							DataClass.outputList.add(cc);
						}
					}
				} else {
					for (int n = DataClass.outputList.size() - 1; n >= 0; n--) {
						if (!DataClass.outputList.get(n).getHousing().equals(searchInput.get(i))) {
							delete(n);
						}
					}
				}
			} else if (searchCondition.get(i).equals("loan")) {
				if (i == 0) {
					for (CustomerClass cc : DataClass.customerList) {
						if (cc.getLoan().equals(searchInput.get(i))) {
							DataClass.outputList.add(cc);
						}
					}
				} else {
					for (int n = DataClass.outputList.size() - 1; n >= 0; n--) {
						if (!DataClass.outputList.get(n).getLoan().equals(searchInput.get(i))) {
							delete(n);
						}
					}
				}
			} else if (searchCondition.get(i).equals("contact")) {
				if (i == 0) {
					for (CustomerClass cc : DataClass.customerList) {
						if (cc.getContact().equals(searchInput.get(i))) {
							DataClass.outputList.add(cc);
						}
					}
				} else {
					for (int n = DataClass.outputList.size() - 1; n >= 0; n--) {
						if (!DataClass.outputList.get(n).getContact().equals(searchInput.get(i))) {
							delete(n);
						}
					}
				}
			} else if (searchCondition.get(i).equals("duration")) {
				if (i == 0) {
					for (CustomerClass cc : DataClass.customerList) {
						if (cc.getDuration() == Integer.parseInt(searchInput.get(i))) {
							DataClass.outputList.add(cc);
						}
					}
				} else {
					for (int n = DataClass.outputList.size() - 1; n >= 0; n--) {
						if (DataClass.outputList.get(n).getDuration() != Integer.parseInt(searchInput.get(i))) {
							delete(n);
						}
					}
				}
			}
		}
	}

	public static void delete(int i) {
		DataClass.outputList.remove(i);
	}

	@Override
	public String makeTags() {
		String tags = "";
		tags = tags + "<!doctype>";
		tags = tags + "<html>";
		tags = tags + "<head><title>Bank_Data</title></head>";
		tags = tags + "<body>";
		tags = tags + "<table border='1'>";
		tags = tags + "<tr>";
		tags = tags + "<td>나이</td>";
		tags = tags + "<td>직업</td>";
		tags = tags + "<td>결혼 여부</td>";
		tags = tags + "<td>집 소유 여부</td>";
		tags = tags + "<td>대출 여부</td>";
		tags = tags + "<td>연락 방법</td>";
		tags = tags + "<td>대출 기간</td>";
		tags = tags + "</tr>";

		for (CustomerClass cc : DataClass.outputList) {
			tags = tags + "<tr>"; // 행 시작

			tags = tags + "<td>"; // 열 시작
			tags = tags + cc.getAge();
			tags = tags + "</td>"; // 열 닫기

			tags = tags + "<td>"; // 열 시작
			tags = tags + cc.getJob();
			tags = tags + "</td>"; // 열 닫기

			tags = tags + "<td>"; // 열 시작
			tags = tags + cc.getMarital();
			tags = tags + "</td>"; // 열 닫기

			tags = tags + "<td>"; // 열 시작
			tags = tags + cc.getHousing();
			tags = tags + "</td>"; // 열 닫기

			tags = tags + "<td>"; // 열 시작
			tags = tags + cc.getLoan();
			tags = tags + "</td>"; // 열 닫기

			tags = tags + "<td>"; // 열 시작
			tags = tags + cc.getContact();
			tags = tags + "</td>"; // 열 닫기

			tags = tags + "<td>"; // 열 시작
			tags = tags + cc.getDuration();
			tags = tags + "</td>"; // 열 닫기

			tags = tags + "</tr>"; // 행 닫기
		}

		tags = tags + "</table>";
		tags += "</body>";
		tags += "</html>";

		return tags;
	}

}
