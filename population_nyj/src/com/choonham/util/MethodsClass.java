package com.choonham.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.choonham.data.DataClass;
import com.choonham.data.PopulationClass;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MethodsClass implements MethodsInterface {

	public MethodsClass() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excelReader(String uri) {
		File file = new File(uri);
		Workbook wb = null;
		ArrayList<String> tempArray = new ArrayList<>();
		
		try {
			wb = Workbook.getWorkbook(file);
			Sheet sheet = wb.getSheet(0);
			Cell cell = null;
			int n = 4;
			while (true) {
				try {
					for (int i = 1; i < 13; i++) {
						if ((i==1)||(i==2)||(i==7)||(i==8)||(i==10)||(i==11)||(i==12)) {
							cell = sheet.getCell(i, n);
							tempArray.add(cell.getContents());
						}
					}
					DataClass.popList.add(new PopulationClass(tempArray.get(0), 
							tempArray.get(1), tempArray.get(2), tempArray.get(3), tempArray.get(4), tempArray.get(5), tempArray.get(6)));
					tempArray.clear();
					n++;
				} catch (Exception e) { 
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String getMostPopulous_Foreigner() {
		String name = "";
		int greatest = 0;
		for(PopulationClass pc : DataClass.popList) {
			if(pc.getTotalForeigner() > greatest) {
				greatest = pc.getTotalForeigner();
				name = pc.getNameOfTown();
			}
		}
		return name;
	}

	@Override
	public ArrayList<String> getKoreanTown() {
		ArrayList<String> names = new ArrayList<>();
		for(PopulationClass pc : DataClass.popList) {
			if(pc.getTotalKorean()>pc.getTotalForeigner()) {
				names.add(pc.getNameOfTown());
			}
		}
		return names;
	}
	
	@Override
	public String findThePlace() { //전체 인구 대비 외국인 인구의 비율이 1% 이하인 구 중에서 세대당 인구 평균이 가장 낮은 곳이 적합할 것이라고 판단
		
		String name = "";
		float min = 3.0f;
		for(PopulationClass pc : DataClass.popList) {
			float f =(float)pc.getTotalForeigner();
			float p = (float)pc.getTotalPopulation();
			if(((f)/p)*100 <= 1) {
				if(pc.getPopPerF() <= min) {
					name = pc.getNameOfTown();
					min = pc.getPopPerF();
				}
			}
		}
		return name;
		
	}
	
	@Override
	public String makeTags(String ans1, ArrayList<String> ans2, String ans3) {
		String tags = "";
		tags = tags + "<!doctype>";
		tags = tags + "<html>";
		tags = tags + "<head><title>Population_Data_NohYoungJun</title></head>";
		tags = tags + "<body>";
		tags = tags + "<h3>  노영준 결과 자료 입니다. </h3>";
		tags = tags + "<h4> 1. 외국인 가장 많이 거주하는 지역입니다. </h4>";
		tags = tags + "<p>" + ans1 + "</p>";
		
		tags = tags + "<h4> 2. 한국인이 외국인보다 많이 거주하는 지역 리스트입니다. </h4>";
		tags = tags + "<ol>";
		for(int i = 0; i < ans2.size(); i++) {
			tags = tags + "<li>" + ans2.get(i) + "</li>";
		}
		tags = tags + "</ol>";
		
		tags = tags + "<h4>" + " 3. 민족주의 성향의 개인주의 성격을 가진 나이가 많으신 분을 위해 추천하고 싶은 지역입니다." + "</h4>";
		tags = tags + "<p>" + ans3 + "</p>";
		tags = tags + "<p>" + "*선정 기준: 전체 인구 대비 외국인 인구의 비율이 1% 이하인 구 중에서 세대당 인구 평균이 가장 낮은 곳" + "</p>";
		
		tags = tags +  "</body>";
		tags = tags + "</html>";
		
		return tags;
	}

	@Override
	public void makeHTML(String tags, String uri) {
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
