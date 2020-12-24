package Controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.RegVO;
import DAO.RegDAO;

@WebServlet("/RegController")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String first=request.getParameter("fn");
		String last=request.getParameter("ln");
		
		RegVO vo=new RegVO();
		
		vo.setFn(first);
		vo.setLn(last);
		
		RegDAO d1=new RegDAO();
		d1.insert(vo);

		response.sendRedirect("HibernateReg.jsp");
	}

}
