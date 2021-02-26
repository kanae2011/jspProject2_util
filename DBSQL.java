package com.webjjang.util.db;

public class DBSQL {

	///////////////게시판 쿼리//////////////////
	
	//list
	public static final String BOARD_LIST 
	= " SELECT RNUM, NO,TITLE,WRITER,TO_CHAR(WRITEDATE,'YYYY.MM.DD')WRITEDATE,HIT FROM("
		+ " SELECT ROWNUM RNUM,NO,TITLE,WRITER,WRITEDATE,HIT FROM("
		+ " SELECT NO,TITLE,WRITER,WRITEDATE,HIT FROM BOARD"
		+ " ORDER BY NO DESC)"
		+ " )WHERE RNUM BETWEEN ? AND ?";
	
	//view
	public static final String BOARD_VIEW 
	= " SELECT NO,TITLE,CONTENT,WRITER,TO_CHAR(WRITEDATE,'YYYY.MM.DD')WRITEDATE,HIT"
		+ " FROM BOARD WHERE NO = ?";
	
	
	//write
	public static final String BOARD_WRITE 
	= " INSERT INTO BOARD(NO,TITLE,CONTENT,WRITER)"
		+ "VALUES (BOARD_SEQ.NEXTVAL,?,?,?) ";
	
	
	//update
	public static final String BOARD_UPDATE
	= " UPDATE BOARD SET TITLE =? , CONTENT =? , WRITER =? WHERE NO =? ";
	
	//delete
	public static final String BOARD_DELETE 
	= " DELETE FROM BOARD WHERE NO =?";
	
	
	//increase
	public static final String BOARD_INCREASE 
	= " UPDATE BOARD SET HIT = HIT +1 WHERE NO =? ";
	
	//total
	public static final String BOARD_GET_TOTALROW 
	= " SELECT COUNT(*) FROM BOARD ";
	
	
	
	/////////////회원관리 쿼리///////////////
	
	//로그인 처리
	public static final String MEMEBER_LOGIN
	=" SELECT M.ID, M.NAME, M.GRADENO, G.GRADENAME FROM MEMBER M, GRADE G WHERE (M.ID = ? AND M.PW = ?) "
			+ "AND ( M.GRADENO = G.GRADENO)";
	
	//회원 목록 
	public static final String MEMBER_LIST
	=" SELECT RNUM,ID,NAME,GENDER,"
			+ " TO_CHAR(BIRTH,'YYYY.MM.DD')BIRTH,TEL,EMAIL,"
			+ " STATUS,GRADENO,GRADENAME FROM ("
			+ " SELECT ROWNUM RNUM, ID, NAME, GENDER, BIRTH, TEL, EMAIL,"
			+ " STATUS, GRADENO, GRADENAME FROM(SELECT M.ID, M.NAME, M.GENDER, M.BIRTH, M.TEL, M.EMAIL, "
			+ " M.STATUS, M.GRADENO, G.GRADENAME FROM MEMBER M, GRADE G WHERE M.GRADENO = G.GRADENO ORDER BY ID)"
			+ ")WHERE RNUM BETWEEN ? AND ?";
	
	//회원 등급 수정
	public static final String MEMBER_GRADE_MODIFY
	=" UPDATE MEMBER SET GRADENO =? WHERE ID =? ";
	
	//회원 정보 보기
	public static final String MEMBER_VIEW
	=" SELECT M.ID,M.NAME,M.GENDER,TO_CHAR(BIRTH,'YYYY.MM.DD')BIRTH,M.TEL,M.EMAIL,TO_CHAR(REGDATE,'YYYY.MM.DD')REGDATE,"
			+ "M.STATUS,M.GRADENO,G.GRADENAME FROM MEMBER M, GRADE G WHERE M.ID=? AND (M.GRADENO = G.GRADENO) ";
	
	
}
