package com.ultrapower.detection.supervision.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	private static final int PORT = 8080;
	private static BufferedReader reader = null;
	private static PrintWriter writer = null;
	private static ServerSocket serverSocket;
	private static Socket socket;
	static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("服务器正常启动...");
			socket = serverSocket.accept();
			System.out.println("连接成功" + socket.getRemoteSocketAddress());
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				String msg = reader.readLine();
				System.out.println("Server读到:" + msg);
				System.out.println("Server端请输入:");
				String input = scanner.next();
				writer.println(input);
				writer.flush();
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
