package com.choonham.util;

public interface Methods {
	/* 엑셀 파일 Read 하는 메서드 */
	public void readExcel(String uri);

	/* DB에 Read한 데이터 저장하는 메서드 */
	public int setDataInto();

	/* DB에서 데이터 추출 후, HTML Tags 생성하는 메서드 */
	public String makeTags();

	/* Tags를 사용하여 HTML 파일 생성하는 메서드 */
	public void makeHTML(String tags, String uri);

}
