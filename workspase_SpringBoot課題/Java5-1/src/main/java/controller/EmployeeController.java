package controller;

/**
 * 社員情報管理コントローラー（メインサーブレット）
 * 
 * @author s.nanami
 * @since 2019/03/15
 * 
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.EmployeeBean;
import model.service.EmploeeService;

public class EmployeeController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			//login.htmlから送信されたIDとPassWordの値を取得できるように修正します
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			
			EmploeeService employeeService =new EmploeeService();
			
			EmployeeBean employeeBean=new EmployeeBean();
			
			employeeBean=employeeService.search(id, password);
			
			request.setAttribute("EmployeeBean", employeeBean);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ServletContext context=this.getServletContext();
			RequestDispatcher dispatcher=context.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
