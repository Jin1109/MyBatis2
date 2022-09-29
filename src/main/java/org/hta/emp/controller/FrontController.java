package org.hta.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.emp.action.Check;
import org.hta.emp.action.Term;
import org.hta.emp.action.Term2;
import org.hta.emp.action.Term3;

@WebServlet("*.emp")
public class FrontController extends javax.servlet.http.HttpServlet {

   private static final long serialVersionUID = 1L;
   
   protected void doProcess(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException{
      /*
       * 요청된 전체 URL중에서 포트 번호 다음 부터 마지막 문자열까지 반환됩니다.
       예) contextPath가 "/JspProject" 인 경우
           http://localhost:8088/JspProject/login.net로 요청하면 RequestURI는
           "/JspProject/login.net" 반환됩니다.
       */
      String RequestURI = request.getRequestURI();
      String contextPath = request.getContextPath();
      String command = RequestURI.substring(contextPath.length());
      ActionForward forward = null;
      Action action = null;
      
      System.out.println("RequestURI = " + RequestURI);
      System.out.println("contextPath = " + contextPath);
      System.out.println("command = " + command);
      
      // 초기화
      
      switch (command) {
      case "/term.emp" :
         action = new Term();
         break; 
      case "/term2.emp" :
         action = new Term2();
         break;
      case "/term3.emp" :
         action = new Term3();
         break;  
      case "/check.emp" :
         action = new Check();
         break; 
          
   }
   
      forward = action.execute(request, response);
      
      if(forward != null) {
         if(forward.isRedirect()) { //리다이렉트 됩니다.
            response.sendRedirect(forward.getPath());
         }else {//포워딩됩니다.
            RequestDispatcher dispatcher =
                  request.getRequestDispatcher(forward.getPath());
            dispatcher.forward(request, response);
         }
      }
   }//doProcess() end
   
   //doProcess(request, response)메서드를 구현하여 요청이 GET방식이든
   //POST방식으로 전송되어 오든 같은 메서드에서 요청을 처리할 수 있도록 하였습니다.
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doProcess(request, response);
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      doProcess(request, response);
   }

}