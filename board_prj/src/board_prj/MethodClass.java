package board_prj;

import java.util.ArrayList;

public class MethodClass {
	DataClass dc = new DataClass();
	ArrayList<BoardClass> boardList = dc.boardList;

	public MethodClass() {
		dc = new DataClass();
	}

	public int searchWay(String way) {
		String[] searchArray = { "no", "title", "author", "hit", "all" };
		int rt = 0;
		for (int j = 0; j < searchArray.length; j++) {
			if (way.equals(searchArray[j])) {
				if (j == 0) {
						rt = 0;
						break;
				} else if (j == 1) {
						rt = 1;
						break;
				} else if (j == 2) {
						rt = 2;
						break;
				} else if(j == 3){
						rt = 3;
						break;
				}  else {
						rt = 4;
						break;
				}
			} else rt = 99;
		}
		return rt;
	}
	
	public ArrayList<BoardClass> search(int j, String inputString) {
		BoardClass bc = new BoardClass();
		ArrayList<BoardClass> outputList = new ArrayList<BoardClass>();
				if (j == 0) {
					outputList = searchByNo(Integer.parseInt(inputString));
				} else if (j == 1) {
					outputList = searchByTitle(inputString);
				} else if (j == 2) {
					outputList = searchByAuthor(inputString);
				} else if (j == 3){
					outputList = searchByHit(Integer.parseInt(inputString));
				} else {
					outputList = searchByAll(inputString);
				}
		return outputList;
	}	

	public ArrayList<BoardClass> searchByAll(String all) {
		BoardClass bc = new BoardClass();
		ArrayList<BoardClass> outputList = new ArrayList<BoardClass>();
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).title.contains(all)) {
				bc = new BoardClass(boardList.get(i).no, boardList.get(i).title, boardList.get(i).author,
						boardList.get(i).hit);
				outputList.add(bc);
			}
			else if(boardList.get(i).author.contains(all)) {
				bc = new BoardClass(boardList.get(i).no, boardList.get(i).title, boardList.get(i).author,
						boardList.get(i).hit);
				outputList.add(bc);
			}
		}
		return outputList;
	}
	
	
	public ArrayList<BoardClass> searchByNo(int no) {
		BoardClass bc = new BoardClass();
		ArrayList<BoardClass> outputList = new ArrayList<BoardClass>();
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).no == no) {
				bc = new BoardClass(boardList.get(i).no, boardList.get(i).title, boardList.get(i).author,
						boardList.get(i).hit);
				outputList.add(bc);
			}
		}
		return outputList;
	}

	public ArrayList<BoardClass> searchByTitle(String title) {
		BoardClass bc = new BoardClass();
		ArrayList<BoardClass> outputList = new ArrayList<BoardClass>();
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).title.contains(title)) {
				bc = new BoardClass(boardList.get(i).no, boardList.get(i).title, boardList.get(i).author,
						boardList.get(i).hit);
				outputList.add(bc);
			}
		}
		return outputList;
	}

	public ArrayList<BoardClass> searchByAuthor(String author) {
		BoardClass bc = new BoardClass();
		ArrayList<BoardClass> outputList = new ArrayList<BoardClass>();
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).author.contains(author)) {
				bc = new BoardClass(boardList.get(i).no, boardList.get(i).title, boardList.get(i).author,
						boardList.get(i).hit);
				outputList.add(bc);
			}
		}
		return outputList;
	}

	public ArrayList<BoardClass> searchByHit(int hit) {
		BoardClass bc = new BoardClass();
		ArrayList<BoardClass> outputList = new ArrayList<BoardClass>();
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).hit == hit) {
				bc = new BoardClass(boardList.get(i).no, boardList.get(i).title, boardList.get(i).author,
						boardList.get(i).hit);
				outputList.add(bc);
			}
		}
		return outputList;
	}

}
