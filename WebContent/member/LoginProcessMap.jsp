<%@page import="util.JavascriptUtil"%>
<%@page import="model.MemberDAO"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- LoginProcess.jsp --%>
<%
	request.setCharacterEncoding("UTF-8");

//폼값받기
String id = request.getParameter("user_id");
String pw = request.getParameter("user_pw");

MemberDAO dao = new MemberDAO();

//방법3 : Map 컬렉션에 저장된 회원정보를 통해 세션영역에 저장
Map<String, String> membershipMap = dao.getMembershipMap(id, pw);
if (membershipMap.get("id") != null) 
{
	//로그인 성공시 세션영역에 아래 속성을 저장한다.
	session.setAttribute("USER_ID", membershipMap.get("id"));
	session.setAttribute("USER_PW", membershipMap.get("pass"));
	session.setAttribute("USER_NAME", membershipMap.get("name"));

	response.sendRedirect("../main/main.jsp");

} 
else 
{
	//로그인 실패시 리퀘스트 영역에 속성을 저장후 로그인 페이지로 포워드한다.
	JavascriptUtil.jsAlertLocation("회원가입된 정보가 없습니다.", "../main/main.jsp", out);
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>