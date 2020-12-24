package DAO;
import VO.*;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RegiDao
{

	public void insert(RegiVo v1)
	{
		try
		{
			
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory(); 
			
			Session session = sessionfactory.openSession();
			
		    Transaction transaction = session.beginTransaction();
		    
		    session.save(v1);
		    
		    transaction.commit();
		    
		    session.close();	
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
    
   }

	public List<RegiVo> search() 
	{
		
	try
	{
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory(); 
		
		Session session = sessionfactory.openSession();
		
	    Transaction transaction = session.beginTransaction();
	    
	    Query q=session.createQuery("from RegiVo");
	    
	    List<RegiVo> l1=q.list();
	      
	    return l1;
	    
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	
	
}
	public void delete(RegiVo v2)
	{
		
		try
		{
			
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory(); 
			
			Session session = sessionfactory.openSession();
			
		    Transaction transaction = session.beginTransaction();
		    
		    session.delete(v2);
		    
		    transaction.commit();
		    
		    session.close();	
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}
	
	public  List<RegiVo> edit(RegiVo v3)
	{
     		
     		try
     		{
     		   		  			
     		   SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory(); 
     			
     		   Session session = sessionfactory.openSession();
     			
     		   Transaction transaction = session.beginTransaction();
     		   
     		   Query q=session.createQuery("from RegiVo where id='"+v3.getId()+"'");
     		    
     		   List<RegiVo> l2 =q.list();
   		    
   		       transaction.commit();
   		    
   		       session.close();
     		       
     		   return l2;   
     			
     		}
     		catch(Exception e)
     		{
     			e.printStackTrace();
     		}
     		return null;
     		
    
	}			
	
	public void update(RegiVo v4)
	{
		try
		{
			

  		   SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory(); 
  			
  		   Session session = sessionfactory.openSession();
  			
  		   Transaction transaction = session.beginTransaction();
  		   
  		   session.update(v4);
  		   
  		   transaction.commit();
		    
		   session.close();		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
