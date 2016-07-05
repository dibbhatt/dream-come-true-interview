package javarelated;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-12-8 
 * Time : 下午7:05:29
 */
public class SocketServer {
	public static void main(String[] args){
		BufferedReader br =null;
		PrintWriter pw = null;
		try{
			ServerSocket server = new ServerSocket(2000);
			Socket socket = server.accept();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ArrayList<Integer> arr  =new ArrayList<Integer>();
		//	arr.r
			
			pw = new PrintWriter(socket.getOutputStream());
			String s = br.readLine();
			pw.println(s);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			
			
		}
		
		
		
	}
	
	
}
