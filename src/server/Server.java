package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import Logical.Shop;

public class Server extends Thread {

	public static Vector users = new Vector();

	public static void main(String args[]) {

		ServerSocket socket = null;
		try {
			socket = new ServerSocket(8080);
		} catch (IOException ioe) {
			System.out.println("Server: connection rejected");
			System.exit(1);
		}

		while (true) {
			try {
				Socket nsfd = socket.accept();
				System.out.println("Server: Connection accepted from " + nsfd.getInetAddress());
				Flow flow = new Flow(nsfd);
				Thread t = new Thread(flow);
				t.start();
			} catch (IOException ioe) {
				// nothing for now
			}
		}
	}

}
