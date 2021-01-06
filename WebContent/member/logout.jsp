<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Logout.jsp --%>  
<%
   //속성을 개별적으로 삭제
   session.removeAttribute("USER_ID");
   session.removeAttribute("USER_PW");
   
   //세션영역 전체를 한꺼번에 삭제
   session.invalidate();
   
   response.sendRedirect("../main/main.jsp");
%>