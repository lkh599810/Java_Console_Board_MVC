package front;

import java.util.Scanner;

public class 댓글화면 {

	
	
	
	public 댓글화면() {
		
	}
	
	public static void 댓글화면출력(int boardnum) {//from Boardcontroller-상세보기
		
		System.out.println();
		System.out.println("====================댓글목록===================");
		System.out.println("1. 댓글쓰기 \t 2.댓글삭제"); 
		System.out.println("=============================================");

		
		controller.CommentController.댓글목록(boardnum);
		
		System.out.println("=============================================");
		
		
		Scanner 입력=new Scanner(System.in);
		
		int choose=입력.nextInt();
		
		if(choose ==1) {
			controller.CommentController.댓글쓰기(boardnum);
			
			
		}
		if(choose==2) {
			
			//writerid 받아오기 & commentnum 받아오기
			
			System.out.println("몇번 댓글을 삭제하시겠습니까?");
			
			int choose2=입력.nextInt();
			
			controller.CommentController.댓글삭제(choose2-1,boardnum);
			
			
		}
		
	}
	
	
}
