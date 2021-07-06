package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import domain.Board;
import front.게시판화면;

public class BoardController {// 리스트, 출력, 글쓰기, 삭제

	public static Scanner 입력=new Scanner(System.in);
	
	public static ArrayList<Board> 게시판리스트= new ArrayList<>();
	
	public static int 게시물번호=-1;
	
	public static int 상세보기번호=-1;
	
	
	public static void 글쓰기() {
	
		Board board=new Board();
	
		System.out.println("===========글쓰기===========");
		System.out.print("제목:");
		String 제목=입력.next();
		System.out.print("\n내용:");
		String 내용=입력.next();
		//date, writerid, count는 자동주입해주기 date는 특히 date함수 만들어서 해주면됨.
		
		
		
		String 작성자=controller.MemberController.게시판작성아이디;
		
		Date 작성일= new Date();	//게시물 작성일
		
		int count=0;
		
		board.setTitle(제목);
		board.setContent(제목);
		board.setDate(작성일);
		board.setWriterid(작성자);
		board.setCount(count);
		
		게시판리스트.add(board);

		
	
	}//글쓰기 끝
	
	public static void 리스트출력() {
		
		for(int i=0; i<게시판리스트.size(); i++) {
			
			게시물번호=i+1;
			
			상세보기번호=게시물번호-1; //원래 num
			
			System.out.println("제목: "+게시판리스트.get(i).getTitle()+"\t \t 작성자: "+게시판리스트.get(i).getWriterid()+"\t 번호: "+게시물번호);
			System.out.println();
			
		}
		
		
	}//리스트출력 끝
	
	
	
	
	
	
	public static void 상세보기(int choose) {
		
		//choose랑 상세보기번호를 맞춰줘야 함. ===> how? ==> for문 써야할거같은데?

		상세보기번호=choose-1;
	
		
		System.out.println("=====================상세보기=====================");
		
		System.out.println("제목:" +게시판리스트.get(상세보기번호).getTitle());
		
		System.out.println("내용: "+게시판리스트.get(상세보기번호).getContent());
		
		System.out.println("===============================================");
		

		//댓글 작성
		
		
		
		
		
		}
	
	
	
	
	
	
	
	
}
