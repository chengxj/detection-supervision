package com.ultrapower.detection.supervision.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private static PrintWriter writer = null;
	private static BufferedReader reader = null;
	private static Socket socket;
	static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	
	public static void main(String[] args) {
		try {
			socket = new Socket(InetAddress.getLocalHost(), 8080);
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				System.out.println("Client端请输入:");
				String msg = scanner.next();
				writer.println(msg);
				writer.flush();
				String input = reader.readLine();
				System.out.println("Client读到时:" + input);
				if (input.equals("exit")) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}