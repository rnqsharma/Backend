package project1;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;  
@Path("/UserService") 

public class UserService {  
   UserDao userDao = new UserDao();
//   long start = System.currentTimeMillis();
   UserDaoCsv userDaoCsv = new UserDaoCsv();
   ToText oo = new ToText();
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_JSON)
   public List<Employee> getUsers(){
//	   FileDetails fff = new FileDetails();
//	   System.out.println(fff.getContent());
//	   UserDao uu = new UserDao();
//	   
//	   List<Employee> al = uu.getAllUsers();
//	   long end = System.currentTimeMillis();
//	   System.out.println("Time taken :- " + (end - start));
//	   return userDaoCsv.getAllUsers();
//      return userDao.getAllUsers();
	   return oo.getAllUsers();
//	   return al;
//	   return userDaoCsv.getAllUsers();
   }  
}
