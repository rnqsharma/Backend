package project1;
import java.io.*;
import java.net.*;
 

public class UDPReceiver2
{
	String lineFin;
	static String line1="";
	String ext1;
//	String line;
	String type;
	
	

	public static void main(String... s)
	{
		try
		{
			byte data[]= new byte[1024];
			DatagramSocket ds= new DatagramSocket(1098);
			DatagramPacket dp= new DatagramPacket(data,data.length);
			String line=null;
			while(true)
			{
				ds.receive(dp);
				line= new String(dp.getData(),0,dp.getLength());
				String type="";
//				String dest = "C:/Users/768980/Desktop/JavaBack/Content/data1";
//				System.out.println(line);
//				FileDetails fileDet = new FileDetails();
//				fileDet.setContent(line);
				FileDetails.setContent(line);
				System.out.println("fdjgbn" + FileDetails.getContent());
				BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/768980/Desktop/JavaBack/dddd.txt"));
				writer.write(FileDetails.getContent());
				writer.close();
//				line1=line1+line;
//				UserDao ud= new UserDao();
//				ud.sendFile(fileDet.getContent());
//				
				
				

				
			}
//			ds.close();
			
//			System.out.println(line);
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}

	
}