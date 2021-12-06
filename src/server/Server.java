package server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server extends Thread {

	public static void main(String args[]) {

		InputStream readStrem = null;
		OutputStream writeStream = null;
		ServerSocket serverSocket = null;
		Socket socket = null;
		String outputFilename = System.getProperty("user.dir") + "/backups/shop_backup_";

		try {
			serverSocket = new ServerSocket(7777);
		} catch (IOException ioe) {
			System.out.println("Server: connection rejected. Error: " + ioe);
			System.exit(1);
		}

		System.out.println("Server: running on port 7777...");

		try {
			socket = serverSocket.accept();
			System.out.println("Server: accepted connection from " + socket.getInetAddress());

			String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			readStrem = socket.getInputStream();
			writeStream = new FileOutputStream(outputFilename + timeStamp + ".dat");
			byte[] bytes = new byte[16 * 1024];

			int count;
			while ((count = readStrem.read(bytes)) > 0) {
				writeStream.write(bytes, 0, count);
			}
			System.out.println("Server: reading done");

			writeStream.close();
			readStrem.close();
			socket.close();
			serverSocket.close();
		} catch (IOException ioe) {
			System.out.println("Server error: " + ioe);
			System.exit(1);
		}
	}
}
