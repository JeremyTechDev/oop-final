package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;

public class Flow extends Thread {

	Socket nsfd;
	DataInputStream readFlow;
	DataOutputStream writeFlow;

	public Flow(Socket sfd) {
		nsfd = sfd;
		try {
			readFlow = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
			writeFlow = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe);
		}
	}

	public void run() {
		broadcast(nsfd.getInetAddress() + " - connected");
		Server.users.add((Object) this);

		while (true) {
			try {
				String line = readFlow.readUTF();
				if (!line.equals("")) {
					line = nsfd.getInetAddress() + " - " + line;
					broadcast(line);
				}
			} catch (IOException ios) {
				Server.users.removeElement(this);
				broadcast(nsfd.getInetAddress() + " - disconnected");
				break;
			}
		}
	}

	public void broadcast(String message) {
		synchronized (Server.users) {
			Enumeration e = Server.users.elements();
			while (e.hasMoreElements()) {
				Flow f = (Flow) e.nextElement();
				try {
					synchronized (f.writeFlow) {
						f.writeFlow.writeUTF(message);
						f.writeFlow.flush();
					}
				} catch (IOException ioe) {
					System.out.println("Error: " + ioe);
				}

			}
		}

	}

}
