package board_prj;

public class BoardClass {
	int no = 0;
	int hit = 0;
	String title = "";
	String author = "";
	public BoardClass() {
	}
	
	public BoardClass(int no, String title, String author, int hit) {
		this.no = no;
		this.title = title;
		this.author = author;
		this.hit = hit;
	}

}
