package project1;

import java.util.ArrayList; 
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.*;
import java.nio.charset.Charset;

public class UserDao { 
//	static String str = "" ;
   public List<Employee> getAllUsers(){ 
      
      List<Employee> userList = null; 
      try { 
    	  
//    	  File inputFile = new File("C:/Users/768980/Desktop/JavaBack/dataXml.xml");
    	  
    	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	 
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//          	FileDetails fileDet = new FileDetails();
//          	String str = fileDet.getContent();
          BufferedReader br = new BufferedReader(new FileReader("C:/Users/768980/Desktop/JavaBack/dddd.txt"));
          String ss="", str="";
          String ss1 = br.readLine();
          System.out.println(ss1);
          StringBuilder sbr = new StringBuilder();
          while((ss = br.readLine() )!= null){
//        	  sbr.append(ss);
        	  System.out.println(ss);
          }
          str = sbr.toString();
//          System.out.println(FileDetails.getContent()); 
//          System.out.println(FileDetails.str.length());
//          	System.out.println(str);
          //String str= UDPReceiver2.line1;
          System.out.println(str);
//          GetDet oo= new GetDet();
          InputStream is = new ByteArrayInputStream(ss1.getBytes());
          
//          Document doc = dBuilder.parse(inputFile);
//          FileInputStream fis = new FileInputStream(ss1);
          Document doc = dBuilder.parse(is);
          doc.getDocumentElement().normalize();
          System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
          NodeList nList = doc.getElementsByTagName("emp");
          System.out.println("----------------------------");
          File file = new File("C:/Users/768980/Desktop/JavaBack/Emp111.dat");
          userList = new ArrayList<Employee>(); 
          
          Db database = new Db();
////          
          for (int temp = 1; temp < nList.getLength(); temp++) {
             Node nNode = nList.item(temp);
             
             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
                 String name =  eElement.getElementsByTagName("name").item(0).getTextContent();
                 String sal = eElement.getElementsByTagName("salary").item(0).getTextContent();
                 String empid = eElement.getAttribute("empid");
                 String res = name + " " + sal + " " + empid;
                 
//                 System.out.println(empid + " " + name);
                  database.addTodb(empid, name, sal);
                  
   	              Employee emp = new Employee(empid, name, sal); 
   	              
   	              userList.add(emp); 
   	              
                 
              }
           }
          saveUserList(userList);
          database.closeCon();
             

         
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