package Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Board;


public class BoardDao {

	Connection conn;
	
	private static BoardDao boardDao=new BoardDao();
	
	public static BoardDao getBoardDao() {
		return boardDao;
	}
	
	public BoardDao() {
		//생성자 안에 커넥션 넣어놓으면 다른곳에서 생성할때 바로 sql과 연동됨. [초기값]
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/console?serverTimezone=UTC" , "root" , "1234");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}//생성자 끝
	
	
	
	//게시판 접속 시 전체게시판 검사할 메소드
	public ArrayList<Board> allboard(){
		
		ArrayList<Board> boards=new ArrayList<>();
		
		String SQL="select * from board";
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board board=new Board();
				
				board.setTitle(rs.getString(1));
				board.setContent(rs.getString(2));
				board.setWriterid(rs.getString(3));
				board.setDate(rs.getString(4));
				board.setCount(rs.getInt(5));
			
				
				boards.add(board);
				
			}
			
			return boards;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			return boards;
	}
	
	
	
	//글쓰기
	public int boardwrite(Board board) {
	
		String SQL="insert into board( title , content , writerid , date ,count )"+"values( ? , ? , ? , ? , ? )";
	//	String SQL="insert into board( title , content , writerid )"+"values(?,?,?)";

		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(SQL);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriterid());	
			pstmt.setString(4, board.getDate());
			pstmt.setInt(5, board.getCount());
		
			
			pstmt.executeUpdate();
			
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
		return -1;
		
	}//글쓰기 끝
	

	//수정
	public int boardupdate(Board board) {
		
		
		
		
		return 1;
	}
	
	
	public int boarddelete(Board board) {
		return 1;
	}
	
}
