package project1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserDaoCsv {
	 public List<Employee> getAllUsers(){ 
	      
	      List<Employee> userList = null; 
	      try { 
	    	  
	    	  File inputFile = new File("C:/Users/768980/Desktop/JavaBack/abc.csv");
	    	  
	    	  
	    	  
	    	  String file1 = "C:/Users/768980/Desktop/JavaBack/abc.csv",txtFile="abc.txt";
	 		 BufferedReader br = null;//For Read CSV File
	  		 BufferedWriter br2=null;//For Write a file in which you want to write
	   		 String words = "";
	  		 String separator = ",";
	  		 
	  		 
	  		 br = new BufferedReader(new FileReader(file1));
			  br2=new BufferedWriter(new FileWriter(txtFile,true));
			  
			  File file = new File("C:/Users/768980/Desktop/JavaBack/Emp111.dat");
	          userList = new ArrayList<Employee>(); 
			  while ((words = br.readLine()) != null) 
			  {
 			  	String[] code = words.split(separator);
 			  	String name = code[0];
 			  	String salary = code[1];
 			  	String empid = code[2];
 			  	
 			  	
 			   Employee emp = new Employee(empid, name, salary); 
	              
	              userList.add(emp);
		    }
	  		 
	          
	           
	          saveUserList(userList);
	             
	             

	         
	      } catch (IOException e) { 
	         e.printStackTrace(); 
	      }  catch(Exception e){
	    	 e.printStackTrace();
	      }
	      return userList; 
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
