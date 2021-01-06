package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil 
{
	/*
	  	Java영역에서는 JSP의 내장객체를 바로 사용하는 것은 불가능하다.
	  	JSP에서 매개변수로 내장객체를 전달하면 해당 타입으로 받아서 사용한다.
	  	request, response 내장객체를 아래와 같이 받아서 사용한다.
	 
	 	형식]
	 	makeCookie함수명
		(request내장객체, response내장객체, 쿠키명, 쿠키값, 설정시간)
	 */
	public static void makeCookie
		(HttpServletRequest req, HttpServletResponse resp,
				String cName, String cValue, int time)
		{
			Cookie cookie = new Cookie(cName, cValue); //쿠키객체생성
			cookie.setPath(req.getContextPath()); //경로설정
			cookie.setMaxAge(time); //시간설정
			resp.addCookie(cookie); //응답헤더에 쿠키 추가 후 클라이언트로 전송
		}
}
