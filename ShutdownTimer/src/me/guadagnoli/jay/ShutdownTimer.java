package me.guadagnoli.jay;

import java.io.IOException;
import java.util.Scanner;

public class ShutdownTimer {

	public static final int SECONDS_IN_MINUTE=  60;
	public static final String SHUTDOWN_CMD = "shutdown -s";
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String token= "";
		
		while(in.hasNext()&& !(token = in.next()).equals("q"))
		{
			System.out.println("How many minutes before we shutdown?");
			try{
				int seconds = Integer.parseInt(token)*SECONDS_IN_MINUTE;
				String cmd = SHUTDOWN_CMD + "/t "+seconds;
				Process child = Runtime.getRuntime().exec(cmd);
				token = "q";
				in.close();
			}catch (NumberFormatException e ){
				System.out.println("Please enter a valid number");
			} catch (IOException e) {
				System.err.println("Failed to do something");
				e.printStackTrace();
			}
			finally {
				//do something?
				
			}
		}
		in.close();
		

	}

}
