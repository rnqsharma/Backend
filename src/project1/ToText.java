package project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ToText {
	
	public List<Employee> getAllUsers(){ 
//		System.out.println("jdhgfjuk");
		List<Employee> userList = null; 
		try{
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/768980/Desktop/JavaBack/xmltotext.txt"));
			String ss1 = "" ;
	        
			String empid ="";
	        String name = "";
	        String sal = "";
			
	        while((ss1 = br.readLine()) != null){
	        	
	        	String arr[] = ss1.split(" ");
	        	name = arr[0] + " " + arr[1];
	        	empid = arr[2];
	        	sal = arr[3];
	        	System.out.println(name + " " + empid + " " + sal);
	        	
	        }
	        
//	        Db database = new Db();
//	        database.addTodb(empid, name, sal);
	        Employee emp = new Employee(empid, name, sal); 
	        userList.add(emp);
//	        
//	        saveUserList(userList);
//	          database.closeCon();
	        
		}catch(Exception e){
			
		}
		
		return userList;
//		return "henlo";
	}
	
	private void saveUserList(List<Employee> userList){ 
	      try { 
	         File file = new File("C:/Users/768980/Desktop/JavaBack/Emp111.dat"); 
	         FileOutputStream fos;  
	         fos = new FileOutputStream(file); 
	         ObjectOutputStream oos = new ObjectOutputStream(fos); 
	         oos.writeObject(userList); 
	         oos.close(); 
	      } catch (FileNotFoundException e) { 
	         e.printStackTrace(); 
	      } catch (IOException e) { 
	         e.printStackTrace(); 
	      } 
	   }

}
