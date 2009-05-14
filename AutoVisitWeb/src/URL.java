import javax.swing.*;
import java.io.*; 
public class URL
{
	public static void main(String[] args) throws Exception {
		String input=JOptionPane.showInputDialog("The start number:");
		int k=Integer.parseInt(input);
		for (int i=1; i<=10; i++,k++){
			try{ 
				String command = "C:/Program Files/Maxthon2/Maxthon.exe http://home.xiaonei.com/getuser.do?id="+k;
				Runtime.getRuntime().exec(command); 
				try 
				{ 
					Thread.sleep(40000); 
				} catch(Exception e){} 
				
			}
			catch(IOException ex)  {} 
		}
	} 
} 

