package model;

/*
	DTO 클래스는 테이블 정의서를 보거나 JDBC의 테이블을 보고 만들면 된다!
	기본적으로 테이블과 동일한 형태로 멤버변수를 정의하면 된다
	멤버변수의 타입은 특별한 경우를 제외하고는 대부분 String으로 정의한다.(날짜관련제외)
	꼭 필요한 경우에만 int, double로 정의한다
*/
public class BbsDTO 
{
	//멤버변수의 접근지정자는 무조건 "private"!
	private String num; //일련번호
	private String title; //제목
	private String content; //내용
	private String id; //작성자아이디(member테이블 참조)
	private java.sql.Date postdate; //작성일
	private String visitcount; //조회수
	
	/*
	 	회원테이블과 join하여 이름을 가져오기 위해
	 	DTO클래스에 name컬럼을 추가한다.
	 */
	private String name; //이름
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//생성자와 getter/setter하면 된다!
	//하지만 생성자는 안만들어도 된다고 하니(뭔가 복잡해진다고 함) getter/setter만 만들자!
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public java.sql.Date getPostdate() {
		return postdate;
	}
	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}
	public String getVisitcount() {
		return visitcount;
	}
	public void setVisitcount(String visitcount) {
		this.visitcount = visitcount;
	}

}

