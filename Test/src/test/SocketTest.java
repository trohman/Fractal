package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",8080);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.write("Are you still there?");
			System.out.println("WRITE");
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("READ:" + in.readLine());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
