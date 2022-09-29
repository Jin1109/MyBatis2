package org.hta.emp.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.emp.controller.Action;
import org.hta.emp.controller.ActionForward;
import org.hta.emp.dao.EmpDAO;
import org.hta.emp.domain.Emp;

public class Term2 implements Action {
   
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
         throws ServerException, IOException {
      EmpDAO dao = new EmpDAO();
      Map<String, String> m = new HashMap<>();
      //startday, endday를 선택하지 않은 경우
      //request.getParameter("startday")는 ""입니다.
      //request.getParameter("endday")는 ""입니다.     
      m.put("start", request.getParameter("startday"));
      m.put("end", request.getParameter("endday"));
      
      List<Emp> list=dao.getTermList2(m);
      ActionForward forward = new ActionForward();
      request.setAttribute("list", list);
      forward.setPath("_1.where/list1.jsp");
      request.setAttribute("start", m.get("start"));
      request.setAttribute("end", m.get("end"));
      forward.setRedirect(false);
      return forward;
   }
}