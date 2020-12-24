package Controller;
import VO.*;
import DAO.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegiController")
public class RegiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegiController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        String s1=request.getParameter("flag");
		        
		        if(s1.equals("search"))
		        {
		        RegiDao da1=new RegiDao();
		
		        List<RegiVo> ls=(da1.search());
		    
		        System.out.println(ls.size());
		    	HttpSession session=request.getSession();
				session.setAttribute("st2",ls);
				response.sendRedirect("Search.jsp");
		        }
		        
		        else if(s1.equals("delete"))
				{
					
				Integer s2=Integer.parseInt(request.getParameter("x"));	
				
				RegiVo v2=new RegiVo();
				v2.setId(s2);
				
				RegiDao da2=new RegiDao();
				da2.delete(v2);
				
				response.sendRedirect("Search.jsp");	
					
				}
		        else if(s1.equals("edit"))
		        {
		        	int s3=Integer.parseInt(request.getParameter("y"));
		        	
		        	RegiVo v3=new RegiVo();
		        	v3.setId(s3);
		        	
		        	RegiDao da3=new RegiDao();
			    	try
			    	{
			    		
			    	List<RegiVo> ls2=da3.edit(v3);
			    	HttpSession session=request.getSession();
					session.setAttribute("st3", ls2);
		 			response.sendRedirect("Edit.jsp");
			    	
			    	}
			    	catch(Exception e)
			    	{
			    		e.printStackTrace();
			    	}
			    	
		        }
		       
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String st=request.getParameter("flag");
	
		if(st.equals("add"))
		{
		String st1=request.getParameter("fn");
		String st2=request.getParameter("ln");
		
		RegiVo v1=new RegiVo();
		v1.setFirstname(st1);
		v1.setLastname(st2);
		
		RegiDao d1=new RegiDao();
		d1.insert(v1);
		
		response.sendRedirect("Insert.jsp");
		}
		
		else if(st.equals("update"))
		{
			try
			{
			String z1=request.getParameter("first");
			String z2=request.getParameter("last");
			int b=Integer.parseInt(request.getParameter("id"));
			
			RegiVo v4=new RegiVo();
			v4.setFirstname(z1);
			v4.setLastname(z2);
			v4.setId(b);
			
			RegiDao da4=new RegiDao();
	      
			da4.update(v4);	 
			List<RegiVo> l4=da4.search();
			HttpSession s=request.getSession();
			s.setAttribute("list4", l4);

			response.sendRedirect("Search.jsp");
		     }
		    catch(Exception e)
		    {
			e.printStackTrace();
		     }
		}
	}

}
